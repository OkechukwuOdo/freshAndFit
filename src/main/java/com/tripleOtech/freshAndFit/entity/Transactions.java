package com.tripleOtech.freshAndFit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    @Column(nullable = false)
    private BigDecimal amount;
    @Column(nullable = false)
    private String paymentMethod; // e.g., CREDIT_CARD, PAYPAL, STRIPE

    @Column(nullable = false)
    private String status; // e.g., SUCCESS, PENDING, FAILED

    @Column(nullable = false)
    private LocalDateTime transactionDate;

    private String gatewayResponse;
}
