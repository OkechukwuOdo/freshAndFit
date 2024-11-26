package com.tripleOtech.freshAndFit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private Long cartItemId;
    private Product product;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
    private Double totalWeight;
}
