package com.controleestoque.infra.persistence.h2.cdc;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CdcRepository extends JpaRepository<CdcEntity, Long> {

    List<CdcEntity> findByCodigo(String codigo);

    List<CdcEntity> findByStatus(boolean status);
}
