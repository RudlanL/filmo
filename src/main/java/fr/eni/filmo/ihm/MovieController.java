package fr.eni.filmo.ihm;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.filmo.bll.AvisService;
import fr.eni.filmo.bll.CategoryService;
import fr.eni.filmo.bll.MovieService;
import fr.eni.filmo.bll.PersonneService;
import fr.eni.filmo.bll.UserService;
import fr.eni.filmo.bo.Avis;
import fr.eni.filmo.bo.Movie;
import fr.eni.filmo.bo.MovieNotFound;
import fr.eni.filmo.bo.User;

@Controller
public class MovieController {
	private MovieService movieService;
	private PersonneService personneService;
	private CategoryService categoryService;
	private AvisService avisService;
	private UserService userService;

	public MovieController(MovieService movieService, PersonneService personneService, CategoryService categoryService,
			AvisService avisService , UserService userService) {
		this.movieService = movieService;
		this.personneService = personneService;
		this.categoryService = categoryService;
		this.avisService = avisService;
		this.userService = userService;
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

	@GetMapping("/movies/{id}")
	public String hello(@PathVariable int id, Model model) throws MovieNotFound {
		Long newId = Long.valueOf(id);
		model.addAttribute("movie", movieService.select(newId).get());
		return "movie";
	}

	@GetMapping("/form")
	public String indexFormulaire(Model model) {
		model.addAttribute("personnes", personneService.selectAll());
		model.addAttribute("genres", categoryService.selectAll());
		model.addAttribute("movie", new Movie());
		return "form";
	}

	@GetMapping("/movies/{id}/avis")
	public String affichierAvis(@PathVariable int id, Model model) throws MovieNotFound {
		Long newId = Long.valueOf(id);
		model.addAttribute("avis", movieService.select(newId).get().getAvis());
		model.addAttribute("movie", movieService.select(newId).get());
		return "avis";
	}

	@PostMapping("/movies/{id}/avis")
	public String avis(@Valid @ModelAttribute("avis") Avis avis, BindingResult validationResult,Model model, @PathVariable int id) throws MovieNotFound {
		Long newId = Long.valueOf(id);
		Movie mov = movieService.select(newId).get();
		System.out.println(userService.selectAll().get(0));
		User user = userService.selectAll().get(0);
		
		avis.setMovie(mov);
		avis.setUser(user);
		avisService.insert(avis);
		return "redirect:/movies";
	}
	@GetMapping("/movies/{id}/avisform")
	 public String saisirAvis(@PathVariable int id, Model model) throws MovieNotFound {
		Long newId = Long.valueOf(id);
		model.addAttribute("avis", new Avis());
		model.addAttribute("movie", movieService.select(newId).get());
		return "avisform";
	
	}
}
