package fr.eni.filmo.dal;

import java.util.List;


import fr.eni.filmo.bo.Personne;

public interface DirectorDao {
	public void insert(Personne p);
	public List<Personne> selectAll();
	public Personne select(int i);
	
}
