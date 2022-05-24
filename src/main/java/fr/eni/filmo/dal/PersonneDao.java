package fr.eni.filmo.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.filmo.bo.Personne;

public interface PersonneDao extends JpaRepository<Personne, Long> {
	
}
