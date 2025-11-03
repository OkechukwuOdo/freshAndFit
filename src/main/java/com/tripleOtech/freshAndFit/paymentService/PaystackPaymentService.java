package com.tripleOtech.freshAndFit.paymentService;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaystackPaymentService implements PaymentService {
    private final PaystackConfig config;
    private final TransactionRepository transactionRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    @Override
    public PaymentResponse initializePayment(PaymentRequest request) {
        String url = config.getBaseUrl() + "/transaction/initialize";
        String reference = PaystackUtil.generateReference(request.getPayment_type(),request.getEmail());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(config.getSecretKey());

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("payment_type", request.getPayment_type());
        metadata.put("student_id", request.getStudent_id());

        Map<String, Object> payload = new HashMap<>();
        payload.put("email", request.getEmail());
        payload.put("amount", request.getAmount()*100);
        payload.put("reference",reference);
        payload.put("channels", List.of("card","bank_transfer","ussd","bank"));
        payload.put("metadata", metadata);
        HttpEntity< Map<String, Object> > entity = new HttpEntity<>(payload, headers);
        ResponseEntity<PaymentResponse> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, PaymentResponse.class);
        return response.getBody();
    }

    @Override
    public boolean verifyTransaction(String reference) {
        String url = config.getBaseUrl()+"/transaction/verify/" + reference;
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(config.getSecretKey());
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, Map.class);

        return response.getBody().get("status").equals(Boolean.TRUE);
    }

    @Override
    public String handlePaystackWebhook(String payload, String signature) {
        boolean isVerified = PaystackUtil.verifySignature(payload, signature, config.getSecretKey());
        if (!isVerified) {
            return "Invalid signature";
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            WebhookResponse event = objectMapper.readValue(payload, WebhookResponse.class);

            if ("charge.success".equals(event.getEvent())) {
                String reference = event.getData().getReference();
                Optional<PaymentTransaction> optionalPayment = transactionRepository.findByReference(reference);

                if (optionalPayment.isPresent()) {
                    PaymentTransaction payment = optionalPayment.get();
                    payment.setStatus("COMPLETED");
                    payment.setPaymentDate(LocalDate.now());
                    transactionRepository.save(payment);

                    return ("Payment confirmed and booking updated");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ("Webhook error");
        }

        return ("Ignored");
    }
}
