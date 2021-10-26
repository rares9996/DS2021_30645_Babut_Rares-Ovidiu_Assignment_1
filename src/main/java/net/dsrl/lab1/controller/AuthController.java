package net.dsrl.lab1.controller;

import javax.validation.Valid;

import net.dsrl.lab1.model.dto.JwtResponseDto;
import net.dsrl.lab1.model.dto.LoginDto;
import net.dsrl.lab1.model.dto.RegisterDto;
import net.dsrl.lab1.service.AuthenticationService;
import net.dsrl.lab1.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api")
public class AuthController {

    private final AuthenticationService authenticationService;
    private final RegisterService registerService;

    public AuthController(AuthenticationService authenticationService, RegisterService registerService) {
        this.authenticationService = authenticationService;
        this.registerService = registerService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> authenticatication(@Valid @RequestBody LoginDto loginRequest) {

        return ResponseEntity.ok(authenticationService.authenticateUser(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDto signUpRequest) {
        registerService.registerUser(signUpRequest);
        return ResponseEntity.ok("User registered successfully!");
    }
}
