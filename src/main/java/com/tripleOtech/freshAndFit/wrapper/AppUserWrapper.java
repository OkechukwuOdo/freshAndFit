package com.tripleOtech.freshAndFit.wrapper;

import com.tripleOtech.freshAndFit.dto.requestDtos.AppUserRequestDto;
import com.tripleOtech.freshAndFit.dto.responseDtos.AppUserResponseDto;
import com.tripleOtech.freshAndFit.entity.AppUser;
import com.tripleOtech.freshAndFit.entity.enums.AppUserRole;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
@Data
public class AppUserWrapper {
    public static AppUser userRequestToUser(AppUserRequestDto requestDto){
        return AppUser.builder()
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .role(AppUserRole.ADMIN)
                .cratedAt(LocalDate.now())
                .build();
    }

    public static AppUserResponseDto userToUserResponse(AppUserRequestDto requestDto){
        return AppUserResponseDto.builder()
                .email(requestDto.getEmail())
                .build();
    }

}
