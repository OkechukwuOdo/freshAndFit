package com.tripleOtech.freshAndFit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Packaging {
    private String unit;
    private BigDecimal price;
    private BigDecimal discount;
    private BigDecimal finalPrice;
    private int quantity;
    private int weight;
}
