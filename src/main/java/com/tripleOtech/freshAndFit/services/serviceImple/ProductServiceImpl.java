package com.tripleOtech.freshAndFit.services.serviceImple;

import com.tripleOtech.freshAndFit.dto.requestDto.ProductRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDto.ProductResponseDto;
import com.tripleOtech.freshAndFit.entity.Product;
import com.tripleOtech.freshAndFit.mapper.ProductMapper;
import com.tripleOtech.freshAndFit.repository.ProductRepository;
import com.tripleOtech.freshAndFit.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private  final ProductRepository productRepo;

    @Override
    public ProductResponseDto creatProduct(ProductRequestDto productRequestDto) {
      Product product= ProductMapper.productRequestToProductEntity(productRequestDto);
        return ProductMapper.productEntityToProductResponse(productRepo.save(product));
    }
}
