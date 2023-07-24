package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IGApiTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(IGApiTestApplication.class, args);

        IGApiService service = context.getBean(IGApiService.class);

        // Test getSessionData method
        String sessionData = service.getSessionData();
        System.out.println("Session Data: " + sessionData);

        // Test getPositionsData method
        PositionResponse positionsData = service.getPositionsData();
        System.out.println("Positions Data: " + positionsData);
    }
}
