package com.tripleOtech.freshAndFit.service;

import com.tripleOtech.freshAndFit.dto.responseDtos.ApiResponse;
import com.tripleOtech.freshAndFit.entity.AppUser;
import com.tripleOtech.freshAndFit.entity.Cart;
import com.tripleOtech.freshAndFit.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    ApiResponse<Order> placeOrder(AppUser user, Cart cart, String paymentMethod);

}
