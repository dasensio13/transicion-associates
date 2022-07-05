package org.transicion.portillo.persistence.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.transicion.portillo.persistence.model.Associate;

public class AssociateRepository implements IRepository<Associate> {

	List<Associate> associates = new ArrayList<>();

	@Override
	public Optional<Associate> findById(Long id) {
		return associates.stream().filter(a -> a.getId().equals(id)).findFirst();
	}

	@Override
	public Associate save(Associate associate) {
		Associate existing = findById(associate.getId()).orElse(null);
		if (existing == null) {
			associates.add(associate);
			return existing;
		} else {
			associates.remove(existing);
			Associate newAssociate = new Associate(existing);
			associates.add(newAssociate);
			return newAssociate;
		}
	}

}
