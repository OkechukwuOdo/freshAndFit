package com.tripleOtech.freshAndFit.service;

import com.tripleOtech.freshAndFit.dto.requestDtos.AppUserRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDtos.ApiResponse;
import com.tripleOtech.freshAndFit.dto.responseDtos.AppUserResponseDto;
import com.tripleOtech.freshAndFit.dto.responseDtos.PaginationResponse;
import com.tripleOtech.freshAndFit.dto.responseDtos.UserRegistrationResponse;
import com.tripleOtech.freshAndFit.entity.AppUser;


public interface AppUserService {
    ApiResponse<AppUser> editUser(Long appUserId, AppUserRequestDto user);
    ApiResponse<AppUser> getUserById(Long appUserId);
    PaginationResponse getAllUsers(int offset, int limit);
    ApiResponse<AppUser> deleteUser(Long appUserId);



}
