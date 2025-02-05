package com.example.Bible_Quiz_Api.utils;

import com.example.Bible_Quiz_Api.models.UserModel;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // A chave secreta
    private final long EXPIRATION_TIME = 86400000; // 24 horas

    public String generateToken(UserModel user) {
        return Jwts.builder()
                .setSubject(user.getEmail()) // Define o email como assunto
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key) // Assina o token com a chave
                .compact();
    }

    // Método para obter o e-mail do token
    public String getEmailFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(key) // Usamos 'key' ao invés de 'secretKey'
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject(); // O e-mail está sendo usado como "subject"
        } catch (JwtException | IllegalArgumentException e) {
            throw new IllegalArgumentException("Token inválido ou expirado", e);
        }
    }

}
