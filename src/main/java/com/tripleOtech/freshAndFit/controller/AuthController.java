package com.tripleOtech.freshAndFit.controller;

import com.tripleOtech.freshAndFit.dto.requestDtos.AppUserRequestDto;
import com.tripleOtech.freshAndFit.dto.requestDtos.AuthenticationsRequest;
import com.tripleOtech.freshAndFit.dto.responseDtos.ApiResponse;
import com.tripleOtech.freshAndFit.dto.responseDtos.AuthenticationResponse;
import com.tripleOtech.freshAndFit.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<ApiResponse<?>> register(@RequestBody AppUserRequestDto requestDto){
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        return ResponseEntity.ok(ApiResponse.createdSuccess(authenticationService.register(requestDto)));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> authenticate(@RequestBody AuthenticationsRequest requestDto){
        log.info("Controller Entry........");
        return ResponseEntity.ok(ApiResponse.createdSuccess(authenticationService.authenticate(requestDto)));
    }

    @PostMapping("/refresh-token")
    public void refresh(HttpServletRequest request, HttpServletResponse response) throws IOException {
      authenticationService.refreshToken(request,response);
    }
}
