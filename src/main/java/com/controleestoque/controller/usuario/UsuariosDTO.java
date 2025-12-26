package com.controleestoque.controller.usuario;

import com.controleestoque.infra.persistence.h2.usuario.UsuarioEntity;

import java.util.Objects;

public class UsuariosDTO {

    private long id;
    private String cpf;;
    private String nome;
    private String email;
    private long idgrupo;
    private boolean status;

    public UsuariosDTO() {
    }

    public UsuariosDTO(UsuarioEntity entity) {
        this.id = entity.getId();
        this.cpf = entity.getCpf();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.idgrupo = entity.getIdgrupo();

        this.status = entity.getStatus();

    }

    public long getId() {
        return id;
    }

    public String getCpf() { return cpf; }

    public String getNome() { return nome; }

    public String getEmail() {
        return email;
    }

    public long getIdgrupo() { return idgrupo; }

    public boolean isStatus() {
        return status;
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
