package com.tripleOtech.freshAndFit.dto.requestDtos;

import lombok.*;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUserRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String role;
    private String phoneNumber;
    private String password;
}
