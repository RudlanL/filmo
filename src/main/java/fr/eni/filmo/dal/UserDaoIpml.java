package fr.eni.filmo.dal;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.eni.filmo.bo.User;
import fr.eni.filmo.bo.UserNotFound;

/*
@Repository
public class UserDaoIpml implements UserDao{
	List<User> users;
	@Override
	public List<User> selectAll() {
		return this.users;
	}

	@Override
	public User select(int i) throws UserNotFound {
		for(User user: this.users) {
			if(user.getId() == i) {
				return user;
			}
		}
		throw new UserNotFound();
	}

	@Override
	public boolean checkUser(String login, String password) {
		User u = null;
		for(User user: this.users) {
			if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
				u = user;
			}
		}
		return u != null;
	}

}
*/