package fr.eni.filmo.ihm;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.security.core.Authentication;

import fr.eni.filmo.bll.AvisService;
import fr.eni.filmo.bll.CategoryService;
import fr.eni.filmo.bll.MovieService;
import fr.eni.filmo.bll.PersonneService;
import fr.eni.filmo.bo.Avis;
import fr.eni.filmo.bo.Movie;
import fr.eni.filmo.bo.MovieNotFound;
import fr.eni.filmo.bo.User;

@Controller
@SessionAttributes("user")
public class MovieController {
	private MovieService movieService;
	private PersonneService personneService;
	private CategoryService categoryService;
	private AvisService avisService;

	public MovieController(MovieService movieService, PersonneService personneService, CategoryService categoryService,
			AvisService avisService) {
		this.movieService = movieService;
		this.personneService = personneService;
		this.categoryService = categoryService;
		this.avisService = avisService;
	}

	@PostMapping("/form")
	public String hello(@Valid @ModelAttribute("movie") Movie movie, BindingResult validationResult, Model model) {
		Movie mov = movie;
		if (validationResult.hasErrors()) {
			model.addAttribute("personnes", personneService.selectAll());
			model.addAttribute("genres", categoryService.selectAll());
			return "form";
		}
		movieService.insert(mov);
		return "redirect:/movies";
	}

	@GetMapping({ "", "/movies" })
	public String afficherListeMovies(Model model) {
		model.addAttribute("movies", movieService.selectAll());
		return "listeMovie";
	}

	@GetMapping("/movies/{movieId}")
	public String hello(@PathVariable int movieId, Model model) throws MovieNotFound {
		Long newId = Long.valueOf(movieId);
		model.addAttribute("movie", movieService.select(newId));
		return "movie";
	}

	@GetMapping("/form")
	public String indexFormulaire(Model model) {
		model.addAttribute("personnes", personneService.selectAll());
		model.addAttribute("genres", categoryService.selectAll());
		model.addAttribute("movie", new Movie());
		return "form";
	}

	@GetMapping("/movies/{movieId}/avis")
	public String affichierAvis(@PathVariable int movieId, Model model) throws MovieNotFound {
		Long newId = Long.valueOf(movieId);
		model.addAttribute("avis", movieService.select(newId).getAvis());
		model.addAttribute("movie", movieService.select(newId));
		return "avis";
	}

	@PostMapping("/movies/{movieId}/avis")
	public String avis(@Valid @ModelAttribute("avis") Avis avis, BindingResult validationResult, Model model,
			@PathVariable int movieId) throws MovieNotFound {
		Long newId = Long.valueOf(movieId);
		Movie mov = movieService.select(newId);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User u = (User) auth.getPrincipal();
		avis.setMovie(mov);
		avis.setUser(u);
		avisService.insert(avis);
		return "redirect:/movies";
	}

	@GetMapping("/movies/{movieId}/avisform")
	public String saisirAvis(@PathVariable int movieId, Model model) throws MovieNotFound {
		Long newId = Long.valueOf(movieId);
		model.addAttribute("avis", new Avis());
		model.addAttribute("movie", movieService.select(newId));
		return "avisform";

	}
}
