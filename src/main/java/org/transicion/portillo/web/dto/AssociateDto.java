package org.transicion.portillo.web.dto;

public class AssociateDto {

	private Long id;
	private String name;
	private String mail;
	private Boolean active;

	public AssociateDto() {
		super();
	}

	public AssociateDto(Long id, String name, String mail, Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.active = active;
	}

	public AssociateDto(String name, String mail, Boolean active) {
		super();
		this.name = name;
		this.mail = mail;
		this.active = active;
	}

	public AssociateDto(AssociateDto a) {
		this(a.getId(), a.getName(), a.getMail(), a.getActive());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Associate [id=" + id + ", name=" + name + ", mail=" + mail + ", active=" + active + "]";
	}

}
