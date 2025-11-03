package com.tripleOtech.freshAndFit.dto.responseDtos;

import com.tripleOtech.freshAndFit.entity.ProductCategory;
import com.tripleOtech.freshAndFit.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCategoryResponse {
    private Long id;
    private String categoryName;
    private String imageUrl;
    private List<FoodItem> productList;

    private ProductCategoryResponse(ProductCategory productCategory){
        id=productCategory.getId();
        categoryName=productCategory.getCategoryName();
        imageUrl=productCategory.getImageUrl();
        productList=productCategory.getProductList();
    }
    public static ProductCategoryResponse creatProductCategoryResponseInstance(ProductCategory productCategory){
        return new ProductCategoryResponse(productCategory);
    }
}
