package fr.eni.filmo.bo;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	private String password;
	private String lastname;
	private String firstname;
	private Boolean admin;
	
	@OneToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY, orphanRemoval = true , mappedBy="user") 
	private List<Avis> avis;
	

	public List<Avis> getAvis() {
		return avis;
	}
	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
	public boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public User() {
	}
	public User(String username, String lastname, String firstname, boolean admin) {
		this.admin = admin;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
	}
	public User(String username, String lastname,String password ,String firstname, boolean admin) {
		this.admin = admin;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.username = username;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		return this.username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
