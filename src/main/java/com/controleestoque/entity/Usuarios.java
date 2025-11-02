package com.controleestoque.entity;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;


@Entity
@Table(name = "TBUSUARIOS")
public class Usuarios implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @Column(unique = true)
    private String email;
    private String senha;

    @Column(nullable = false)
    private Long idgrupo = 1L;
    private LocalDate dtcriacao;
    private String cpf;

    @Column(nullable = false)
    private Long idpapel = 1L;
    private boolean status;

    public Usuarios() {
    }

    public Usuarios(Long id, String nome, String email, String senha, Long idgrupo, LocalDate dtcriacao, String cpf, Long idpapel, boolean status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idgrupo = idgrupo;
        this.dtcriacao = dtcriacao;
        this.cpf = cpf;
        this.idpapel = idpapel;
        this.status = status;
    }

    public void setId(Long id) {
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

    public void setIdgrupo(Long idgrupo) { this.idgrupo = idgrupo; }

    public void setDtcriacao(LocalDate dtcriacao) {
        this.dtcriacao = dtcriacao;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdpapel(Long idpapel) { this.idpapel = idpapel; }

    public void setStatus(boolean status){
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public boolean getStatus() {
        return status;
    }

    public Long getIdgrupo() {
        return idgrupo;
    }

    public LocalDate getDtcriacao() {
        return dtcriacao;
    }

    public String getCpf() {
        return cpf;
    }

    public Long getIdpapel() {
        return idpapel;
    }

    public String getSenha() {
        return senha;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Quando tiver "Roles" (Papeis), vamos tentar retornar aqui.
        // Por enquanto, podemos retornar uma lista vazia.
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha; // Retorna o campo da sua senha
    }

    @Override
    public String getUsername() {
        return this.email; // Usaremos o e-mail como "username"
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Deixe true
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Deixe true
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Deixe true
    }

    @Override
    public boolean isEnabled() {
        return true; // Deixe true
    }
}
