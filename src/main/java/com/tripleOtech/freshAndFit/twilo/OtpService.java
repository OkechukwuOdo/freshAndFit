package com.tripleOtech.freshAndFit.twilo;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OtpService {
    private final TwilioConfig twilioConfig;
    private final OptRepository optRepository;

    public void sentOtp(String customerPhoneNumber){
        PhoneNumber from= new PhoneNumber(twilioConfig.getTwilioPhoneNumber());
        PhoneNumber to= new PhoneNumber(customerPhoneNumber);
        String otp=generateOpt();
        String otpMessage=" Dear Customer, you Otp is"+otp+" Please Long it. Keep it safe";

        Message message= Message.creator(to,from,otpMessage)
                .create();
    }
    private String generateOpt(){
        return new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
    }

    public String validateOtp(String otp, String userEmail){
        ResetPasswordOtp savedOtp= optRepository.findResetPasswordOtpByOtp(otp).orElseThrow();
        if (!otp.equals(savedOtp.getOtp()) && savedOtp.getCreateAt().isAfter(LocalDateTime.now().plusMinutes(15))){
            optRepository.delete(savedOtp);
        }
        optRepository.delete(savedOtp);
        return "Verification Successful";
    }
}
