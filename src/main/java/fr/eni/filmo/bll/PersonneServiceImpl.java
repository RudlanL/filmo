package fr.eni.filmo.bll;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.filmo.bo.Personne;
import fr.eni.filmo.dal.DirectorDao;

@Service
public class PersonneServiceImpl implements PersonneService {

	private DirectorDao directorDao;
	
	public PersonneServiceImpl(DirectorDao directorDao) {
		this.directorDao = directorDao;
	}
	@Override
	public void insert(Personne p) {
		this.directorDao.insert(p);
		
	}

	@Override
	public List<Personne> selectAll() {
		return this.directorDao.selectAll();
	}
	@Override
	public Personne select(int i) {
		return  this.directorDao.select(i);
	}
}
