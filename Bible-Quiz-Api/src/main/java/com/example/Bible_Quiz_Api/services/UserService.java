package com.example.Bible_Quiz_Api.services;


import com.example.Bible_Quiz_Api.models.UserModel;
import com.example.Bible_Quiz_Api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Método para registrar um usuário
    public UserModel registerUser(String username, String password) {
        UserModel user = new UserModel();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));  // Senha criptografada
        return userRepository.save(user);
    }

    // Método para autenticar um usuário
    public UserModel authenticateUser(String username, String password) {
        UserModel user = userRepository.findById(username).orElse(null);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;  // Retorna o usuário se a senha estiver correta
        }
        return null;  // Retorna null se a autenticação falhar
    }
}
