package com.tripleOtech.freshAndFit.dto.responseDtos;

import com.tripleOtech.freshAndFit.entity.PackageAndPrice;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {
    private Long id;
    private String productName;
    private String productCategory;
    private String price;
    private boolean isAvailable;
    private Integer stuckQuantity;
    private LocalDate createdAt;
    private List<PackageAndPrice> packageAndPrices;
}
