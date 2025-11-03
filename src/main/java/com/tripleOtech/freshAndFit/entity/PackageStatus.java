package com.tripleOtech.freshAndFit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Entity
public class PackageStatus {
    @Id
    private Long id;
    private String name;
    private String image;
    private Integer quantity;
    private Integer numberOfPersonRequired;
    private Integer numberOfPersonAvailable;
    private int numberOfPeopleRemaining;
    private Double totalAmount;
    private Double amountPerPerson;
    private LocalDateTime scheduledAt;
    private int numberOfDaysLeft;
    @OneToMany()
    @JoinColumn(name = "participants")
    private List<AppUser> participants;

}
