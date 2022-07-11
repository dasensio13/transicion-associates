package org.transicion.portillo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.transicion.portillo.persistence.model.Associate;
import org.transicion.portillo.persistence.repository.AssociateRepository;

@Service
public class AssociateService implements IService<Associate> {

	private static final Logger LOG = LoggerFactory.getLogger(AssociateService.class);

	private final AssociateRepository repository;

	public AssociateService(AssociateRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Optional<Associate> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Associate> findAll() {
		return repository.findAll();
	}

	@Override
	public Associate save(Associate associate) {
		LOG.debug("save associate {}", associate);
		if (ObjectUtils.isEmpty(associate.getId())) {
			associate.setDateCreated(LocalDate.now());
		}
		return repository.save(associate);
	}

}
