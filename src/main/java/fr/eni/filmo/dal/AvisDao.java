package fr.eni.filmo.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.filmo.bo.Avis;

public interface AvisDao extends JpaRepository<Avis, Long> {

}


