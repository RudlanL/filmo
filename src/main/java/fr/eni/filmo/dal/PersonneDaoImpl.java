package fr.eni.filmo.dal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.eni.filmo.bo.Personne;
import fr.eni.filmo.bo.PersonneNotFound;

/*
@Repository
public class PersonneDaoImpl implements PersonneDao {
	List<Personne> personneList;

	public PersonneDaoImpl() {
		this.personneList = new ArrayList<Personne>();
		Personne p = new Personne("Jean", "Patrick", Long.valueOf(1));
		Personne p1 = new Personne("Legrand", "Ken", Long.valueOf(2));
		Personne p2 = new Personne("Leptit", "kenny", Long.valueOf(3));

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
	public Personne select(Long i) throws PersonneNotFound {
		Personne p = null;
		for (Personne personne : this.personneList) {
			if (personne.getId() == i) {
				return personne;
			}
		}
		throw new PersonneNotFound();
	}

}*/
