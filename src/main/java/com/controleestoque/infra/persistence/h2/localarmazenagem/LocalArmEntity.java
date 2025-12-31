package com.controleestoque.infra.persistence.h2.localarmazenagem;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "TBLOCARM")
public class LocalArmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(15)")
    private String nome;
    private boolean status;

    public LocalArmEntity() {
    }

    public LocalArmEntity(Long id, String nome, boolean status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LocalArmEntity that = (LocalArmEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
