package com.tripleOtech.freshAndFit.dto.requestDto;

import com.tripleOtech.freshAndFit.entity.Packaging;
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
public class ProductRequestDto {
    private String productName;
    private String category;
    private List<Packaging> packaging_pricing;
    private String description;
    private String sku;
    private Integer stockQuantity;
    private Boolean isInStock;
    private List<String> images;
    private Double weight;
}
