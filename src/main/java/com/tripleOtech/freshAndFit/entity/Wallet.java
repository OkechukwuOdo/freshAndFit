package com.tripleOtech.freshAndFit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Wallet {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn()
    private AppUser appUser;
    private BigDecimal balance;
    private LocalDateTime createdAt;
    private LocalDateTime lastSub;
    private String currency;
}
