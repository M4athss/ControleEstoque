package com.controleestoque.infra.persistence.h2.item;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TBITEM")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Long idclassificacao;

    @Column(nullable = false)
    private LocalDate datacriacao;

    @Column(nullable = false, columnDefinition = "varchar(5)")
    private String unidade;
    private Double precomedio;
    private Long qtdtotal;

    public ItemEntity() {
    }

    public ItemEntity(Long id, String nome, Long idclassificacao, LocalDate datacriacao, String unidade, Double precomedio, Long qtdtotal) {
        this.id = id;
        this.nome = nome;
        this.idclassificacao = idclassificacao;
        this.datacriacao = datacriacao;
        this.unidade = unidade;
        this.precomedio = precomedio;
        this.qtdtotal = qtdtotal;
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

    public Long getIdClassificacao() {
        return idclassificacao;
    }

    public void setIdClassificacao(Long idClassificacao) {
        this.idclassificacao = idClassificacao;
    }

    public LocalDate getDtCriacao() {
        return datacriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.datacriacao = dtCriacao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getPrecoMedio() {
        return precomedio;
    }

    public void setPrecoMedio(Double precoMedio) {
        this.precomedio = precoMedio;
    }

    public Long getQtdTotal() {
        return qtdtotal;
    }

    public void setQtdTotal(Long qtdTotal) {
        this.qtdtotal = qtdTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity that = (ItemEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
