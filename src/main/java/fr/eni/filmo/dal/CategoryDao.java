package fr.eni.filmo.dal;

import java.util.List;

import fr.eni.filmo.bo.CategoryNotFound;
import fr.eni.filmo.bo.Genre;


public interface CategoryDao {
		public void insert(Genre g);
		public List<Genre> selectAll();
		public Genre select(int i) throws CategoryNotFound;
	}


