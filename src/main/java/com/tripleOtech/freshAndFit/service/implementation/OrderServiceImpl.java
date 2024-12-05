package com.tripleOtech.freshAndFit.service.implementation;

import com.tripleOtech.freshAndFit.dto.responseDtos.ApiResponse;
import com.tripleOtech.freshAndFit.entity.*;
import com.tripleOtech.freshAndFit.entity.enums.OrderStatus;
import com.tripleOtech.freshAndFit.entity.enums.PaymentMethod;
import com.tripleOtech.freshAndFit.repository.AppUserRepository;
import com.tripleOtech.freshAndFit.repository.OrderItemRepository;
import com.tripleOtech.freshAndFit.repository.OrderRepository;
import com.tripleOtech.freshAndFit.repository.ProductRepository;
import com.tripleOtech.freshAndFit.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final AppUserRepository appUserRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    public ApiResponse<Order> placeOrder(AppUser user, Cart cart, String paymentMethod) {
        if (cart.getCartItems().isEmpty()) {
            throw new RuntimeException("Cart is empty!");
        }
        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);
        order.setPaymentMethod(PaymentMethod.Ussd);
        order.setTotalAmount(0);

        for (CartItem cartItem : cart.getCartItems()) {
            SampleProduct product = cartItem.getProduct();

            if (product.getQuantityInStuck() < cartItem.getQuantity()) {
                throw new RuntimeException("Product stock insufficient for: " + product.getProductName());
            }
//            product.getQuantityInStuck(product.getQuantityInStuck() - cartItem.getQuantity());
            productRepository.save(product);
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setSubtotal(cartItem.getSubtotal());
            order.getOrderItems().add(orderItem);
}
        return ApiResponse.buildSuccessTxn (orderRepository.save(order));
    }}
