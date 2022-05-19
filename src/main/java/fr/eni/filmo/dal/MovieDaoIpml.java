package fr.eni.filmo.dal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.eni.filmo.bo.Genre;
import fr.eni.filmo.bo.Movie;
import fr.eni.filmo.bo.Personne;

@Repository
public class MovieDaoIpml implements MovieDao{
	List<Movie> movieList;
	public MovieDaoIpml() {
		this.movieList = new ArrayList<Movie>();
		Personne p = new Personne("Cailloux", "Pierre");
		Genre g = new Genre("Horror");
		Movie m1 = new Movie( 0, "Saw", "ajhgaguitiufgayf", 15, 5, g, p);
		Movie m2 = new Movie(1, "Conjuring", "auefyfeavyufav r_xcra-", 17, 155, g, p);
		Movie m3 = new Movie(2, "Conjuring 2 ", "agiurexavè-v airtg_xèbr_gxa", 19, 152, g, p);
		this.insert(m1);
		this.insert(m2);
		this.insert(m3);
	}
	@Override
	public void insert(Movie m) {
		this.movieList.add(m);
	}

	@Override
	public List<Movie> selectAll() {
		return this.movieList;
	}
	@Override
	public Movie select(int i) {
		Movie m = null;
		for(Movie movie: this.movieList) {
			if(movie.getId() == i) {
				m = movie;
			}
		}
		return m;
	}

}
