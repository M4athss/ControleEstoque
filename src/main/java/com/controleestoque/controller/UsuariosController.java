package com.controleestoque.controller;

import com.controleestoque.dto.UsuariosDTO;
import com.controleestoque.entity.Usuarios;
import com.controleestoque.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioservico;

    @GetMapping(value = "")
    public List<UsuariosDTO> findall(){
        return usuarioservico.findall();
    }
}
