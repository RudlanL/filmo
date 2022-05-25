package fr.eni.filmo.bll;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.eni.filmo.bo.User;
import fr.eni.filmo.dal.UserDao;

@Service
public class AuthenticationServiceImpl implements UserDetailsService{
	private UserDao userDao;
	public AuthenticationServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = this.userDao.findByUsername(username);
		return u;
	}

}
