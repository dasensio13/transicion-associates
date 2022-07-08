package org.transicion.portillo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.transicion.portillo.persistence.model.Associate;

public interface AssociateRepository extends JpaRepository<Associate, Long> {
}