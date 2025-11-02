package com.controleestoque.security;

import com.controleestoque.service.CustomUserDetailsService;
import com.controleestoque.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component // Diz ao Spring para gerenciar esta classe
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    // Este é o metodo principal do filtro, ele roda em TODA requisição
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // 1. Pega o token do cabeçalho da requisição
        String token = recuperarToken(request);

        // 2. Se um token foi encontrado e é válido...
        if (token != null && tokenService.validarToken(token)) {
            // 3. Pega o e-mail de dentro do token
            String email = tokenService.getEmailDoToken(token);

            // 4. Carrega o usuário do banco de dados (usando o serviço que já criamos)
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);

            // 5. Cria um "pacote" de autenticação para o Spring
            var authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );

            // 6. [IMPORTANTE]
            // Salva essa autenticação no contexto do Spring Security.
            // A partir daqui, o Spring sabe que o usuário está autenticado.
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // 7. Independentemente de ter autenticado ou não, passa a requisição adiante
        // (Se não autenticou, o SecurityConfig vai bloquear mais tarde)
        filterChain.doFilter(request, response);
    }

    // Metodo auxiliar para extrair o token do cabeçalho "Authorization"
    private String recuperarToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null; // Não encontrou o token
        }
        // Retorna apenas o token, sem o prefixo "Bearer "
        return authHeader.substring(7);
    }
}