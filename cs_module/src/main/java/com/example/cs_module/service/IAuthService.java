package com.example.cs_module.service;

import com.example.cs_module.dto.LoginDTO;
import com.example.cs_module.dto.RegisterDTO;

public interface IAuthService {
    String login(LoginDTO loginDto);

    String register(RegisterDTO registerDto);
}
