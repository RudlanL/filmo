package fr.eni.filmo.dal;

import java.util.List;

import fr.eni.filmo.bo.Avis;

public interface AvisDao {
	public void insert(Avis g);
	public List<Avis> selectAll();
	public Avis select(int i);
}


