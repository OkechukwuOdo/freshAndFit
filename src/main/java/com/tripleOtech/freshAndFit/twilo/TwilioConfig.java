package com.tripleOtech.freshAndFit.twilo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class TwilioConfig {

    @Value("${twilio.account-sid}")
    private String accountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value(value = "${app.twilio-phoneNumber}")
    private String twilioPhoneNumber;
}
