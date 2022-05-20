package fr.eni.filmo.bll;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.filmo.bo.Avis;
import fr.eni.filmo.dal.AvisDao;

@Service
public class AvisServiceImpl implements AvisService{
	private AvisDao avisDao;
	
	public AvisServiceImpl(AvisDao avisDao) {
		this.avisDao = avisDao;
	}
	@Override
	public void insert(Avis a) {
		this.avisDao.insert(a);
		
	}

	@Override
	public List<Avis> selectAll() {
		return avisDao.selectAll();
	}
	@Override
	public Avis select(int i) {
		return  avisDao.select(i);
	}
}
