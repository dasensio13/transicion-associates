package org.transicion.portillo.persistence.repository;

import java.util.Optional;

public interface IRepository<T> {

	Optional<T> findById(Long id);
	
	T save(T t);
	
}
