package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IGController {

    @GetMapping("/api/data")
    public String getData() {
        return "Hello, IG API!";
    }

}
