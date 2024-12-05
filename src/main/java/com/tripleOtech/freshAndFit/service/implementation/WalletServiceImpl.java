package com.tripleOtech.freshAndFit.service.implementation;

import com.tripleOtech.freshAndFit.entity.AppUser;
import com.tripleOtech.freshAndFit.entity.Wallet;
import com.tripleOtech.freshAndFit.repository.AppUserRepository;
import com.tripleOtech.freshAndFit.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final AppUserRepository appUserRepository;
    @Override
    public void createWallet(Long userId) {
        AppUser appUser= appUserRepository.findAppUserById(userId).orElseThrow();
        Wallet wallet= new Wallet();
        wallet.setAppUser(appUser);
        wallet.setCreatedAt(LocalDateTime.now());
        wallet.setBalance(0.0);
    }
}
