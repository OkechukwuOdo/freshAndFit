package com.tripleOtech.freshAndFit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodItem {
    @Id
    private Long id;
    private String productName;
    @ManyToOne
    @JoinColumn(name = "productCategory_id")
    private ProductCategory category;
    private boolean isAvailable;
    @Column(nullable = false, updatable = false)
    private LocalDate createdAt;
    @OneToMany(
            mappedBy = "sampleProduct",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PackageAndPrice> packageAndPrices;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private int quantityInStuck; // Available stock

    @Column(nullable = true)
    private String imageUrl; // Link to the product image

    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
