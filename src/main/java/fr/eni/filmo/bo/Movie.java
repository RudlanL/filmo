package fr.eni.filmo.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Movie {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Size(min= 20, max= 250)
	private String synopsis;
	
	@NotNull
	@Min(1)
	private int releaseyear;
	
	@NotNull
	@Min(2)
	private int duration;
	
	@NotNull
	@Transient
	private Genre genre;
	
	@NotNull
	@Transient
	private Personne director;
	
	@NotNull
	@Transient
	private List<Personne> actors;
	
	@Transient
	private List<Avis> avis ;
	
	public List<Avis> getAvis() {
		return avis;
	}
	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}
	public Movie() {
		
	}
	public Movie(long id, String name, String synopsis, int releaseyear, int duration,Genre genre, Personne director, List<Personne> actors) {
		this.id = id;
		this.name = name;
		this.synopsis = synopsis;
		this.releaseyear = releaseyear;
		this.duration = duration;
		this.setDirector(director);
		this.setGenre(genre);
		this.setActors(actors);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public int getReleaseyear() {
		return releaseyear;
	}
	public void setReleaseyear(int releaseyear) {
		this.releaseyear = releaseyear;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Personne getDirector() {
		return director;
	}
	public void setDirector(Personne director) {
		this.director = director;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Personne> getActors() {
		return actors;
	}
	public void setActors(List<Personne> actors) {
		this.actors = actors;
	}
}
