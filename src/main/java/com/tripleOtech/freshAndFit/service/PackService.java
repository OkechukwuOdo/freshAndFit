package com.tripleOtech.freshAndFit.service;

import com.tripleOtech.freshAndFit.dto.requestDtos.PackRequest;
import com.tripleOtech.freshAndFit.dto.responseDtos.PackResponse;
import com.tripleOtech.freshAndFit.dto.responseDtos.PackStatusResponse;
import org.springframework.stereotype.Service;

@Service
public interface PackService {
    PackResponse createPack(PackRequest packRequest);

    PackStatusResponse updatePackStatusAfterPayment(String userEmail, Long productId);
}
