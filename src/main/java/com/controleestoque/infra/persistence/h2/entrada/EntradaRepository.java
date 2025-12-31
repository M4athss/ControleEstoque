package com.controleestoque.infra.persistence.h2.entrada;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaRepository extends JpaRepository<EntradaEntity, Long> {
}
