package com.ushan.authservice.controller;

import com.ushan.authservice.dto.JwtResponseDTO;
import com.ushan.authservice.dto.LoginRequestDTO;
import com.ushan.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@RequestBody LoginRequestDTO request) {

        System.out.println("Login request received for username: " + request.getUsername());
        String token = authService.login(request);
        return ResponseEntity.ok(new JwtResponseDTO(token));
    }
}
