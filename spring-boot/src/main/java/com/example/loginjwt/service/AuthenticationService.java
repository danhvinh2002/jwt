package com.example.loginjwt.service;

import com.example.loginjwt.auth.AuthenticationRequest;
import com.example.loginjwt.auth.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

}
