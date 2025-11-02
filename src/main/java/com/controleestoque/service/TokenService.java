package com.controleestoque.service;

import com.controleestoque.entity.Usuarios;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.secret}") // 1. Pega a chave secreta do application.properties
    private String jwtSecret;

    // Define o tempo de expiração do token (ex: 2 horas)
    private final long expirationTime = 1000 * 60 * 60 * 2; // 2 horas em milissegundos

    public String gerarToken(Authentication authentication) {
        // O "authentication.getPrincipal()" retorna o objeto UserDetails (nosso Usuario)
        Usuarios usuarios = (Usuarios) authentication.getPrincipal();

        // Pega a chave secreta e a prepara para assinar o token
        Key secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        return Jwts.builder()
                .setIssuer("API Gestoq") // Quem está emitindo o token
                .setSubject(usuarios.getUsername()) // O "dono" do token (no nosso caso, o e-mail)
                .setIssuedAt(new Date()) // Data de emissão
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // Data de expiração
                .signWith(secretKey, SignatureAlgorithm.HS256) // Assina com o algoritmo HS256
                .compact(); // Constrói o token como uma String
    }

    // --- FILTROS PARA VALIDACAO - PEGAR A CHAVE SECRETA ---
    // (Helper para reutilizarmos a chave)
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    // (Verifica se o token é válido e não expirou)
    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true; // Token é válido
        } catch (Exception e) {
            // Token inválido (expirado, assinatura errada, etc.)
            return false;
        }
    }

    // (Extrai o e-mail de dentro do token)
    public String getEmailDoToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject(); // O "Subject" é o e-mail que definimos em 'gerarToken'
    }
}