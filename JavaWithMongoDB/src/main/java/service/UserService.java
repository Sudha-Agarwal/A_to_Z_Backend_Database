package service;

import model.User;

import dao.UserDAO;

public class UserService {
	private final UserDAO userDAO;
	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public boolean authenticateUser(String username, String password) {
		User user = userDAO.getUserByUsername(username, password);
		if(user != null && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	

}
