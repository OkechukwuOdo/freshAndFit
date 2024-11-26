package com.tripleOtech.freshAndFit.controller;

import com.tripleOtech.freshAndFit.dto.requestDto.AppUserRequestDto;
import com.tripleOtech.freshAndFit.dto.requestDto.ProductRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDto.ApiResponse;
import com.tripleOtech.freshAndFit.dto.responseDto.UserRegistrationResponse;
import com.tripleOtech.freshAndFit.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping()
    public ResponseEntity<ApiResponse<?>> register(@RequestBody ProductRequestDto request) {
        return ResponseEntity.ok(ApiResponse.createdSuccess(productService.creatProduct(request)));
    }
}
