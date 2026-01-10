package com.controleestoque.controller.cdc;

import com.controleestoque.domain.cdc.model.Cdc;

public record CdcRespose(String codigo, String nome, boolean status) {

    public CdcRespose(Cdc cdc){
        this(cdc.codigo(),cdc.nome(),cdc.status());
    }
}
