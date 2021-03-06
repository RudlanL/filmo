package fr.eni.filmo.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Personne {
	@Id
	@GeneratedValue
	private Long id;
	@NotBlank
	private String lastname;
	@NotBlank
	private String firstname;
	

	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Personne() {
		
	}
	public Personne(String lastname, String firstname , Long id) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.id = id ;
	}
	public Personne(String lastname, String firstname) {
		this.lastname = lastname;
		this.firstname = firstname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
