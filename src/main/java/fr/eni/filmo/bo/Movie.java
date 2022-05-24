package fr.eni.filmo.bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Size(min = 20, max = 250)
	private String synopsis;

	@NotNull
	@Min(1)
	private int releaseyear;

	@NotNull
	@Min(2)
	private int duration;

	@NotNull
	@ManyToOne
	private Genre genre;

	@NotNull
	@ManyToOne
	private Personne director;

	@NotNull
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "MoviesActors", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
			@JoinColumn(name = "personne_id") })
	private List<Personne> actors;
	
	@OneToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY, orphanRemoval = true , mappedBy="movie") 
	private List<Avis> avis;

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	public Movie() {

	}

	public Movie(Long id, String name, String synopsis, int releaseyear, int duration, Genre genre, Personne director,
			List<Personne> actors) {
		this.id = id;
		this.name = name;
		this.synopsis = synopsis;
		this.releaseyear = releaseyear;
		this.duration = duration;
		this.director = director;
		this.genre = genre;
		this.actors = actors;
	}

	public Movie(String name, String synopsis, int releaseyear, int duration, Genre genre, Personne director,
			List<Personne> actors) {
		this.name = name;
		this.synopsis = synopsis;
		this.releaseyear = releaseyear;
		this.duration = duration;
		this.director = director;
		this.genre = genre;
		this.actors = actors;
	}

	public Movie(String name, String synopsis, int releaseyear, int duration) {
		this.name = name;
		this.synopsis = synopsis;
		this.releaseyear = releaseyear;
		this.duration = duration;
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
