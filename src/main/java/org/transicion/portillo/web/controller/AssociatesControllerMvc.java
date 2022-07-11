package org.transicion.portillo.web.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.transicion.portillo.persistence.model.Associate;
import org.transicion.portillo.service.AssociateService;
import org.transicion.portillo.web.dto.AssociateDto;

@Controller
@RequestMapping(value = "/associates-mvc")
public class AssociatesControllerMvc {

	private AssociateService service;

	public AssociatesControllerMvc(AssociateService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public String getAssociates(Model model) {
		model.addAttribute("associates", service.findAll().stream().map(this::toDto).collect(Collectors.toList()));
		return "associates";
	}

	@GetMapping("/new")
	public String newAssociate(Model model) {
		model.addAttribute("associate", new AssociateDto());
		return "new-associate";
	}

	@PostMapping
	public String createAssociate(@Valid @ModelAttribute("associate") AssociateDto dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "new-associate";
		}
		service.save(toEntity(dto));
		return "redirect:/associates-mvc";
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
