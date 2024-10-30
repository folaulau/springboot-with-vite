package com.folau.springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class HomeApiController {

    @RequestMapping("/home")
    public String home() {
        return "Welcome to the Home API";
    }
}
