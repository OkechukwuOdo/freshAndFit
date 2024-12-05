package com.tripleOtech.freshAndFit.dto.responseDtos;

import com.tripleOtech.freshAndFit.entity.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistrationResponse {
    private  String name;
    private  String email;
    private UserRegistrationResponse(AppUser user){
        email = user.getEmail();
    }
    public static UserRegistrationResponse registrationResponseInstance(AppUser user){
        return new UserRegistrationResponse(user);
    }
}
