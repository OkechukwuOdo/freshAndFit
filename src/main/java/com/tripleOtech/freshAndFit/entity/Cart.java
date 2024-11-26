package com.tripleOtech.freshAndFit.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Long cartId;
    private AppUser customer;
    private Integer totalItems;
//    private Integer totalQuantity;
    private Double totalPrice;
    private String status; // ACTIVE, ABANDONED, CHECKED_OUT
    private String couponCode;
    private Double discountedTotal;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;

//    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
}
