package com.tripleOtech.freshAndFit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PackageAndPrice {

    @Id
    @GeneratedValue
    private Long id;
    private String pack;
    private BigDecimal price;
    private BigDecimal discount;
    private BigDecimal finalPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    private SampleProduct sampleProduct;

}
