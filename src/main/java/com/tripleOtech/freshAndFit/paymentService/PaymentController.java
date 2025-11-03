package com.tripleOtech.freshAndFit.paymentService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/initiate")
    public ResponseEntity<?> initiatePayment(@RequestBody PaymentRequest request) {
        PaymentResponse response = paymentService.initializePayment(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/verify-transaction")
    public ResponseEntity<?> verifyTransaction(@RequestBody String request) {
        boolean response = paymentService.verifyTransaction(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/haystack")
    public ResponseEntity<String> handlePaystackWebhook(@RequestBody String payload,
                                                        @RequestHeader("x-paystack-signature") String signature){
        return ResponseEntity.ok(paymentService.handlePaystackWebhook(payload, signature));
    }
}