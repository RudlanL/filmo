package fr.eni.filmo.bll;

import java.util.List;

import fr.eni.filmo.bo.Personne;
import fr.eni.filmo.bo.PersonneNotFound;

public interface PersonneService {
	public void insert(Personne p);
	public List<Personne> selectAll();
	public Personne select(int id) throws PersonneNotFound;
}
