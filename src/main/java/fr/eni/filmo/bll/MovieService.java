package fr.eni.filmo.bll;

import java.util.List;
import java.util.Optional;

import fr.eni.filmo.bo.Movie;
import fr.eni.filmo.bo.MovieNotFound;

public interface MovieService {
	public void insert(Movie m);
	public List<Movie> selectAll();
	public Optional<Movie> select(Long i) throws MovieNotFound;
}
