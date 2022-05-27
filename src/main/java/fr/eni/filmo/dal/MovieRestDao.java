package fr.eni.filmo.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import fr.eni.filmo.bo.Movie;

@RepositoryRestResource(collectionResourceRel = "movie", path = "movies")
public interface MovieRestDao extends JpaRepository<Movie, Long>{

}
