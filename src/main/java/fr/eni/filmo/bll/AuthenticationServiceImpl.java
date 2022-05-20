package fr.eni.filmo.bll;

import org.springframework.stereotype.Service;

import fr.eni.filmo.bo.User;
import fr.eni.filmo.dal.UserDao;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	private UserDao userDao;
	public AuthenticationServiceImpl(UserDao userDao) {
		
	}
	@Override
	public boolean connect(User u) {
		
		return false;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

}
