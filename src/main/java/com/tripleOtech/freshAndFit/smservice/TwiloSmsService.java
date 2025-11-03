package com.tripleOtech.freshAndFit.smservice;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TwiloSmsService implements SmsService{
    private final TwilioConfig twilioConfig;

    public String sendSms(SmsRequest request) {

        Message message = Message.creator(
                new PhoneNumber(request.getTo()), // recipient
                new PhoneNumber(twilioConfig.getPhoneNumber()), // Twilio trial number
                request.getMessageBody()
        ).create();

        return message.getSid();
    }
}
