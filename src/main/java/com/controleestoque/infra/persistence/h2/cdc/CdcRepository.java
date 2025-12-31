package com.controleestoque.infra.persistence.h2.cdc;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CdcRepository extends JpaRepository<CdcEntity, Long> {
}
