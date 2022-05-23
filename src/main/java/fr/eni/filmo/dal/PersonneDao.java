package fr.eni.filmo.dal;

import java.util.List;


import fr.eni.filmo.bo.Personne;
import fr.eni.filmo.bo.PersonneNotFound;

public interface PersonneDao {
	public void insert(Personne p);
	public List<Personne> selectAll();
	public Personne select(int i) throws PersonneNotFound;
	
}
