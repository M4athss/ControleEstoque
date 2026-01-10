package com.controleestoque.domain.usuario.model;

import java.time.LocalDate;

public record Usuario(String nome, String email, LocalDate dtcriacao) {

}
