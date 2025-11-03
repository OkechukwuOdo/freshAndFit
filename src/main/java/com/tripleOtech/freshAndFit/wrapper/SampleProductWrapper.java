package com.tripleOtech.freshAndFit.wrapper;

import com.tripleOtech.freshAndFit.dto.requestDtos.ProductRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDtos.ProductResponseDto;
import com.tripleOtech.freshAndFit.entity.FoodItem;
import org.springframework.stereotype.Service;

@Service
public class SampleProductWrapper {
    public static FoodItem productRequestToSampleProduct(ProductRequestDto requestDto){

        return FoodItem.builder()
                .productName(requestDto.getProductName())
                .build();
    }

    public static ProductResponseDto productToProductResponse(ProductRequestDto requestDto){

        return ProductResponseDto.builder()
                .productName(requestDto.getProductName())
                .build();
    }
}
