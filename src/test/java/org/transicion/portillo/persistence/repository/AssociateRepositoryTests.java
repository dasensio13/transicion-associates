package org.transicion.portillo.persistence.repository;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.transicion.portillo.persistence.model.Associate;

@SpringBootTest
class AssociateRepositoryTests {

	@Autowired
	private AssociateRepository repository;

	@Test
	void saveAssociate() {
		Associate newAssociate = new Associate(1L, "test", "test@mail.com", LocalDate.now(), true);
		Associate savedAssociate = repository.save(newAssociate);
		Assertions.assertNotNull(savedAssociate);
	}

	@Test
	void findAssociate() {
		Associate findAssociate = repository.findById(1234L).orElse(null);
		Assertions.assertNull(findAssociate);
	}

}
