package ru.bmstu.tp_7.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class StatusController {
    @GetMapping("/getStatus")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Application is running");
    }
}