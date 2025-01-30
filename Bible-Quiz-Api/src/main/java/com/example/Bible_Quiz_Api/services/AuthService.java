package com.example.Bible_Quiz_Api.services;

import com.example.Bible_Quiz_Api.dtos.UserDto;
import com.example.Bible_Quiz_Api.models.UserModel;
import com.example.Bible_Quiz_Api.repositories.UserRepository; // Importando o repositório
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserRepository userRepository;  // Injeção do repositório

    // Construtor para injeção do UserRepository
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel registerUser(@RequestBody UserDto userDto) {
        // Verificar se o nome de usuário já existe
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            throw new RuntimeException("O nome de usuário já está em uso.");
        }
        // Verificar se o email já está cadastrado
        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new RuntimeException("Email já está em uso.");
        }

        // Atribuir role com base na senha
        String role = determineRole(userDto.getPassword());

        // Criar o modelo do usuário com base nos dados recebidos
        UserModel userModel = new UserModel();
        userModel.setUsername(userDto.getUsername());
        userModel.setPassword(passwordEncoder.encode(userDto.getPassword()));  // Senha criptografada
        userModel.setRole(role);
        userModel.setEmail(userDto.getEmail());  // Atribuindo o email

        // Log para depuração
        System.out.println("Salvando usuário: " + userModel.getUsername());

        // Salvar o usuário no banco de dados
        userRepository.save(userModel);

        return userModel;
    }



    private String determineRole(String password) {
        if ("AuxiliarCCB".equals(password)) {
            return "A2";
        } else if ("CooperadorCCB".equals(password)) {
            return "A3";
        } else {
            return "A1";  // Default role
        }
    }
}
