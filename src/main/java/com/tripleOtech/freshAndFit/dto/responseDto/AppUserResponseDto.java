package com.tripleOtech.freshAndFit.dto.responseDto;

import com.tripleOtech.freshAndFit.entity.Address;
import com.tripleOtech.freshAndFit.entity.enums.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUserResponseDto {
    private Long userId;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Address location;
    private LocalDate createdAt;
}
