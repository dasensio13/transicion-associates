package org.transicion.portillo.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {

	Optional<T> findById(Long id);

	List<T> findAll();

	T save(T t);

	void delete(Long id);

}
