package com.controleestoque.infra.persistence.h2.entrada;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "TBENTRADA")
public class EntradaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ano;
    private int mes;
    private LocalDateTime dataentrada;
    private int numdoc;
    private Long idlocalarm;
    private int notafiscal;

    public EntradaEntity() {
    }

    public EntradaEntity(Long id, int ano, int mes, LocalDateTime dataentrada, int numdoc, Long idlocalarm, int notafiscal) {
        this.id = id;
        this.ano = ano;
        this.mes = mes;
        this.dataentrada = dataentrada;
        this.numdoc = numdoc;
        this.idlocalarm = idlocalarm;
        this.notafiscal = notafiscal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public LocalDateTime getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(LocalDateTime dataentrada) {
        this.dataentrada = dataentrada;
    }

    public int getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(int numdoc) {
        this.numdoc = numdoc;
    }

    public Long getIdlocalarm() {
        return idlocalarm;
    }

    public void setIdlocalarm(Long idlocalarm) {
        this.idlocalarm = idlocalarm;
    }

    public int getNotafiscal() {
        return notafiscal;
    }

    public void setNotafiscal(int notafiscal) {
        this.notafiscal = notafiscal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EntradaEntity that = (EntradaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
