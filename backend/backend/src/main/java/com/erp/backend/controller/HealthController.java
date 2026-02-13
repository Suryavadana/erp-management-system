package com.erp.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthController {
//    @GetMapping
//    public String Health() {
//        return "ERP backend is running!!";
//    }
    @GetMapping
    public ResponseEntity<String> health(){
        return ResponseEntity.ok("API is healthy");
    }
}
