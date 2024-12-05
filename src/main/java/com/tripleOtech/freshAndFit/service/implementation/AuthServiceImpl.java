package com.tripleOtech.freshAndFit.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tripleOtech.freshAndFit.dto.requestDtos.AppUserRequestDto;
import com.tripleOtech.freshAndFit.dto.requestDtos.AuthenticationsRequest;
import com.tripleOtech.freshAndFit.dto.responseDtos.AuthenticationResponse;
import com.tripleOtech.freshAndFit.dto.responseDtos.UserRegistrationResponse;
import com.tripleOtech.freshAndFit.entity.AppUser;
import com.tripleOtech.freshAndFit.entity.Wallet;
import com.tripleOtech.freshAndFit.repository.AppUserRepository;
import com.tripleOtech.freshAndFit.repository.WallerRepository;
import com.tripleOtech.freshAndFit.security.JwtService;
import com.tripleOtech.freshAndFit.security.UserDetailService;
import com.tripleOtech.freshAndFit.service.AuthenticationService;
import com.tripleOtech.freshAndFit.service.CartService;
import com.tripleOtech.freshAndFit.service.WalletService;
import com.tripleOtech.freshAndFit.wrapper.AppUserWrapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpHeaders;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthServiceImpl implements AuthenticationService {
    private final AppUserRepository appUserRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailService userDetailService;
    private  AuthenticationResponse tokenResponse;
    private final WalletService walletService;
    private  final CartService cartService;
    @Override
    public AuthenticationResponse register(AppUserRequestDto requestDto) {
        AppUser newUser=  appUserRepository.save(AppUserWrapper.userRequestToUser(requestDto));
        walletService.createWallet(newUser.getId());
        cartService.creatCart(newUser.getId());
        return AuthenticationResponse
                .builder()
                .accessToken("Access Token")
                .freshToken("Refresh Token")
                .build();

    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationsRequest requestDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getEmail(), requestDto.getPassword()));
        if (authentication.isAuthenticated()){
            String userEmail= authentication.getName();
            log.info("looking for the user");
            UserDetails userDetails= userDetailService.loadUserByUsername(userEmail);
            log.info("looking for the userhhhhhh");
            String accessToken= jwtService.generateToken(userDetails);
            String refreshToken= jwtService.generateRefreshToken(userDetails);
            tokenResponse = AuthenticationResponse.builder()
                    .accessToken(accessToken)
                    .freshToken(refreshToken)
                    .build();
        }
        return tokenResponse;
    }

    @Override
    public void refresToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader("Authorization");
        final String refreshToken;
        final String username;
        if(authHeader==null || !authHeader.startsWith("bearer ")){
            return;
        }
        refreshToken=authHeader.substring(7);
        username=jwtService.extractUsername(refreshToken);
        if(username!=null){
            UserDetails userDetails= userDetailService.loadUserByUsername(username);
            if ((jwtService.isTokenValid(refreshToken,userDetails))){
                var accessToken=jwtService.generateToken(userDetails);
                var authResponse=AuthenticationResponse.builder().build();
                new ObjectMapper().writeValue(response.getOutputStream(),authResponse);
            }
        }

    }
}
