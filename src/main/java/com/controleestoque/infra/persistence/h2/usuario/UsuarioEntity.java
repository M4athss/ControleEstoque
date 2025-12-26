package com.controleestoque.infra.persistence.h2.usuario;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TBUSUARIOS")
public class UsuarioEntity {

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
    private boolean status;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Long id, String nome, String email, String senha, Long idgrupo, LocalDate dtcriacao, String cpf, boolean status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idgrupo = idgrupo;
        this.dtcriacao = dtcriacao;
        this.cpf = cpf;
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

    public String getSenha() {
        return senha;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity usuarioEntity = (UsuarioEntity) o;
        return id == usuarioEntity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
