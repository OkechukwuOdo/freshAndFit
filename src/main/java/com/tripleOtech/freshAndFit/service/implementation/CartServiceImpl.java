package com.tripleOtech.freshAndFit.service.implementation;

import com.tripleOtech.freshAndFit.dto.responseDtos.ApiResponse;
import com.tripleOtech.freshAndFit.dto.responseDtos.PaginationResponse;
import com.tripleOtech.freshAndFit.entity.AppUser;
import com.tripleOtech.freshAndFit.entity.Cart;
import com.tripleOtech.freshAndFit.entity.CartItem;
import com.tripleOtech.freshAndFit.entity.FoodItem;
import com.tripleOtech.freshAndFit.exeption.ResourceNotFoundException;
import com.tripleOtech.freshAndFit.repository.AppUserRepository;
import com.tripleOtech.freshAndFit.repository.CartItemRepository;
import com.tripleOtech.freshAndFit.repository.CartRepository;
import com.tripleOtech.freshAndFit.repository.ProductRepository;
import com.tripleOtech.freshAndFit.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final AppUserRepository appUserRepository;
    private final ProductRepository productRepository;

    @Override
    public void creatCart(Long userId) {
        AppUser appUser= appUserRepository.findAppUserById(userId).orElseThrow();
        Cart cart = new Cart();
        cart.setUser(appUser);
        cartRepository.save(cart);
    }

    @Override
    public ApiResponse<Cart> addToCart(Long userId, Long productId) {
        Optional<FoodItem> productOptional = productRepository.findById(productId);
        AppUser appUser= appUserRepository.findAppUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (productOptional.isEmpty()) {
            throw new ResourceNotFoundException("Product not found");
        }
        FoodItem product = productOptional.get();
        Cart cart = cartRepository.findCartByUser(appUser).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUser(appUser);
            return cartRepository.save(newCart);
        });
        Optional<CartItem> existingItem = cart.getCartItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst();
        if (existingItem.isPresent()){
            throw new ResourceNotFoundException("Item Already exist");
        }
        else {
            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            cart.getCartItems().add(cartItem);
        }
        return ApiResponse.buildSuccessTxn(cartRepository.save(cart));
    }

    @Override
    public ApiResponse<Cart> getCartByUser(Long userId) {
       AppUser appUser= appUserRepository.findAppUserById(userId).orElseThrow();
        Cart cart = cartRepository.findCartByUser(appUser).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUser(appUser);
            return cartRepository.save(newCart);
        });
        return ApiResponse.buildSuccessTxn(cart);
    }

    @Override
    public PaginationResponse getAllCart(int offset, int limit) {
        return null;
    }
}
