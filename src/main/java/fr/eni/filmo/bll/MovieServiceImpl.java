package fr.eni.filmo.bll;

import java.util.List;

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
		this.movieDao.insert(m);
		
	}

	@Override
	public List<Movie> selectAll() {
		return movieDao.selectAll();
	}
	@Override
	public Movie select(int i) throws MovieNotFound {
		return  movieDao.select(i);
	}

}
