package com.tripleOtech.freshAndFit.paymentService;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    PaymentResponse initializePayment(PaymentRequest request);
    boolean verifyTransaction(String reference);
    String handlePaystackWebhook( String payload,
                                  String signature);
}
