package com.tripleOtech.freshAndFit.service.implementation;

import com.tripleOtech.freshAndFit.dto.requestDtos.ProductRequestDto;
import com.tripleOtech.freshAndFit.repository.ProductRepository;
import com.tripleOtech.freshAndFit.service.ProductService;
import com.tripleOtech.freshAndFit.wrapper.SampleProductWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public String creatProduct(ProductRequestDto requestDto) {
        productRepository.save(SampleProductWrapper.productRequestToSampleProduct(requestDto));
        return " Product Created";
    }
}
