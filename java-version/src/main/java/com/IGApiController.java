package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class IGApiController {

    private final IGApiService igApiService;
    private final ObjectMapper objectMapper;

    public IGApiController(IGApiService igApiService, ObjectMapper objectMapper) {
        this.igApiService = igApiService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/dashboard")
    public ResponseEntity<Account> getApiData() {
        String data = igApiService.getSessionData();
        try {
            Account account = objectMapper.readValue(data, Account.class);
            return ResponseEntity.ok(account);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/positions")
    public ResponseEntity<List<Position>> getPositionsData() {
        PositionResponse positionResponse = igApiService.getPositionsData();
        return ResponseEntity.ok(positionResponse.getPositions());
    }    
}
