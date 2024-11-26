package com.tripleOtech.freshAndFit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private Long orderItemId;
    private Product product;
    private Integer quantity;
    private Double unitPrice;
    private Double subTotal;
}
