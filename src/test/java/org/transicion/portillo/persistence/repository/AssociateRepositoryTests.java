package org.transicion.portillo.persistence.repository;

import java.time.LocalDate;
import java.util.List;

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
	void findAssociateById_NotFound() {
		Associate findAssociate = repository.findById(1234L).orElse(null);
		Assertions.assertNull(findAssociate);
	}

	@Test
	void findAssociateByName_Found() {
		repository.save(new Associate(2L, "test2", "test@mail.com", LocalDate.now(), true));

		List<Associate> findAssociates = repository.findByName("test2");
		Assertions.assertEquals(1, findAssociates.size());
		Assertions.assertEquals(2L, findAssociates.get(0).getId());
	}

	@Test
	void findAssociateByDate_Found() {
		repository.save(new Associate(3L, "test3", "test@mail.com", LocalDate.now().minusDays(2), true));

		List<Associate> findAssociates = repository.findByDateCreatedBetween(LocalDate.now().minusDays(3),
				LocalDate.now().minusDays(1));
		Assertions.assertEquals(1, findAssociates.size());
		Assertions.assertEquals(3L, findAssociates.get(0).getId());
	}

}
