package com.example.Bible_Quiz_Api.controllers;

import com.example.Bible_Quiz_Api.dtos.UserDto;
import com.example.Bible_Quiz_Api.models.UserModel;
import com.example.Bible_Quiz_Api.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //Método de cadastro
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto) {
        try {
            UserModel registeredUser = authService.registerUser(userDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
        } catch (Exception e) {
            e.printStackTrace();  // Exibe o erro no log
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //Método de login
    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody UserDto userDto) {
        UserModel user = authService.authenticateUserByEmail(userDto.getEmail(), userDto.getPassword());
        if (user != null) {
            String token = generateToken(user);
            // Retorna o UserDto com os dados do usuário
            UserDto responseUserDto = new UserDto();
            responseUserDto.setUsername(user.getUsername());
            responseUserDto.setEmail(user.getEmail());
            responseUserDto.setRole(user.getRole());
            responseUserDto.setToken(token);
            return ResponseEntity.status(HttpStatus.OK).body(responseUserDto);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);  // Pode retornar null ou um erro específico
        }
    }
    // Método para gerar um token (exemplo simples)
    private String generateToken(UserModel user) {
        // Implemente sua lógica de geração de token aqui
        return "token"; // Retorne o token gerado
    }


}
