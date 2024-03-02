//package com.example.loginjwt.service.impl;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.example.loginjwt.entity.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Service;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Collection;
//import java.util.Date;
//import java.util.stream.Collectors;
//
//@Service
//public class JwtServiceImpl {
//
//    private static final String Secret_key = "123";
//
//    public String generateToken(User user, Collection<SimpleGrantedAuthority> authorities) {
//        Algorithm algorithm = Algorithm.HMAC256(Secret_key.getBytes());
//        return JWT.create()
//                .withSubject(user.getEmail())
//                .withExpiresAt(new Date(System.currentTimeMillis()+ 50 * 60 *1000))
//                .withClaim("roles", authorities.stream().map(GrantedAuthority :: getAuthority).collect(Collectors.toList()))
//                .sign(algorithm);
//    }
//    public String generateRefreshToken(User user, Collection<SimpleGrantedAuthority> authorities) {
//        Algorithm algorithm = Algorithm.HMAC256(Secret_key.getBytes());
//        return JWT.create()
//                .withSubject(user.getEmail())
//                .withExpiresAt(new Date(System.currentTimeMillis()+ 50 * 60 *1000))
//                .sign(algorithm);
//    }
//}
