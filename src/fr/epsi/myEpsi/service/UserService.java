package fr.epsi.myEpsi.service;

import java.util.List;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.IUserDao;
import fr.epsi.myEpsi.dao.UserDao;

public class UserService implements IUserService {

	private IUserDao userDao;
	
	public UserService(){
		userDao = new UserDao();
	}
	
	@Override
	public List<User> getListOfUsers() {
		
		return null;
	}

	@Override
	public User getUserById(String id) {
		return null;
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}
	
	public User getUser(User user){
		return userDao.getUser(user);
	}

}
