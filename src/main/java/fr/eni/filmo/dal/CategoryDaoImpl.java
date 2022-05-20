package fr.eni.filmo.dal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.eni.filmo.bo.Genre;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	List<Genre> genreList;

	public CategoryDaoImpl() {
		this.genreList = new ArrayList<Genre>();
		Genre g = new Genre("Hooror", 1);
		Genre g1 = new Genre("Adventure", 2);
		Genre g2 = new Genre("Romantique", 3);

		this.insert(g);
		this.insert(g1);
		this.insert(g2);

	}

	@Override
	public void insert(Genre g) {
		this.genreList.add(g);

	}

	@Override
	public List<Genre> selectAll() {
		return this.genreList;

	}

	@Override
	public Genre select(int i) {
		Genre g = null;
		for (Genre genre : this.genreList) {
			if (genre.getId() == i) {
				g = genre;
			}
		}
		return g;
	}
}
