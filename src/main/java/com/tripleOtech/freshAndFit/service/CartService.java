package com.tripleOtech.freshAndFit.service;

import com.tripleOtech.freshAndFit.dto.responseDtos.ApiResponse;
import com.tripleOtech.freshAndFit.dto.responseDtos.PaginationResponse;
import com.tripleOtech.freshAndFit.entity.Cart;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
     void creatCart(Long userId);
     ApiResponse<Cart> addToCart(Long UserId, Long productId);
//     ApiResponse<Cart> editUser(Long appUserId, AppUserRequestDto user);
     ApiResponse<Cart> getCartByUser(Long userId);
     PaginationResponse getAllCart(int offset, int limit);
//     ApiResponse<AppUser> deleteUser(Long appUserId);

}
