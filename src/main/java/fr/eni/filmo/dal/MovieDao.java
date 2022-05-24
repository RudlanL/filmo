package fr.eni.filmo.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.filmo.bo.Movie;

public interface MovieDao extends JpaRepository<Movie, Long>{
}
