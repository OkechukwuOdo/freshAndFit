package com.tripleOtech.freshAndFit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GroupPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private CashCrop product;
    private Double totalAmount;
    private Double amountPerPerson;
    private int minParticipants;   // e.g., at least 3 users must join
    private int maxParticipants;   // optional
    private boolean completed = false;

    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    @Embedded
    private GroupPurchaseSummary groupPurchaseSummary;

    @OneToMany(mappedBy = "groupPurchase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AppUser> participants = new ArrayList<>();
}
