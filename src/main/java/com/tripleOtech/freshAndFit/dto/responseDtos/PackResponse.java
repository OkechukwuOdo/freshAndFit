package com.tripleOtech.freshAndFit.dto.responseDtos;

import com.tripleOtech.freshAndFit.entity.AppUser;
import com.tripleOtech.freshAndFit.entity.PackageStatus;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PackResponse {
    private Integer id;
    private String name;
    private String image;
    private Integer quantity;
    private Integer numberOfPersonRequired;
    private Integer numberOfPersonAvailable;
    private Double totalAmount;
    private Double amountPerPerson;
    private boolean isActive;
    private LocalDateTime scheduledAt;
    private PackageStatus packageStatus;

}
