package com.controleestoque.infra.persistence.h2.saida;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoSaidaRepository extends JpaRepository<LancamentoSaidaEntity, Long> {
}
