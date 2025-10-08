package com.controleestoque.controller;

import com.controleestoque.dto.UsuariosDTO;
import com.controleestoque.entity.Usuarios;
import com.controleestoque.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping(value = "/usuario")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioservico;

    @GetMapping(value = "")
    public List<UsuariosDTO> findall() {
        return usuarioservico.findall();
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> novo(@RequestBody Usuarios entidade) {
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
