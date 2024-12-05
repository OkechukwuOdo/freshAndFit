package com.tripleOtech.freshAndFit.wrapper;

import com.tripleOtech.freshAndFit.dto.requestDtos.AppUserRequestDto;
import com.tripleOtech.freshAndFit.dto.requestDtos.ProductRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDtos.AppUserResponseDto;
import com.tripleOtech.freshAndFit.dto.responseDtos.ProductResponseDto;
import com.tripleOtech.freshAndFit.entity.AppUser;
import com.tripleOtech.freshAndFit.entity.SampleProduct;
import org.springframework.stereotype.Service;

@Service
public class SampleProductWrapper {
    public static SampleProduct productRequestToSampleProduct(ProductRequestDto requestDto){

        return SampleProduct.builder()
                .productName(requestDto.getProductName())
                .build();
    }

    public static ProductResponseDto productToProductResponse(ProductRequestDto requestDto){

        return ProductResponseDto.builder()
                .productName(requestDto.getProductName())
                .build();
    }
}
