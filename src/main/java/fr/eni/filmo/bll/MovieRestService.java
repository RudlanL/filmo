package fr.eni.filmo.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.filmo.bo.Movie;

@Service
public interface MovieRestService {
	public List<Movie> selectAll();
	public Optional<Movie> select(Long i);
}
