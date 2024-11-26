package com.tripleOtech.freshAndFit.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long orderId;
    private AppUser customer;
    private Address destination;
    private AppUser rider;
    private String orderStatus; // e.g.,
    private Double totalAmount;
    private String currency;
    private Double deliveryCost;
    private LocalDateTime expectedDeliveryDateAndTime;
    private String trackingNumber;
    private String paymentMethod;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
//    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}
