package com.example.Bible_Quiz_Api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDto {
    @NotBlank(message = "Username é obrigatório")
    @Size(min = 3, message = "Username deve ter pelo menos 3 caracteres")
    private String username;

    @NotBlank(message = "Username é obrigatório")
    @Size(min = 3, message = "Username deve ter pelo menos 3 caracteres")
    private String password;

    private String role; // A1, A2, A3

    @NotNull
    @Email(message = "Email deve ser válido.")
    private String email;  // Novo campo email

    // Getters e Setters

    //Email

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Username

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //Password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Role

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
