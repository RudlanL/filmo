package fr.eni.filmo.dal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.eni.filmo.bo.Personne;

@Repository
public class PersonneDaoImpl implements PersonneDao {
	List<Personne> personneList;

	public PersonneDaoImpl() {
		this.personneList = new ArrayList<Personne>();
		Personne p = new Personne("Jean", "Patrick", 1);
		Personne p1 = new Personne("Legrand", "Ken", 2);
		Personne p2 = new Personne("Leptit", "kenny", 3);

		this.insert(p);
		this.insert(p1);
		this.insert(p2);

	}

	@Override
	public void insert(Personne p) {
		this.personneList.add(p);

	}

	@Override
	public List<Personne> selectAll() {
		return this.personneList;

	}

	@Override
	public Personne select(int i) {
		Personne p = null;
		for (Personne personne : this.personneList) {
			if (personne.getId() == i) {
				p = personne;
			}
		}
		return p;
	}

}
