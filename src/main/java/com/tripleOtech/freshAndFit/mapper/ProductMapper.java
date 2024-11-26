package com.tripleOtech.freshAndFit.mapper;

import com.tripleOtech.freshAndFit.dto.requestDto.ProductRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDto.ProductResponseDto;
import com.tripleOtech.freshAndFit.entity.Product;

public class ProductMapper {

    public static Product productRequestToProductEntity(ProductRequestDto requestDto){
       return Product.builder()
               .productName(requestDto.getProductName())
               .category(requestDto.getCategory())
               .description(requestDto.getDescription())
               .images(requestDto.getImages())
               .build();
    };

    public static ProductResponseDto productEntityToProductResponse(Product product){
        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .category(product.getCategory())
                .description(product.getDescription())
                .images(product.getImages())
                .build();
    };
}
