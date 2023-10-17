package com.example.loginjwt.controller;

import com.example.loginjwt.auth.AuthenticationRequest;
import com.example.loginjwt.auth.AuthenticationResponse;
import com.example.loginjwt.entity.User;
import com.example.loginjwt.service.AuthenticationService;
import com.example.loginjwt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private IUserService service;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
    @PostMapping("/register")
    public void register(@RequestBody User user) {
        service.saveUser(user);
        service.addRoleToUser(user.getEmail(), "ROLE_USER");
    }
}
