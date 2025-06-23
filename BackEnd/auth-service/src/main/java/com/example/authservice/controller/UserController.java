package com.example.authservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/info")
    public ResponseEntity<?> info(Authentication authentication) {
        String username = authentication.getName();

        // JSON 형태 응답
        return ResponseEntity.ok(Map.of(
                "message", "인증된 사용자 정보입니다.",
                "username", username
        ));
    }
}
