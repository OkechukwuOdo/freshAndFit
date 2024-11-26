package com.tripleOtech.freshAndFit.dto.requestDto;

import com.tripleOtech.freshAndFit.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryRequest {
    private String Name;
    private String image;
    private List<Product> productList;

}
