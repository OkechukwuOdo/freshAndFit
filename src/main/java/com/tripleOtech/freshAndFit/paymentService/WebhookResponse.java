package com.tripleOtech.freshAndFit.paymentService;

import lombok.Data;

@Data
public class WebhookResponse {
    private String event;
    private PaymentTransaction data;
}
