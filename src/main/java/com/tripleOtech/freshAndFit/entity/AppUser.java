package com.tripleOtech.freshAndFit.entity;

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
public class AppUser {
    private Long id;
    private String email;
    private String profile;
    private String firstName;
    private String lastName;
    private String phone;
    private Address location;
    private UserRoles role;
    private LocalDate createdAt;

}
