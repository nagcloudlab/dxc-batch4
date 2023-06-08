package com.example.security.auth;

import com.example.security.JwtService;
import com.example.security.UserDetailsService;
import com.example.security.auth.dto.AuthRequest;
import com.example.security.auth.dto.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsService userDetailsService;

    public AuthResponse authenticate(AuthRequest authRequest) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword());
            authenticationManager.authenticate(authenticationToken);
        } catch (UsernameNotFoundException | BadCredentialsException e) {
            throw e;
        }
        Map<String, Object> claims = new HashMap<>();
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
        String jwtoken = jwtService.generateToken(claims, userDetails);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(jwtoken);
        return authResponse;
    }

}
