package org.transicion.portillo.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.transicion.portillo.persistence.model.Associate;
import org.transicion.portillo.service.AssociateService;
import org.transicion.portillo.web.dto.AssociateDto;

@RestController
@RequestMapping(value = "/associates")
public class AssociatesController {

	private AssociateService service;

	public AssociatesController(AssociateService service) {
		super();
		this.service = service;
	}

	@GetMapping(value = "/{id}")
	public AssociateDto findOne(@PathVariable Long id) {
		return service.findById(id).map(this::toDto)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found for id " + id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody AssociateDto associateDto) {
		service.save(toEntity(associateDto));
	}

	@PutMapping("/{id}")
	public AssociateDto update(@PathVariable("id") Long id, @RequestBody AssociateDto dto) {
		Associate associate = toEntity(dto);
		return this.toDto(service.save(associate));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

	private Associate toEntity(AssociateDto dto) {
		Associate a = new Associate(dto.getName(), dto.getMail(), null, dto.getActive());
		if (!ObjectUtils.isEmpty(dto.getId())) {
			a.setId(dto.getId());
		}
		return a;
	}

	private AssociateDto toDto(Associate a) {
		return new AssociateDto(a.getId(), a.getName(), a.getMail(), a.getActive());
	}

}
