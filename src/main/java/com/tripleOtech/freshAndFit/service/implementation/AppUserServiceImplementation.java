package com.tripleOtech.freshAndFit.service.implementation;

import com.tripleOtech.freshAndFit.dto.requestDtos.AppUserRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDtos.ApiResponse;
import com.tripleOtech.freshAndFit.dto.responseDtos.AppUserResponseDto;
import com.tripleOtech.freshAndFit.dto.responseDtos.PaginationResponse;
import com.tripleOtech.freshAndFit.dto.responseDtos.UserRegistrationResponse;
import com.tripleOtech.freshAndFit.entity.AppUser;
import com.tripleOtech.freshAndFit.exeption.ResourceNotFoundException;
import com.tripleOtech.freshAndFit.repository.AppUserRepository;
import com.tripleOtech.freshAndFit.service.AppUserService;
import com.tripleOtech.freshAndFit.wrapper.AppUserWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class AppUserServiceImplementation implements AppUserService {
    private final AppUserRepository appUserRepository;

    @Override
    public ApiResponse<AppUser> editUser(Long appUserId, AppUserRequestDto user) {
        AppUser appUser = appUserRepository.findById(appUserId)
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
        AppUserWrapper.userRequestToUser(user);
        appUser.setFirstName(user.getFirstName());
        appUser.setLastName(user.getLastName());
        appUser.setPhoneNumber(user.getPhoneNumber());
        appUser.setEmail(user.getEmail());
        AppUser editedAppUSer = appUserRepository.save( AppUserWrapper.userRequestToUser(user));

        return ApiResponse.buildSuccessTxn(editedAppUSer);
    }

    @Override
    public ApiResponse<AppUser> getUserById(Long appUserId) {
        return null;
    }

    @Override
    public PaginationResponse getAllUsers(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset, limit);
        Page<AppUser> page = appUserRepository.findAll(pageable);
        return new PaginationResponse<>(page.getContent(), page);
    }

    @Override
    public ApiResponse<AppUser> deleteUser(Long appUserId) {
        AppUser appUserResponse = appUserRepository.findById(appUserId)
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
        appUserRepository.deleteById(appUserId);
        return ApiResponse.buildSuccessTxn(appUserResponse);
    }
}
