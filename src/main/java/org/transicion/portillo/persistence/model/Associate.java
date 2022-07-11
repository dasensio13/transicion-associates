package org.transicion.portillo.persistence.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Associate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String mail;
	private LocalDate dateCreated;
	private Boolean active;

	public Associate() {
		super();
	}

	public Associate(String name, String mail, LocalDate dateCreated, Boolean active) {
		super();
		this.name = name;
		this.mail = mail;
		this.dateCreated = dateCreated;
		this.active = active;
	}

	public Associate(Associate a) {
		this(a.getName(), a.getMail(), a.getDateCreated(), a.getActive());
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

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Associate [id=" + id + ", name=" + name + ", mail=" + mail + ", dateCreated=" + dateCreated
				+ ", active=" + active + "]";
	}

}
