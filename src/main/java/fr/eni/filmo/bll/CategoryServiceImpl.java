package fr.eni.filmo.bll;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.filmo.bo.CategoryNotFound;
import fr.eni.filmo.bo.Genre;
import fr.eni.filmo.dal.CategoryDao;

@Service
public class CategoryServiceImpl implements CategoryService{
	private CategoryDao categoryDao;
	
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	@Override
	public void insert(Genre g) {
		this.categoryDao.insert(g);
		
	}

	@Override
	public List<Genre> selectAll() {
		return categoryDao.selectAll();
	}
	@Override
	public Genre select(int i) throws CategoryNotFound {
		return  categoryDao.select(i);
	}
}
