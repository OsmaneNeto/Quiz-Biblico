package com.example.Bible_Quiz_Api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {
    @NotBlank(message = "Username é obrigatório")
    @Size(min = 3, message = "Username deve ter pelo menos 3 caracteres")
    private String username;

    @NotBlank(message = "Username é obrigatório")
    @Size(min = 3, message = "Username deve ter pelo menos 3 caracteres")
    private String password;

    private String role; // A1, A2, A3

    // Getters e Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
