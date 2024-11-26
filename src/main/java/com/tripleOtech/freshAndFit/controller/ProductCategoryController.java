package com.tripleOtech.freshAndFit.controller;

import com.tripleOtech.freshAndFit.dto.requestDto.ProductCategoryRequest;
import com.tripleOtech.freshAndFit.dto.responseDto.ApiResponse;
import com.tripleOtech.freshAndFit.dto.responseDto.UserRegistrationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/product")
@AllArgsConstructor
public class ProductCategoryController {
    @PostMapping
    public ResponseEntity<ApiResponse<?>> createProductCategory(ProductCategoryRequest productCategoryRequest){
        return null;
    }

}
