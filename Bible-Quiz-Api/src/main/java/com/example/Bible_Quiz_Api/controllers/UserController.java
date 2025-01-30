package com.example.Bible_Quiz_Api.controllers;

import com.example.Bible_Quiz_Api.dtos.UserDto;
import com.example.Bible_Quiz_Api.logs.UserAlreadyExistsException;
import com.example.Bible_Quiz_Api.models.UserModel;
import com.example.Bible_Quiz_Api.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final AuthService authService;

    @Autowired
    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        try {
            UserModel user = authService.registerUser(userDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (UserAlreadyExistsException e) {
            // Retorna uma resposta de erro personalizada
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
