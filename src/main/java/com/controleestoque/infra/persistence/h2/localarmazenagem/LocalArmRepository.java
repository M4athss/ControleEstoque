package com.controleestoque.infra.persistence.h2.localarmazenagem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalArmRepository extends JpaRepository<LocalArmEntity, Long> {
}
