package fr.eni.filmo.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {
	
	@RequestMapping("/")
	public String afficherLogin () {
		return "/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String name,
			@RequestParam String password) {
		
		return "form" ;
	}
}
