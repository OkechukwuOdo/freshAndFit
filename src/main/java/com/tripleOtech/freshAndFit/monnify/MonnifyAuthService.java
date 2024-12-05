package com.tripleOtech.freshAndFit.monnify;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Map;

@RequiredArgsConstructor
public class MonnifyAuthService {
    @Value(value="${monnify.base-url}")
    private String baseUrl;

    @Value(value="${monnify.api-key}")
    private String apiKey;

    @Value(value="${monnify.secret-key}")
    private String secretKey;

    public String authenticate(){
        String authUrl = baseUrl + "/auth/login";
        String credentials = apiKey + ":" + secretKey;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.postForObject(authUrl, null, Map.class, Map.of(
                "Authorization", "Basic " + encodedCredentials));
        if (response != null && response.get("responseBody") != null) {
            Map<String, String> responseBody = (Map<String, String>) response.get("responseBody");
            return responseBody.get("accessToken");
        }
        throw new RuntimeException("Failed to authenticate with Monnify.");
    }
}
