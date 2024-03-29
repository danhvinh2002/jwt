//package com.example.loginjwt.config;
//
////import com.auth0.jwt.JWT;
////import com.auth0.jwt.JWTVerifier;
////import com.auth0.jwt.algorithms.Algorithm;
////import com.auth0.jwt.interfaces.DecodedJWT;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MimeTypeUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.*;
//
//
//@Component
//@RequiredArgsConstructor
//public class JwtAuthentication extends OncePerRequestFilter {
//
//    private static final String Secret_key = "123";
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String authorizationHeader = request.getHeader("authorizations");
//        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
//            try{
//                String toKen = authorizationHeader.substring("Bearer ".length());
//                Algorithm algorithm = Algorithm.HMAC256(Secret_key.getBytes());
//                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
//                DecodedJWT decodedJWT = jwtVerifier.verify(toKen);
//                String userName = decodedJWT.getSubject();
//                String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
//
//                Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//                Arrays.stream(roles).forEach(role -> {
//                    authorities.add(new SimpleGrantedAuthority(role));
//                });
//
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userName, null, authorities);
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//
//                filterChain.doFilter(request, response);
//            }catch(Exception e){
//                response.setHeader("error", e.getMessage());
//                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//                Map<String, String> error = new HashMap<>();
//                error.put("error_message", e.getMessage());
//                response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
//                new ObjectMapper().writeValue(response.getOutputStream(), error);
//            }
//        }else{
//            filterChain.doFilter(request, response);
//        }
//    }
//}
