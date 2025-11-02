package com.controleestoque.controller;

import com.controleestoque.dto.LoginRequestDTO;
import com.controleestoque.dto.LoginResponseDTO;
import com.controleestoque.service.TokenService;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "*") //puxando de qualquer origem

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginDTO) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(
                    loginDTO.getEmail(),
                    loginDTO.getSenha()
            );

            Authentication auth = this.authenticationManager.authenticate(usernamePassword);

            // 3. Se o login for bem-sucedido, geramos um token
            String token = tokenService.gerarToken(auth);

            // 4. Retorna o token para o front-end
            return ResponseEntity.ok(new LoginResponseDTO(token));

        } catch (Exception e) {
            // Se a autenticação falhar, retorna um erro 401 (Não Autorizado)
            return ResponseEntity.status(401).body("E-mail ou senha inválidos.");
        }

    }
}
