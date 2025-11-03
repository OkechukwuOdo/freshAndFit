package com.tripleOtech.freshAndFit.paymentService;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentTransaction {
    @Id
    @GeneratedValue
    private Long id;
    private String method; // CARD, BANK_TRANSFER, CASH
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String status;
    private String reference;
    private String customer_email;
    private boolean verifiedByAdmin = false;
}
