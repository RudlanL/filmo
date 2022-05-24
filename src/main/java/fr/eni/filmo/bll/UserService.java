package fr.eni.filmo.bll;

import java.util.List;

import fr.eni.filmo.bo.User;

public interface UserService {
	public void insert(User g);
	public List<User> selectAll();
	public User select(Long id);
}
