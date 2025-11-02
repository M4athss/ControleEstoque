package com.controleestoque.service;

import com.controleestoque.dto.UsuariosDTO;
import com.controleestoque.entity.Usuarios;
import com.controleestoque.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuariosRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; //criptogafando a senha da API

    public List<UsuariosDTO> findall(){
        List<Usuarios> result = usuarioRepository.findAll();
        return result.stream().map(UsuariosDTO::new).toList();
    }

    public void add(Usuarios entidade){
        String senhaPura = entidade.getSenha();//criptogafando a senha da API
        String senhaCriptografada = passwordEncoder.encode(senhaPura);//criptogafando a senha da API
        entidade.setSenha(senhaCriptografada);//criptogafando a senha da API
        entidade.setStatus(true);
        entidade.setDtcriacao(LocalDate.now());
        usuarioRepository.save(entidade);

    }

}
