package com.tripleOtech.freshAndFit.smservice;

import org.springframework.stereotype.Service;

@Service
public interface SmsService {
    String sendSms(SmsRequest request);
}
