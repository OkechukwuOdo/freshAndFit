package com.tripleOtech.freshAndFit.mapper;

import com.tripleOtech.freshAndFit.dto.requestDto.AppUserRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDto.AppUserResponseDto;
import com.tripleOtech.freshAndFit.entity.AppUser;

public class AppUserMapper {

    public static AppUser userRequestToUser(AppUserRequestDto responseDto){
        return AppUser.builder()
                .email(responseDto.getEmail())
                .phone(responseDto.getPhone())
                .firstName(responseDto.getFirstName())
                .lastName(responseDto.getLastName())
                .build();
    }

    public static AppUserResponseDto userToUserResponse(AppUser user){
        return AppUserResponseDto.builder()
                .email(user.getEmail())
                .phone(user.getPhone())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

}
