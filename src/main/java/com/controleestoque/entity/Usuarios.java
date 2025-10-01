package com.controleestoque.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "TBUSUARIOS")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String email;
    private String senha;
    private long idgrupo;
    private Date dtcriacao;
    private String cpf;
    private long idpapel;

    public Usuarios() {
    }

    public Usuarios(long id, String nome, String email, String senha, long idgrupo, Date dtcriacao, String cpf, long idpapel) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idgrupo = idgrupo;
        this.dtcriacao = dtcriacao;
        this.cpf = cpf;
        this.idpapel = idpapel;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIdgrupo(long idgrupo) {
        this.idgrupo = idgrupo;
    }

    public void setDtcriacao(Date dtcriacao) {
        this.dtcriacao = dtcriacao;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdpapel(long idpapel) {
        this.idpapel = idpapel;
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
        Usuarios usuarios = (Usuarios) o;
        return id == usuarios.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
