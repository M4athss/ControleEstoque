package com.controleestoque.infra.persistence.h2.saldo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaldoRepository extends JpaRepository<SaldoEntity, Long> {
}
