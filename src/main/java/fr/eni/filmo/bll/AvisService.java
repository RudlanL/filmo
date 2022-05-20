package fr.eni.filmo.bll;

import java.util.List;

import fr.eni.filmo.bo.Avis;


public interface AvisService {
	public void insert(Avis a);
	public List<Avis> selectAll();
	public Avis select(int id);
}
