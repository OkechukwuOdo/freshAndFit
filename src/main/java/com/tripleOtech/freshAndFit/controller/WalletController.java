package com.tripleOtech.freshAndFit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/wallet")
@RequiredArgsConstructor
public class WalletController {

    @PostMapping("/")
    public ResponseEntity<?> fundWallet(){
        return ResponseEntity.ok("");
    }
}
