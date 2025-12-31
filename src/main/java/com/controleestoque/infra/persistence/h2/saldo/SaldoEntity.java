package com.controleestoque.infra.persistence.h2.saldo;

import com.controleestoque.infra.persistence.h2.item.ItemEntity;
import com.controleestoque.infra.persistence.h2.localarmazenagem.LocalArmEntity;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.util.Objects;

@Entity
@Table(name = "TBSALDO")
public class SaldoEntity {

    @EmbeddedId
    private SaldoIdEntity id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("itemid")
    @JoinColumn(name = "id_item", nullable = false)
    private ItemEntity item;

    private Double vlrtotal;
    private Long qtdtotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("localarmid")
    @JoinColumn(name = "id_local_armazenagem", nullable = false)
    private LocalArmEntity localarm;

    public SaldoEntity() {
    }

    public SaldoEntity(ItemEntity item, int ano, int mes, Double vlrtotal, Long qtdtotal, LocalArmEntity localarm) {
        this.item = item;
        this.vlrtotal = vlrtotal;
        this.qtdtotal = qtdtotal;
        this.localarm = localarm;
    }

    public ItemEntity getIdItem() {
        return item;
    }

    public void setIdItem(ItemEntity idItem) {
        this.item = idItem;
    }

    public Double getVlrTotal() {
        return vlrtotal;
    }

    public void setVlrTotal(Double vlrTotal) {
        this.vlrtotal = vlrTotal;
    }

    public Long getQtdTotal() {
        return qtdtotal;
    }

    public void setQtdTotal(Long qtdTotal) {
        this.qtdtotal = qtdTotal;
    }

    public LocalArmEntity getIdLocalArm() {
        return localarm;
    }

    public void setIdLocalArm(LocalArmEntity localarm) {
        this.localarm = localarm;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SaldoEntity that = (SaldoEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
