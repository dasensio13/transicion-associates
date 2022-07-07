package org.transicion.portillo.service;

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
		Associate savedAssociate = service.save(new Associate());
		Assertions.assertNotNull(savedAssociate);
	}

}
