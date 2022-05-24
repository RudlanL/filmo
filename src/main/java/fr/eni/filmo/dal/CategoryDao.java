package fr.eni.filmo.dal;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.filmo.bo.Genre;


public interface CategoryDao extends JpaRepository<Genre, Long>{
}


