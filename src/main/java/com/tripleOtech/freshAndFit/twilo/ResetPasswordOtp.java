package com.tripleOtech.freshAndFit.twilo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ResetPasswordOtp {
    @Id
    @GeneratedValue
    private String userEmail;
    private String otp;
    private LocalDateTime createAt;
}
