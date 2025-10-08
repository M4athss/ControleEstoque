package com.controleestoque.service;

import com.controleestoque.dto.UsuariosDTO;
import com.controleestoque.entity.Usuarios;
import com.controleestoque.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuariosRepository usuarioRepository;

    public List<UsuariosDTO> findall(){
        List<Usuarios> result = usuarioRepository.findAll();
        return result.stream().map(UsuariosDTO::new).toList();
    }

    public void add(Usuarios entidade){
        entidade.setStatus(true);
        entidade.setDtcriacao(LocalDate.now());
        usuarioRepository.save(entidade);

    }

}
