package com.tripleOtech.freshAndFit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Double price;
    private Double discount;
    private Double finalPrice;
    private String imageUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    private FoodItem sampleProduct;

}
