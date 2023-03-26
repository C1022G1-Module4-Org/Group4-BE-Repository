package com.example.cs_module.controller;

import com.example.cs_module.dto.JWTAuthResponse;
import com.example.cs_module.dto.LoginDTO;
import com.example.cs_module.dto.RegisterDTO;
import com.example.cs_module.model.user.Role;
import com.example.cs_module.model.user.User;
import com.example.cs_module.repository.user.IRoleRepository;
import com.example.cs_module.repository.user.IUserRepository;
import com.example.cs_module.security.CustomUserDetailsService;
import com.example.cs_module.security.JwtTokenProvider;
import com.example.cs_module.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private IAuthService authService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    // Build Login REST API
    @PostMapping(value = {"/login", "/sign-in"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDTO loginDto){
        String token = authService.login(loginDto);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginDto.getUsernameOrEmail());

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse(token, userDetails.getAuthorities());
        jwtAuthResponse.setAccessToken(token);
        jwtAuthResponse.setRoleList(userDetails.getAuthorities());

        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDto){

        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
