package fr.eni.filmo.bo;

import java.util.List;

public class Movie {
	private int id;
	private String name;
	private String synopsis;
	private int releaseyear;
	private int duration;
	private Genre genre;
	private Personne director;
	private List<Personne> actors;
	private List<Avis> avis ;
	
	public List<Avis> getAvis() {
		return avis;
	}
	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}
	public Movie() {
		
	}
	public Movie(int id, String name, String synopsis, int releaseyear, int duration,Genre genre, Personne director, List<Personne> actors) {
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Personne> getActors() {
		return actors;
	}
	public void setActors(List<Personne> actors) {
		this.actors = actors;
	}
}
