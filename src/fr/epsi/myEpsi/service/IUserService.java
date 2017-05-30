package fr.epsi.myEpsi.service;

import java.util.List;

import fr.epsi.myEpsi.beans.User;

public interface IUserService {

	List<User> getListOfUsers();
	User getUserById(String id);
	User addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);

}
