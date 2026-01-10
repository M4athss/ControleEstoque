package com.controleestoque.infra.persistence.h2.cdc;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "TBCDC")
public class CdcEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false ,unique = true, columnDefinition = "varchar(3)")
    private String codigo;

    @Column(nullable = false)
    private String nome;
    private boolean status;

    public CdcEntity() {
    }

    public CdcEntity(Long id, String codigo, String nome, boolean status) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.status = status;
    }

    public CdcEntity(String codigo, String nome, boolean status) {
        this.codigo = codigo;
        this.nome = nome;
        this.status = status;
    }

    public CdcEntity(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CdcEntity cdcEntity = (CdcEntity) o;
        return Objects.equals(id, cdcEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
