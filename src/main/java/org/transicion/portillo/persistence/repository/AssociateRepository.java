package org.transicion.portillo.persistence.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.transicion.portillo.persistence.model.Associate;

public interface AssociateRepository extends JpaRepository<Associate, Long> {

	List<Associate> findByName(String name);

	List<Associate> findByDateCreatedBetween(LocalDate start, LocalDate end);

}