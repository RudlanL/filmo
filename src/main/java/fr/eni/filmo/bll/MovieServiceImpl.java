package fr.eni.filmo.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.filmo.bo.Movie;
import fr.eni.filmo.bo.MovieNotFound;
import fr.eni.filmo.dal.MovieDao;
@Service
public class MovieServiceImpl implements MovieService{
	private MovieDao movieDao;
	
	public MovieServiceImpl(MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	@Override
	public void insert(Movie m) {
		this.movieDao.save(m);
		
	}

	@Override
	public List<Movie> selectAll() {
		return (List<Movie>) movieDao.findAll();
	}
	@Override
	public Movie select(Long i) throws MovieNotFound {
		return  movieDao.findById(i).orElseThrow(() -> new MovieNotFound());
	}

}
