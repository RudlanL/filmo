package fr.eni.filmo.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.eni.filmo.bo.Movie;
import fr.eni.filmo.bo.MovieNotFound;

public interface MovieDao extends CrudRepository<Movie, Long>{
}
