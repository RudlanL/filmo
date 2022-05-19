package fr.eni.filmo.dal;

import java.util.List;

import fr.eni.filmo.bo.Movie;

public interface MovieDao {
	public void insert(Movie m);
	public List<Movie> selectAll();
	public Movie select(int i);
}
