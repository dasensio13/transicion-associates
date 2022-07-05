package org.transicion.portillo.service;

import java.util.Optional;

public interface IService<T> {

	Optional<T> findById(Long id);
	
	T save(T t);
	
}
