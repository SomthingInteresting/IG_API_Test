package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PositionService {
    @Value("${IG_API_KEY}")
    private String igApiKey;

    public PositionResponse getPositions() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-IG-API-KEY", igApiKey);
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://demo-api.ig.com/gateway/deal/positions";

        ResponseEntity<PositionResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, PositionResponse.class);

        return response.getBody();
    }
}
