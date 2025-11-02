package com.controleestoque.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private TokenAuthenticationFilter tokenAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. DESABILITA O CSRF (padrão para APIs REST)
                // O H2 Console também precisa que isso esteja desabilitado para sua rota.
                .csrf(csrf -> csrf.disable())

                // Diz ao Spring Security para usar as configurações de CORS
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                // CONFIGURA AS REGRAS DE AUTORIZAÇÃO (A ORDEM IMPORTA!)
                .authorizeHttpRequests(authorize -> authorize
                        // Permite acesso PÚBLICO e COMPLETO ao H2 Console
                        .requestMatchers("/h2-console/**").permitAll()

                        // Permite explicitamente requisições OPTIONS
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        // Permite acesso PÚBLICO ao nosso endpoint de login
                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()

                        // EXIGE autenticação para TODAS as outras requisições
                        .anyRequest().authenticated()
                )


                // 6. DEFINE A API COMO STATELESS (não usará sessões)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // 7. Permite que o H2 Console seja exibido em um <frame>
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))

                // Diz ao Spring para usar o nosso filtro (tokenAuthenticationFilter)
                // ANTES do filtro padrão de login/senha (UsernamePasswordAuthenticationFilter)
                .addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // Este metodo define as regras de CORS que o Spring Security usará.
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Permite requisições da origem do seu Live Server
        configuration.setAllowedOrigins(List.of("http://127.0.0.1:5500", "http://localhost:5500"));

        // Permite todos os métodos que vamos usar (incluindo o OPTIONS de simulação)
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));

        // Permite os cabeçalhos que seu front-end enviará (especialmente Content-Type)
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type", "Cache-Control"));

        // Permite que o front-end envie credenciais (cookies, etc.)
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Aplica essas regras a todas as rotas da sua API ("/**")
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}