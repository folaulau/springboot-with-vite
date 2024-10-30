package com.folau.springboot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/api")
@RestController
public class HomeApiController {

    @GetMapping(value = "/home")
    public ResponseEntity<Map<String, Object>> home() {
        return new ResponseEntity<>(Map.of("api","up"), OK);
    }
}
