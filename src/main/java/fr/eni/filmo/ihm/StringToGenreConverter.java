package fr.eni.filmo.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.eni.filmo.bll.CategoryService;
import fr.eni.filmo.bo.CategoryNotFound;
import fr.eni.filmo.bo.Genre;

@Component
public class StringToGenreConverter implements Converter<String, Genre> {

	private CategoryService service;

	@Autowired
	public void setMetierService(CategoryService service) {
		this.service = service;
	}

	@Override
	public Genre convert(String source) {
		Integer theid = Integer.parseInt(source);
		try {
			return service.select(theid);
		} catch (CategoryNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
