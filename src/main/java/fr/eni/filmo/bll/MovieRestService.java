package fr.eni.filmo.bll;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.filmo.bo.Movie;

@Service
public interface MovieRestService {
	public List<Movie> selectAll();
	public Movie select(Long i);
}
