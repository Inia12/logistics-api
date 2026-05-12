package com.ryzhak.logistics_app.controller.auth;

import com.ryzhak.logistics_app.dto.auth.RegisterRequest;

import com.ryzhak.logistics_app.dto.auth.LoginRequest;
import com.ryzhak.logistics_app.dto.auth.LoginResponse;

import com.ryzhak.logistics_app.service.auth.AuthService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @Valid @RequestBody RegisterRequest request
    ) {

        return ResponseEntity.ok(
                authService.register(request)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request
    ) {

        return ResponseEntity.ok(
                authService.login(request)
        );
    }
}