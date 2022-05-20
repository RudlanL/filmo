package fr.eni.filmo.dal;

import java.util.List;

import fr.eni.filmo.bo.User;
import fr.eni.filmo.bo.UserNotFound;

public interface UserDao {
	public List<User> selectAll();
	public User select(int i) throws UserNotFound;
	public boolean checkUser(String login, String password);
}
