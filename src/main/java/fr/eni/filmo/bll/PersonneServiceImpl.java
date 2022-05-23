package fr.eni.filmo.bll;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.filmo.bo.Personne;
import fr.eni.filmo.bo.PersonneNotFound;
import fr.eni.filmo.dal.PersonneDao;

@Service
public class PersonneServiceImpl implements PersonneService {

	private PersonneDao directorDao;
	
	public PersonneServiceImpl(PersonneDao directorDao) {
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
	public Personne select(int i) throws PersonneNotFound {
		return  this.directorDao.select(i);
	}
}
