package com.example.Bible_Quiz_Api.services;

import com.example.Bible_Quiz_Api.dtos.UserDto;
import com.example.Bible_Quiz_Api.logs.UserAlreadyExistsException;
import com.example.Bible_Quiz_Api.models.UserModel;
import com.example.Bible_Quiz_Api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    private UserRepository userRepository;


    // Método para registrar o usuário no banco de dados PostgreSQL
    public UserModel registerUser(UserDto userDto) {
        // Verifica se o usuário já existe
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            throw new UserAlreadyExistsException("Usuário já existe");
        }

        // Cria um novo usuário e codifica a senha
        UserModel user = new UserModel();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        // Atribui um papel padrão (A1) caso não tenha sido informado
        if (userDto.getRole() == null || userDto.getRole().isEmpty()) {
            user.setRole("A1");
        } else {
            user.setRole(userDto.getRole());
        }

        // Salva o usuário no banco de dados PostgreSQL
        return userRepository.save(user);
    }
}
