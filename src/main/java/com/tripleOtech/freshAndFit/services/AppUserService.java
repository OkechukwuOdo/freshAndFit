package com.tripleOtech.freshAndFit.services;

import com.tripleOtech.freshAndFit.dto.requestDto.AppUserRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDto.ApiResponse;
import com.tripleOtech.freshAndFit.dto.responseDto.PaginationResponse;
import com.tripleOtech.freshAndFit.dto.responseDto.UserRegistrationResponse;
import com.tripleOtech.freshAndFit.entity.AppUser;
import org.springframework.stereotype.Service;

@Service
public interface AppUserService {
    UserRegistrationResponse register(AppUserRequestDto request);
    ApiResponse<AppUser> editUser(String appUserId, AppUserRequestDto user);
    ApiResponse<AppUser> getUserById(String appUserId);
    PaginationResponse getAllUsers(int offset, int limit);
    ApiResponse<AppUser> deleteUser(String appUserId);
}
