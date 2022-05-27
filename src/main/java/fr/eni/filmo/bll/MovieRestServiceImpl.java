package fr.eni.filmo.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.filmo.bo.Movie;
import fr.eni.filmo.dal.MovieRestDao;
@Service
public class MovieRestServiceImpl implements MovieRestService{
	private MovieRestDao movieDao;
	public MovieRestServiceImpl(MovieRestDao movieDao) {
		this.movieDao = movieDao;
	}
	@Override
	public List<Movie> selectAll() {
		return this.movieDao.findAll();
	}
	@Override
	public Optional<Movie> select(Long i) {
		return this.movieDao.findById(i);
	}

}
