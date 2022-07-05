package org.transicion.portillo.service;

import java.util.Optional;

import org.transicion.portillo.persistence.model.Associate;
import org.transicion.portillo.persistence.repository.IRepository;

public class AssociateService implements IService<Associate> {

	private final IRepository<Associate> repository;

	public AssociateService(IRepository<Associate> repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Optional<Associate> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Associate save(Associate associate) {
		return repository.save(associate);
	}

}
