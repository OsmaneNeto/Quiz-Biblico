package com.example.Bible_Quiz_Api.configs;

import com.example.Bible_Quiz_Api.logs.UserAlreadyExistsException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    // Tratamento para erros de conexão com o banco de dados
    @ExceptionHandler(CannotGetJdbcConnectionException.class)
    public ResponseEntity<String> handleDatabaseConnectionError(CannotGetJdbcConnectionException ex) {
        // Exibe uma mensagem de erro adequada
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Erro ao conectar com o banco de dados. Por favor, verifique a configuração de conexão.");
    }

    // Tratamento para erros de criação de tabelas ou qualquer erro relacionado ao banco de dados
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> handleDatabaseError(DataAccessException ex) {
        // Exibe uma mensagem de erro geral relacionada ao banco de dados
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao acessar o banco de dados. Verifique se as tabelas estão configuradas corretamente.");
    }

    // Tratamento para exceções genéricas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        // Exibe uma mensagem de erro interna
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor.");
    }

}
