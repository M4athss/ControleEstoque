package com.controleestoque.dto;

import com.controleestoque.entity.Usuarios;

import java.util.Date;
import java.util.Objects;

public class UsuariosDTO {

    private long id;

    private String nome;
    private String email;

    public UsuariosDTO() {
    }

    public UsuariosDTO(Usuarios entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuariosDTO that = (UsuariosDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
