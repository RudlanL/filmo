package fr.eni.filmo.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.filmo.bll.CategoryService;
import fr.eni.filmo.bll.MovieService;
import fr.eni.filmo.bll.PersonneService;
import fr.eni.filmo.bo.Genre;
import fr.eni.filmo.bo.Movie;
import fr.eni.filmo.bo.Personne;

@Controller

public class MovieController {
	private MovieService movieService;
	private PersonneService personneService;
	private CategoryService categoryService;

	public MovieController(MovieService movieService, PersonneService personneService,
			CategoryService categoryService) {
		this.movieService = movieService;
		this.personneService = personneService;
		this.categoryService = categoryService;
	}

	@PostMapping("/movies")
	public String hello(@ModelAttribute("movie") Movie movie) {
		Movie mov = movie;
		movieService.insert(mov);
		return "redirect:/movies";
	}

	@GetMapping({ "", "/movies" })
	public String afficherListeMovies(Model model) {
		System.out.println(movieService.selectAll().size());
		model.addAttribute("movies", movieService.selectAll());
		System.out.println(movieService.selectAll().size());
		return "listeMovie";
	}

	@GetMapping("/movies/{id}")
	public String hello(@PathVariable int id, Model model) {
		model.addAttribute("movie", movieService.select(id));
		return "movie";
	}

	@GetMapping("/form")
	public String indexFormulaire(Model model) {
		model.addAttribute("personnes", personneService.selectAll());
		model.addAttribute("genres", categoryService.selectAll());
		model.addAttribute("movie", new Movie());
		return "form";
	}

}
