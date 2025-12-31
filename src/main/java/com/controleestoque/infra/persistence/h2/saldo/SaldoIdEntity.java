package com.controleestoque.infra.persistence.h2.saldo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SaldoIdEntity implements Serializable {

    @Column(name = "id_item")
    private Long itemid;

    @Column(name = "id_local_armazenagem")
    private Long localarmid;

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false)
    private int mes;

    public SaldoIdEntity() {}

    public SaldoIdEntity(Long itemid, Long localarmid, int ano, int mes) {
        this.itemid = itemid;
        this.localarmid = localarmid;
        this.ano = ano;
        this.mes = mes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaldoIdEntity)) return false;
        SaldoIdEntity that = (SaldoIdEntity) o;
        return ano == that.ano &&
                mes == that.mes &&
                Objects.equals(itemid, that.itemid) &&
                Objects.equals(localarmid, that.localarmid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemid, localarmid, ano, mes);
    }
}

