package com.tripleOtech.freshAndFit.monnify;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class MonnifyPaymentService {
    @Value(value = "${monnify.api.base-url}")
    private String baseUrl;

    @Value(value = "${monnify.contract.code}")
    private String contractCode;

    private final MonnifyAuthService authService;

    public Map<String, Object> initiatePayment(MonnifyPaymentRequest monnifyPaymentRequest){
        String paymentUrl = baseUrl + "/transactions/init-transaction";

        String accessToken = authService.authenticate();

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("amount", monnifyPaymentRequest.getAmount());
        requestBody.put("customerEmail", monnifyPaymentRequest.getCustomerEmail());
        requestBody.put("currencyCode", monnifyPaymentRequest.getCurrency());
        requestBody.put("paymentDescription", monnifyPaymentRequest.getPaymentDescription());
        requestBody.put("contractCode", contractCode);
        requestBody.put("redirectUrl", "http://localhost:8080/payment/callback");

        Map<String, Object> response = restTemplate.postForObject(
                paymentUrl,
                requestBody,
                Map.class,
                Map.of("Authorization", "Bearer " + accessToken));
        if (response == null) {
            throw new RuntimeException("Failed to initiate payment with Monnify.");
        }

        return response;
    }
}
