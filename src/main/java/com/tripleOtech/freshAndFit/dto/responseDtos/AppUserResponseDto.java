package com.tripleOtech.freshAndFit.dto.responseDtos;

import com.tripleOtech.freshAndFit.entity.Address;
import com.tripleOtech.freshAndFit.entity.enums.AppUserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private Address location;
    private AppUserRole role;
    private String imgUrl;
    private LocalDate cratedAt;
    private String phoneNumber;
}
