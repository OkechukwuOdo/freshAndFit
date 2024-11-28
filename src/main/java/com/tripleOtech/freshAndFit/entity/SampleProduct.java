package com.tripleOtech.freshAndFit.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SampleProduct {
    @Id
    private Long id;
    private String productName;
    private String productCategory;
    private String price;
    private boolean isAvailable;
    private Integer stuckQuantity;
    private LocalDate createdAt;
    @OneToMany(
            mappedBy = "sampleProduct",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PackageAndPrice> packageAndPrices;

}
