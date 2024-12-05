package com.tripleOtech.freshAndFit.monnify;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MonnifyPaymentRequest {
    private String customerEmail;
    private double amount;
    private String currency;
    private  String paymentDescription;
}
