package com.example.Bible_Quiz_Api.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configuração para permitir acesso ao registro sem autenticação e exigir autenticação para as demais rotas
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/auth/register").permitAll()  // Acesso livre à rota de registro
                        .anyRequest().authenticated()  // Exigir autenticação para outras rotas
                )
                .csrf(csrf -> csrf.disable());  // Desativa CSRF usando a nova sintaxe com Customizer

        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        // Definindo usuários de exemplo com roles
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN", "USER")
                .build();

        return new InMemoryUserDetailsManager(user, admin); // Usando InMemoryUserDetailsManager
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Codificador de senha
    }
}
