package fr.eni.filmo.ihm;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.filmo.bll.PersonneService;
import fr.eni.filmo.bo.Personne;

@Controller
public class PersonneController {
	private PersonneService personneService;

	public PersonneController(PersonneService personneService) {
		this.personneService = personneService;
	}

	@GetMapping("/person-form")
	public String renderPersonneForm(Model model) {
		model.addAttribute("person", new Personne());
		return "personneForm";

	}

	@PostMapping("/person-form")
	public String submitPersonneForm(@Valid @ModelAttribute("person") Personne personne, BindingResult validationResult,
			Model model) {
		if (validationResult.hasErrors()) {
			return "personneForm";
		}
		this.personneService.insert(personne);
		model.addAttribute("sucess", true);
		model.addAttribute("person", new Personne());
		return "personneForm";
	}
}
