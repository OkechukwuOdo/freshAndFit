package com.tripleOtech.freshAndFit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String state;
    private String lga;
    private String landMark;
    private String houseAddress;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_id")
    private AppUser user;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private boolean isDefaultShipping=false;
    private boolean isDefaultBilling=false;
}
