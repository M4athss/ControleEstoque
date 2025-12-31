package com.controleestoque.controller.usuario;

import com.controleestoque.infra.persistence.h2.usuario.UsuarioEntity;
import com.controleestoque.domain.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://127.0.0.1:5500")
@CrossOrigin(origins = "*") //puxando de qualquer origem
@RestController
@RequestMapping(value = "/usuario")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioservico;

    @GetMapping(value = "")
    public List<UsuariosDTO> findall() {
        return null;
    }

    //CRIAR UM MODELO DE USUARIOAPIREQUEST OU USUARIOAPIRESPONSE
    @PostMapping(produces = "application/json")
    public ResponseEntity<?> novo(@RequestBody UsuarioEntity entidade) {
        try {
            if (entidade.getCpf() == null || entidade.getSenha() == null || entidade.getNome() == null || entidade.getEmail() == null || entidade.getId() != 0) {
                throw new RuntimeException();
            } else {
                usuarioservico.add(entidade);
                ResponseEntity.accepted();
            }
        } catch (RuntimeException e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return null;
    }
}
