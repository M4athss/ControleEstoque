package com.controleestoque.domain.cdc.model;

import com.controleestoque.infra.persistence.h2.cdc.CdcEntity;

public record Cdc(String codigo, String nome, boolean status) {

    public Cdc(CdcEntity entity){
        this(entity.getCodigo(), entity.getNome(), entity.getStatus());
    }
}
