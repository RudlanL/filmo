package fr.eni.filmo.ihm;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.filmo.bll.MovieRestService;
import fr.eni.filmo.bo.Movie;

@RestController
public class RestMovieController {
	private MovieRestService movieService;
	public RestMovieController(MovieRestService movieService) {
		this.movieService = movieService;
	}
	@GetMapping("/api/movies")
	public List<Movie> restMovies() {
		return this.movieService.selectAll();
	}
	@GetMapping("/api/movies/{movieId}")
	public ResponseEntity<Movie> restMovies(@PathVariable int movieId) {
		Long newId = Long.valueOf(movieId);
		Optional<Movie> mov = this.movieService.select(newId);
		if(mov.isPresent()) {
			return new ResponseEntity<Movie>( mov.get(), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Movie>(HttpStatus.BAD_REQUEST);
	}
}
