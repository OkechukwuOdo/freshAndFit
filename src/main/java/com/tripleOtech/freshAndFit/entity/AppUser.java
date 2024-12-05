package com.tripleOtech.freshAndFit.entity;

import com.tripleOtech.freshAndFit.entity.enums.AppUserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "user")
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
    private String password;


}
