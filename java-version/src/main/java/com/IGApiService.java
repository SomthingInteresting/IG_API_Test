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

    private String clientSecurityToken;
    private String xSecurityToken;

    public String getSessionData() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-IG-API-KEY", igApiKey);
        headers.set("Content-Type", "application/json");

        String requestBody = "{\"identifier\":\"" + igIdentifier + "\",\"password\":\"" + igPassword + "\",\"encryptedPassword\":null}";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://demo-api.ig.com/gateway/deal/session";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        // Capture the security tokens from the response headers
        if (response.getHeaders().containsKey("CST")) {
            this.clientSecurityToken = response.getHeaders().get("CST").get(0);
        }

        if (response.getHeaders().containsKey("X-SECURITY-TOKEN")) {
            this.xSecurityToken = response.getHeaders().get("X-SECURITY-TOKEN").get(0);
        }

        return response.getBody();
    }

    /**
     * @return
     */
    public PositionResponse getPositionsData() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-IG-API-KEY", igApiKey);
        headers.set("CST", clientSecurityToken);
        headers.set("X-SECURITY-TOKEN", xSecurityToken);
        headers.set("Content-Type", "application/json");
    
        HttpEntity<String> entity = new HttpEntity<>(headers);
    
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://demo-api.ig.com/gateway/deal/positions";
    
        ResponseEntity<PositionResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, PositionResponse.class);
    
        return response.getBody();
    }

    public void fetchAndLogRawPositionsData() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-IG-API-KEY", igApiKey);
        headers.set("CST", clientSecurityToken);
        headers.set("X-SECURITY-TOKEN", xSecurityToken);
        headers.set("Content-Type", "application/json");
    
        HttpEntity<String> entity = new HttpEntity<>(headers);
    
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://demo-api.ig.com/gateway/deal/positions";
    
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    
        // Log the raw response
        System.out.println("Raw positions data from live server: " + response.getBody());
    }
}

