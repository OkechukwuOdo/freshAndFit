package com.tripleOtech.freshAndFit.services.serviceImple;

import com.tripleOtech.freshAndFit.dto.requestDto.AppUserRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDto.ApiResponse;
import com.tripleOtech.freshAndFit.dto.responseDto.AppUserResponseDto;
import com.tripleOtech.freshAndFit.dto.responseDto.PaginationResponse;
import com.tripleOtech.freshAndFit.dto.responseDto.UserRegistrationResponse;
import com.tripleOtech.freshAndFit.entity.AppUser;
import com.tripleOtech.freshAndFit.mapper.AppUserMapper;
import com.tripleOtech.freshAndFit.repository.UserRepository;
import com.tripleOtech.freshAndFit.services.AppUserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final UserRepository userRepository;
    @Override
    public UserRegistrationResponse register(AppUserRequestDto request) {
        AppUser user= AppUserMapper.userRequestToUser(request);
      AppUser newUser=  userRepository.save(user);
        return UserRegistrationResponse.builder()
                .email(newUser.getEmail())
                .userName(newUser.getEmail())
                .build();
    }

    @Override
    public ApiResponse<AppUser> editUser(String appUserId, AppUserRequestDto user) {
        return null;
    }

    @Override
    public ApiResponse<AppUser> getUserById(String appUserId) {
        return null;
    }

    @Override
    public PaginationResponse getAllUsers(int offset, int limit) {
        return null;
    }

    @Override
    public ApiResponse<AppUser> deleteUser(String appUserId) {
        return null;
    }
}
