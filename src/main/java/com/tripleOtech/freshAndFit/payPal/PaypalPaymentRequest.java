package com.tripleOtech.freshAndFit.payPal;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaypalPaymentRequest {
    private Double total;
    private String currency;
    private String method;
    private String intent;
    private String description;
    private String cancelUrl="http://localhost:8080/api/v1/payment/cancel";
    private String successUrl="http://localhost:8080/api/v1/payment/success";
}
