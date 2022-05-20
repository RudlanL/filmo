package fr.eni.filmo.ihm;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.filmo.bll.AuthenticationService;
import fr.eni.filmo.bo.User;

@Controller
@SessionAttributes("user")
public class AuthenticationController {
	
	private AuthenticationService authenticationService;
	public AuthenticationController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	@GetMapping("/login")
	public String afficherLogin () {
		return "/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String name,
			@RequestParam String password, Model model) {
		User user = (User) model.getAttribute("user");
		if(user == null) {
			user = new User();
			model.addAttribute("user", user);
		}
		return "redirect:/" ;
	}
}
