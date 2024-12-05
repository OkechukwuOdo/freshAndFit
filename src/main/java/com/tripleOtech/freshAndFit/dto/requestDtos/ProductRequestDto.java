package com.tripleOtech.freshAndFit.dto.requestDtos;

import com.tripleOtech.freshAndFit.entity.PackageAndPrice;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    private String productName;
    private String productCategory;
    private String price;
    private boolean isAvailable;
    private Integer stuckQuantity;


}
