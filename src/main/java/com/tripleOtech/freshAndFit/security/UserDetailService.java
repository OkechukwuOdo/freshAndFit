package com.tripleOtech.freshAndFit.security;

import com.tripleOtech.freshAndFit.entity.AppUser;
import com.tripleOtech.freshAndFit.exeption.ResourceNotFoundException;
import com.tripleOtech.freshAndFit.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final AppUserRepository appUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("looking for the user in repo");
        AppUser appUser = appUserRepository.findByEmail(username)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        log.info("sds {}",appUser);
        Collection<SimpleGrantedAuthority> authorities =
                Collections.singleton(new SimpleGrantedAuthority(appUser.getRole().name()));
        return new org.springframework.security.core.userdetails.User(appUser.getEmail(), appUser.getPassword(), authorities);
    }
}
