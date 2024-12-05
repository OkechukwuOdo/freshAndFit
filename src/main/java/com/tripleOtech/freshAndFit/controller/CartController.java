package com.tripleOtech.freshAndFit.controller;

import com.tripleOtech.freshAndFit.dto.responseDtos.ApiResponse;
import com.tripleOtech.freshAndFit.repository.CartRepository;
import com.tripleOtech.freshAndFit.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
@PostMapping("/add")
    public ResponseEntity<ApiResponse<?>> addToCart(Long userId, Long productId){
        return ResponseEntity.ok(cartService.addToCart(userId,productId));
    }
}
