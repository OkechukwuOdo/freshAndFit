package com.tripleOtech.freshAndFit.service;

import com.tripleOtech.freshAndFit.dto.requestDtos.ProductRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDtos.ProductCategoryResponse;


public interface ProductService {
    String creatProduct(ProductRequestDto requestDto);

 ProductCategoryResponse createProductCategory(String categoryName);

    ProductCategoryResponse addProductToCategory(Long productId, Long categoryId);


}
