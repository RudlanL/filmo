package fr.eni.filmo.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.filmo.bll.AuthenticationService;

@Controller
public class AuthenticationController {
	
	private AuthenticationService authenticationService;
	public AuthenticationController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	@RequestMapping("/")
	public String afficherLogin () {
		return "/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String name,
			@RequestParam String password) {
		
		return "redirect:/form" ;
	}
}
