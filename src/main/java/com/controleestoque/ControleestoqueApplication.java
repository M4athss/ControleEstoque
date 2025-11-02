package com.controleestoque;

import com.controleestoque.entity.Usuarios;
import com.controleestoque.repository.UsuariosRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ControleestoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleestoqueApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(UsuariosRepository repository, PasswordEncoder passwordEncoder) {
        return args -> {
            String adminEmail = "admin@gestoq.com";

            // 1. Verifica se o usuário já existe
            if (repository.findByEmail(adminEmail).isEmpty()) {
                System.out.println(">>> Criando usuário de teste: " + adminEmail);
                Usuarios adminUser = new Usuarios();
                adminUser.setEmail(adminEmail);
                adminUser.setNome("Administrador Gestoq");
                adminUser.setStatus(true);
                adminUser.setCpf("11111111111");

                // 2. CRIPTOGRAFA A SENHA "123456" ANTES DE SALVAR
                adminUser.setSenha(passwordEncoder.encode("123456"));

                // 3. Define os valores padrão (ex: 1L para "Admin")
                adminUser.setIdpapel(1L);
                adminUser.setIdgrupo(1L);

                repository.save(adminUser);
                System.out.println(">>> Usuário de teste criado com sucesso!");
            }
        };
    }

}
