package com.tripleOtech.freshAndFit.service.implementation;

import com.tripleOtech.freshAndFit.dto.requestDtos.ProductRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDtos.ProductCategoryResponse;
import com.tripleOtech.freshAndFit.entity.ProductCategory;
import com.tripleOtech.freshAndFit.entity.FoodItem;
import com.tripleOtech.freshAndFit.repository.ProductCategoryRepository;
import com.tripleOtech.freshAndFit.repository.ProductRepository;
import com.tripleOtech.freshAndFit.service.ProductService;
import com.tripleOtech.freshAndFit.wrapper.SampleProductWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    @Override
    public String creatProduct(ProductRequestDto requestDto) {
        productRepository.save(SampleProductWrapper.productRequestToSampleProduct(requestDto));
        return " Product Created";
    }

    @Override
    public ProductCategoryResponse createProductCategory(String categoryName) {
        ProductCategory productCategory= ProductCategory.productCategoryInstance(categoryName);
        ProductCategory newCategory= productCategoryRepository.save(productCategory);
        return ProductCategoryResponse.creatProductCategoryResponseInstance(newCategory);
    }

    @Override
    public ProductCategoryResponse addProductToCategory(Long productId, Long categoryId) {
        FoodItem product= productRepository.findById(productId).orElseThrow();
        ProductCategory productCategory=productCategoryRepository.findById(categoryId).orElseThrow();
        List<FoodItem> sampleProducts=productCategory.getProductList();
        if (sampleProducts==null){
            sampleProducts=new ArrayList<>();
        }
        sampleProducts.add(product);
        productCategory.setProductList(sampleProducts);
        productCategoryRepository.save(productCategory);
        return null;
    }

}
