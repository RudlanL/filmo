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
		this.categoryDao.save(g);
		
	}

	@Override
	public List<Genre> selectAll() {
		return categoryDao.findAll();
	}
	@Override
	public Genre select(Long i) throws CategoryNotFound {
		return  categoryDao.getById(i);
	}
}
