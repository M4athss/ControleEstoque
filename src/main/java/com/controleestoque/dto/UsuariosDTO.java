package com.controleestoque.dto;

import com.controleestoque.entity.Usuarios;

import java.util.Date;
import java.util.Objects;

public class UsuariosDTO {

    private long id;
    private String cpf;;
    private String nome;
    private String email;
    private long idpapel;
    private long idgrupo;
    private boolean status;

    public UsuariosDTO() {
    }

    public UsuariosDTO(Usuarios entity) {
        this.id = entity.getId();
        this.cpf = entity.getCpf();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.idpapel = entity.getIdpapel();
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

    public long getIdpapel() { return idpapel; }

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
