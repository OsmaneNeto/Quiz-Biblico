package com.example.Bible_Quiz_Api.repositories;

import com.example.Bible_Quiz_Api.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {

    // Método customizado para buscar usuário pelo nome de usuário
    UserModel findByUsername(String username);

    // Método customizado para buscar usuário pelo email
    UserModel findByEmail(String email);


}
