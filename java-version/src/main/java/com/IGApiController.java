package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IGApiController {

    private final IGApiService igApiService;

    public IGApiController(IGApiService igApiService) {
        this.igApiService = igApiService;
    }

    @GetMapping("/data")
    public String getApiData() {
        return igApiService.getSessionData();
    }
}
