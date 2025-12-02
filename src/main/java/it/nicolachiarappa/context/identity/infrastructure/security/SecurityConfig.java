package it.nicolachiarappa.context.identity.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 1. Configura le richieste autorizzate
        http.authorizeHttpRequests(authorize -> authorize

                // Endpoint comuni per la DEV che non richiedono autenticazione
                .requestMatchers("/h2-console/**").permitAll() // H2 Console
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll() // Swagger/OpenAPI

                // Se vuoi permettere temporaneamente TUTTO per sviluppo locale:
                .requestMatchers("/**").permitAll()
                // 👆 ATTENZIONE: Rimuovi o cambia questa riga in produzione!

                // Tutte le altre richieste richiedono autenticazione (il comportamento di default)
                .anyRequest().authenticated()
        );

        // 2. Disabilita il CSRF (necessario per l'H2 Console e test POST/PUT con Postman/cURL)
        http.csrf(AbstractHttpConfigurer::disable);

        // 3. (OPZIONALE) Se stai usando H2 Console: abilita i frame per vederlo
        http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

        return http.build();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder(10);
    }
}