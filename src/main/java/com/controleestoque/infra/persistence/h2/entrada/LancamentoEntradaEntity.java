package com.controleestoque.infra.persistence.h2.entrada;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

public class LancamentoEntradaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numdoc;
    private Long identrada;
    private Long iditem;
    private int quantidade;
    private Double valor;

    public LancamentoEntradaEntity() {
    }

    public LancamentoEntradaEntity(Long id, int numdoc, Long identrada, Long iditem, int quantidade, Double valor) {
        this.id = id;
        this.numdoc = numdoc;
        this.identrada = identrada;
        this.iditem = iditem;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(int numdoc) {
        this.numdoc = numdoc;
    }

    public Long getIdentrada() {
        return identrada;
    }

    public void setIdentrada(Long identrada) {
        this.identrada = identrada;
    }

    public Long getIditem() {
        return iditem;
    }

    public void setIditem(Long iditem) {
        this.iditem = iditem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LancamentoEntradaEntity that = (LancamentoEntradaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
