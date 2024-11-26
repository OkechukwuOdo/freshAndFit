package com.tripleOtech.freshAndFit.controller;

import com.tripleOtech.freshAndFit.dto.requestDto.AppUserRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDto.ApiResponse;
import com.tripleOtech.freshAndFit.dto.responseDto.AppUserResponseDto;
import com.tripleOtech.freshAndFit.dto.responseDto.UserRegistrationResponse;
import com.tripleOtech.freshAndFit.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
@AllArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;

    @PostMapping()
    public ResponseEntity<ApiResponse<UserRegistrationResponse>> register(@RequestBody AppUserRequestDto request) {
        return ResponseEntity.ok(ApiResponse.createdSuccess(appUserService.register(request)));
    }
}
