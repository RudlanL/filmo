package fr.eni.filmo.dal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.eni.filmo.bo.Avis;

@Repository
public class AvisDaoImpl implements AvisDao {
	List<Avis> avisList;

	public AvisDaoImpl() {
		this.avisList = new ArrayList<Avis>();
		Avis a = new Avis(1,"C'est genial", 1);
		Avis a1 = new Avis(2,"c'est nul", 2);
		Avis a2 = new Avis(3,"c'est moyen", 3);

		this.insert(a);
		this.insert(a1);
		this.insert(a2);

	}

	@Override
	public void insert(Avis a) {
		this.avisList.add(a);

	}

	@Override
	public List<Avis> selectAll() {
		return this.avisList;

	}

	@Override
	public Avis select(int i) {
		Avis a = null;
		for (Avis avis : this.avisList) {
			if (avis.getId() == i) {
				a = avis;
			}
		}
		return a;
	}
}
