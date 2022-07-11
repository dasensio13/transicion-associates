package org.transicion.portillo.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.transicion.portillo.persistence.model.Associate;

@SpringBootTest
class AssociateServiceTests {

	@Autowired
	private IService<Associate> service;

	@Test
	void saveAssociate() {
		Associate newAssociate = new Associate("test", "test@mail.com", LocalDate.now(), true);
		Associate savedAssociate = service.save(newAssociate);
		Assertions.assertNotNull(savedAssociate);
	}

}
