package com.tripleOtech.freshAndFit.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long productId;
    private String productName;
    private String category;
    private List<Packaging> packaging_pricing;
    private String description;
    private String sku;
    private Double discount;
    private Double finalPrice;
    private Integer stockQuantity;
    private Boolean isInStock;
    private List<String> images;
    private Double weight;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
}
