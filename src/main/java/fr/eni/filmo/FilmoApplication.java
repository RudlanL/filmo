package fr.eni.filmo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.eni.filmo.bo.Avis;
import fr.eni.filmo.bo.Genre;
import fr.eni.filmo.bo.Movie;
import fr.eni.filmo.bo.Personne;
import fr.eni.filmo.bo.User;
import fr.eni.filmo.dal.AvisDao;
import fr.eni.filmo.dal.CategoryDao;
import fr.eni.filmo.dal.MovieDao;
import fr.eni.filmo.dal.PersonneDao;
import fr.eni.filmo.dal.UserDao;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class FilmoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmoApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(MovieDao movieDao, CategoryDao categoryDao, PersonneDao personneDao , UserDao userDao ,  AvisDao avisDao, PasswordEncoder passwordEncoder) {
		return (args) -> {
			Genre g = new Genre("Hooror");
			Genre g1 = new Genre("Adventure");
			Genre g2 = new Genre("Romantique");
			categoryDao.save(g);
			categoryDao.save(g1);
			categoryDao.save(g2);
			User u = new User("Kennyx", "Legrand",passwordEncoder.encode("toto"),"ken", true);
			userDao.save(u);
			Personne p = new Personne("Jean", "Patrick");
			Personne p1 = new Personne("Legrand", "Ken");
			Personne p2 = new Personne("Leptit", "kenny");
			List<Personne> actors = new ArrayList<Personne>();
			actors.add(p);
			actors.add(p1);
			actors.add(p2);
			personneDao.save(p);
			personneDao.save(p1);
			personneDao.save(p2);
			actors = personneDao.findAll();
			p = personneDao.findById(p.getId()).get();
			
			Movie m1 = new Movie("Saw", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc dignissim non neque sed semper. Nulla mi nisi, bibendum ut sollicitudin nec, mollis sit amet augue. Fusce rhoncus, mauris ac porta pharetra gravida.", 2021, 210, g, p, actors );
			Movie m2 = new Movie("Conjuring", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc dignissim non neque sed semper. Nulla mi nisi, bibendum ut sollicitudin nec, mollis sit amet augue. Fusce rhoncus, mauris ac porta pharetra gravida.", 2021, 155 ,g, p, actors);
			Movie m3 = new Movie("Conjuring 2 ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc dignissim non neque sed semper. Nulla mi nisi, bibendum ut sollicitudin nec, mollis sit amet augue. Fusce rhoncus, mauris ac porta pharetra gravida.", 2021, 152, g, p, actors );
			
			movieDao.save(m1);
			movieDao.save(m2);
			movieDao.save(m3);
			
			Avis a = new Avis("C'est nul",12 , u , m1);
			avisDao.save(a);
			
		};
	}
	

}
