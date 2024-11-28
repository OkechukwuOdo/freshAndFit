package com.tripleOtech.freshAndFit.entity;

import com.tripleOtech.freshAndFit.entity.enums.AppUserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    @OneToOne
    @JoinColumn(name = "location_id")
    private Address location;
    @Enumerated(value = EnumType.STRING)
    private AppUserRole role;
    private String imgUrl;
    private LocalDate cratedAt;
    private String phoneNumber;
}
