package com.example.loginjwt.service.impl;


import com.example.loginjwt.auth.AuthenticationRequest;
import com.example.loginjwt.auth.AuthenticationResponse;
import com.example.loginjwt.entity.Role;
import com.example.loginjwt.entity.User;
import com.example.loginjwt.repository.IUserRepository;
import com.example.loginjwt.repository.RoleCustomRepository;
import com.example.loginjwt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final IUserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final RoleCustomRepository customRepository;

    private final JwtServiceImpl jwtService;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        User user = userRepository.findByUserEmail(authenticationRequest.getEmail()).orElseThrow();
        List<Role> role = null;
        if(user != null){
            role = customRepository.getRole(user);
        }
        Collection<SimpleGrantedAuthority> authorityCollection = new ArrayList<>();
        Set<Role> set = new HashSet<>();
        role.stream().forEach(c -> set.add(new Role(c.getName())));
        user.setRoles(set);
        set.stream().forEach(c -> authorityCollection.add(new SimpleGrantedAuthority(c.getName())));
        var jwtToken = jwtService.generateToken(user, authorityCollection);
        var jwtRefreshToken = jwtService.generateRefreshToken(user, authorityCollection);
        return AuthenticationResponse.builder().toKen(jwtToken).refreshToken(jwtRefreshToken).build();
    }
}
