package fr.eni.filmo.bll;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.filmo.bo.User;
import fr.eni.filmo.dal.PersonneDao;
import fr.eni.filmo.dal.UserDao;

@Service
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	
	public UserServiceImpl(PersonneDao directorDao) {
		this.userDao = userDao;
	}
	@Override
	public void insert(User u) {
		this.userDao.save(u);
		
	}

	@Override
	public List<User> selectAll() {
		return this.userDao.findAll();
	}
	@Override
	public User select(Long i)  {
		return  this.userDao.getById(i);
	}
	@Override
	public User selectUserByLogin(String login) {
		return this.userDao.findByUsername(login);
	}

}
