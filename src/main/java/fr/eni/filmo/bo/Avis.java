package fr.eni.filmo.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avis {
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private int rate;
	
	
	@ManyToOne
	private Movie movie;
	@ManyToOne
	private User user ;
	
	public Avis() {
		
	}
	
	public Avis(Long id, String description, int rate , User user , Movie movie) {
		super();
		this.id = id;
		this.description = description;
		this.rate = rate;
		this.user = user;
		this.movie = movie;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Avis( String description, int rate , User user , Movie movie) {
		super();
		
		this.description = description;
		this.rate = rate;
		this.user = user;
		this.movie = movie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
}