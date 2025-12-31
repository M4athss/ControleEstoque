package com.controleestoque.infra.persistence.h2.saida;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "TBLANSAI")
public class LancamentoSaidaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idsaida;
    @Column(nullable = false)
    private Long iditem;

    @Column(nullable = false)
    private Long numdoc;
    private Long qtde;
    private Double valor;

    public LancamentoSaidaEntity() {
    }

    public LancamentoSaidaEntity(Long id, Long idsaida, Long iditem, Long numdoc, Long qtde, Double valor) {
        this.id = id;
        this.idsaida = idsaida;
        this.iditem = iditem;
        this.numdoc = numdoc;
        this.qtde = qtde;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdsaida() {
        return idsaida;
    }

    public void setIdsaida(Long idsaida) {
        this.idsaida = idsaida;
    }

    public Long getIditem() {
        return iditem;
    }

    public void setIditem(Long iditem) {
        this.iditem = iditem;
    }

    public Long getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(Long numdoc) {
        this.numdoc = numdoc;
    }

    public Long getQtde() {
        return qtde;
    }

    public void setQtde(Long qtde) {
        this.qtde = qtde;
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
        LancamentoSaidaEntity that = (LancamentoSaidaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
