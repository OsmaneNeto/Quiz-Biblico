package com.example.Bible_Quiz_Api.controllers;

import com.example.Bible_Quiz_Api.dtos.UserDto;
import com.example.Bible_Quiz_Api.models.UserModel;
import com.example.Bible_Quiz_Api.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/api/auth/register")
    public UserModel register(@RequestBody @Valid UserDto userDto) {
        return authService.registerUser(userDto);
    }
}
