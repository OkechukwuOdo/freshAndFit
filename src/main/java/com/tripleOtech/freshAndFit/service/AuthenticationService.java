package com.tripleOtech.freshAndFit.service;

import com.tripleOtech.freshAndFit.dto.requestDtos.AppUserRequestDto;
import com.tripleOtech.freshAndFit.dto.requestDtos.AuthenticationsRequest;
import com.tripleOtech.freshAndFit.dto.responseDtos.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface AuthenticationService {
    AuthenticationResponse register(AppUserRequestDto requestDto);
    AuthenticationResponse authenticate(AuthenticationsRequest requestDto);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
