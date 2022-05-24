package fr.eni.filmo.bll;

import java.util.List;

import fr.eni.filmo.bo.CategoryNotFound;
import fr.eni.filmo.bo.Genre;

public interface CategoryService {
	public void insert(Genre g);
	public List<Genre> selectAll();
	public Genre select(Long id) throws CategoryNotFound;
}
