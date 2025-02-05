package com.example.Bible_Quiz_Api.controllers;

import com.example.Bible_Quiz_Api.dtos.UserDto;
import com.example.Bible_Quiz_Api.models.UserModel;
import com.example.Bible_Quiz_Api.services.AuthService;
import com.example.Bible_Quiz_Api.utils.JwtUtil;
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
    private JwtUtil jwtUtil;


//    @Autowired
//    public AuthController(AuthService authService) {
//
//        this.authService = authService;
//        this.jwtUtil = jwtUtil;
//    }

    @Autowired
    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
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
//    @PostMapping("/login")
//    public ResponseEntity<UserDto> loginUser(@RequestBody UserDto userDto) {
//        UserModel user = authService.authenticateUserByEmail(userDto.getEmail(), userDto.getPassword());
//        if (user != null) {
//            String token = generateToken(user);
//            // Retorna o UserDto com os dados do usuário
//            UserDto responseUserDto = new UserDto();
//            responseUserDto.setUsername(user.getUsername());
//            responseUserDto.setEmail(user.getEmail());
//            responseUserDto.setRole(user.getRole());
//            responseUserDto.setToken(token);
//            return ResponseEntity.status(HttpStatus.OK).body(responseUserDto);
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);  // Pode retornar null ou um erro específico
//        }
//    }

    // Método de login
    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody UserDto userDto) {
        UserModel user = authService.authenticateUserByEmail(userDto.getEmail(), userDto.getPassword());
        if (user != null) {
            String token = jwtUtil.generateToken(user); // Gera o token real
            // Retorna os dados do usuário e o token
            UserDto responseUserDto = new UserDto();
            responseUserDto.setUsername(user.getUsername());
            responseUserDto.setEmail(user.getEmail());
            responseUserDto.setRole(user.getRole());
            responseUserDto.setToken(token);
            return ResponseEntity.status(HttpStatus.OK).body(responseUserDto);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    // Método para obter o perfil do usuário
    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(@RequestHeader("Authorization") String token) {
        try {
            String email = jwtUtil.getEmailFromToken(token.replace("Bearer ", ""));
            UserModel user = authService.findByEmail(email);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido ou expirado");
        }
    }
}



