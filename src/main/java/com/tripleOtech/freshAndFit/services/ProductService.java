package com.tripleOtech.freshAndFit.services;

import com.tripleOtech.freshAndFit.dto.requestDto.ProductRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDto.ProductResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductResponseDto creatProduct(ProductRequestDto productRequestDto);
}
