package com.tripleOtech.freshAndFit.monnify;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/payment")
@RequiredArgsConstructor
public class MonnifyPaymentController {
  private MonnifyPaymentService monnifyPaymentService;
    @PostMapping("/initiate")
    public Map<String, Object> initiatePayment(@RequestBody MonnifyPaymentRequest monnifyPaymentRequest) {
        return monnifyPaymentService.initiatePayment(monnifyPaymentRequest);
    }
}
