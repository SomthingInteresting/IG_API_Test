package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IGApiService {
    @Value("${IG_API_KEY}")
    private String igApiKey;

    @Value("${IG_IDENTIFIER}")
    private String igIdentifier;

    @Value("${IG_PASSWORD}")
    private String igPassword;

    public String getSessionData() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-IG-API-KEY", igApiKey);
        headers.set("Content-Type", "application/json");

        String requestBody = "{\"identifier\":\"" + igIdentifier + "\",\"password\":\"" + igPassword + "\",\"encryptedPassword\":null}";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://demo-api.ig.com/gateway/deal/session";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }
}
