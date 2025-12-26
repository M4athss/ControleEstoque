package com.controleestoque.domain.usuario;

import com.controleestoque.infra.persistence.h2.usuario.UsuarioEntity;
import com.controleestoque.infra.persistence.h2.usuario.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuariosRepository usuarioRepository;

    //EXEMPLO DE ESTRUTURA
    public List<Usuario> findall(){
        List<UsuarioEntity> result = usuarioRepository.findAll();
        List<Usuario> usuarios = new ArrayList<>(result.size());
        for(UsuarioEntity entity:result){
            usuarios.add(new Usuario(entity.getNome(),entity.getEmail()));
        }
        return usuarios;
    }
    //PENSAR EM NOMES MAIS CONDIZENTES COM A FUNCAO

    public void add(UsuarioEntity entidade){
        entidade.setStatus(true);
        entidade.setDtcriacao(LocalDate.now());
        usuarioRepository.save(entidade);
    }

}
