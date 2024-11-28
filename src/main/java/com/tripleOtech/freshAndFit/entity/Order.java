package com.tripleOtech.freshAndFit.entity;

import com.tripleOtech.freshAndFit.entity.enums.OrderStatus;
import com.tripleOtech.freshAndFit.entity.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser user;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();
    @Column(nullable = false)
    private double totalAmount;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Address shippingAddress;
    @Enumerated(value = EnumType.STRING)
    private PaymentMethod paymentMethod; // e.g., Credit Card, PayPal, etc.

    @Column(nullable = true)
    private String trackingNumber;
}
