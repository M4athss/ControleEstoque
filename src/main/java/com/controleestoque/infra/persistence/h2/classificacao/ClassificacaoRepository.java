package com.controleestoque.infra.persistence.h2.classificacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificacaoRepository extends JpaRepository<ClassificacaoEntity, Long> {
}
