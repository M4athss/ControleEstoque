package com.controleestoque.infra.persistence.h2.saida;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "TBSAIDAS")
public class SaidaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int mes;

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false)
    private LocalDateTime datacriacao;

    @Column(nullable = false)
    private Long numdoc;
    private Long idlocalarm;
    private Long idcdc;

    public SaidaEntity() {
    }

    public SaidaEntity(Long id, int mes, int ano, LocalDateTime datacriacao, Long numdoc, Long idlocalarm, Long idcdc) {
        this.id = id;
        this.mes = mes;
        this.ano = ano;
        this.datacriacao = datacriacao;
        this.numdoc = numdoc;
        this.idlocalarm = idlocalarm;
        this.idcdc = idcdc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public LocalDateTime getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(LocalDateTime datacriacao) {
        this.datacriacao = datacriacao;
    }

    public Long getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(Long numdoc) {
        this.numdoc = numdoc;
    }

    public Long getIdlocalarm() {
        return idlocalarm;
    }

    public void setIdlocalarm(Long idlocalarm) {
        this.idlocalarm = idlocalarm;
    }

    public Long getIdcdc() {
        return idcdc;
    }

    public void setIdcdc(Long idcdc) {
        this.idcdc = idcdc;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SaidaEntity that = (SaidaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}