package fr.eni.filmo.bo;

public class Personne {
	private String lastname;
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
	public Personne(String lastname, String firstname) {
		this.lastname = lastname;
		this.firstname = firstname;
	}
	
}
