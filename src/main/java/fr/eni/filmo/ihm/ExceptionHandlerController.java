package fr.eni.filmo.ihm;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.eni.filmo.bo.MovieNotFound;
import fr.eni.filmo.bo.UserNotFound;


@ControllerAdvice
public class ExceptionHandlerController {
	@ExceptionHandler({UserNotFound.class, MovieNotFound.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlePersonneNotFound(Exception e, Model model) {
		model.addAttribute("exception", e);
		return "errors/error";
    }
}
