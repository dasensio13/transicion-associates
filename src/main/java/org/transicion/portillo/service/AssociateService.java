package org.transicion.portillo.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.transicion.portillo.persistence.model.Associate;
import org.transicion.portillo.persistence.repository.IRepository;

@Service
public class AssociateService implements IService<Associate> {

	private static final Logger LOG = LoggerFactory.getLogger(AssociateService.class);

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
		LOG.debug("save associate {}", associate);
		return repository.save(associate);
	}

}
