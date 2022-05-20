package fr.eni.filmo.bll;

import fr.eni.filmo.bo.User;

public interface AuthenticationService {
	public boolean connect(User u);
	public void logout();
}
