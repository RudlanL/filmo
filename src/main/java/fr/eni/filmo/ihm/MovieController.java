package fr.eni.filmo.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.filmo.bll.MovieService;
import fr.eni.filmo.bo.Genre;
import fr.eni.filmo.bo.Movie;
import fr.eni.filmo.bo.Personne;

@Controller
public class MovieController {
	private MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@PostMapping("/movies")
	public String hello(
			@RequestParam String name,
			@RequestParam int releaseYear,
			@RequestParam int duration,
			@RequestParam String synopsis,
			@RequestParam String directorFirstName,
			@RequestParam String directorLastName,
			@RequestParam String genre 
		) {
		Personne p = new Personne(directorFirstName, directorLastName);
		Genre g = new Genre(genre);
		Movie mov = new Movie(15,name , synopsis , duration , releaseYear, g, p );
		movieService.insert(mov);
		return "redirect:/movies";
	}

	@GetMapping("/movies")
	public String afficherListeMovies(Model model) {
		System.out.println( movieService.selectAll().size());
		model.addAttribute("movies", movieService.selectAll());
		System.out.println( movieService.selectAll().size());
		return "listeMovie";
	}

	@GetMapping("/movies/{id}")
	public String hello(@PathVariable int id, Model model) {
		model.addAttribute("movie", movieService.select(id));
		return "movie";
	}
}
