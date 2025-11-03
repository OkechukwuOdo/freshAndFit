package com.tripleOtech.freshAndFit.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private AppDriver driver;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    private LocalDateTime assignedAt;
    private LocalDateTime deliveredAt;
}
