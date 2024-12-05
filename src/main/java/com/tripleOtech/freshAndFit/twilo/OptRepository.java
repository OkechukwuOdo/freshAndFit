package com.tripleOtech.freshAndFit.twilo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OptRepository extends JpaRepository<ResetPasswordOtp,Integer> {
    Optional<ResetPasswordOtp> findResetPasswordOtpByOtp(String otp);
}
