package com.tripleOtech.freshAndFit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pack {
    @Id
    private Integer id;
    private String name;
    private String image;
    private Integer quantity;
    private Integer numberOfPersonRequired;
    private Integer numberOfPersonAvailable;
    private Integer numberOfPersonRemaining;
    private Double totalAmount;
    private Double amountPerPerson;
    private LocalDateTime scheduledAt;
    @OneToMany
//    @JoinColumn(name = "appUser")
    private List<AppUser> appUser;


}
