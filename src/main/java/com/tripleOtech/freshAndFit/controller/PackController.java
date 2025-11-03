package com.tripleOtech.freshAndFit.controller;

import com.tripleOtech.freshAndFit.dto.requestDtos.PackRequest;
import com.tripleOtech.freshAndFit.dto.responseDtos.ApiResponse;
import com.tripleOtech.freshAndFit.dto.responseDtos.PackResponse;
import com.tripleOtech.freshAndFit.dto.responseDtos.PackStatusResponse;
import com.tripleOtech.freshAndFit.service.PackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pack")
@RequiredArgsConstructor
public class PackController {
    private final PackService packService;

    @PostMapping("/create-pack")
    public ResponseEntity<ApiResponse<PackResponse>> creatAPack(PackRequest packRequest){
        PackResponse packResponse= packService.createPack(packRequest);
        return ResponseEntity.ok(ApiResponse.createdSuccess(packResponse));
    }

    @PutMapping("/")
    public ResponseEntity<ApiResponse<PackStatusResponse>> updatePackAfterPayment(String userEmail, Long productId){
        PackStatusResponse packStatusResponse= packService.updatePackStatusAfterPayment(userEmail,productId);
        return ResponseEntity.ok(ApiResponse.createdSuccess(packStatusResponse));
    }
}
