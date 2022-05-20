package fr.eni.filmo.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.eni.filmo.bll.PersonneService;
import fr.eni.filmo.bo.Personne;

@Component 
public class StringToPersonneConverter implements Converter<String, Personne>{
	
	private PersonneService service;
	
	@Autowired
	public void setMetierService(PersonneService service) {
		this.service = service;
	}
	@Override
	public Personne convert(String source) {
		Integer theid = Integer.parseInt(source);
		return service.select(theid);
	}

}