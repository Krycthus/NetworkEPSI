package fr.epsi.myEpsi.forms;

import javax.servlet.http.HttpServletRequest;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.UserService;

public class Login extends AForm {
	
	private final String username = "username";
	private final String password = "password";

	public User getConnectUser (HttpServletRequest request){
		
		String username = getValueFromRequest(request, this.username);
		String password = getValueFromRequest(request, this.password);
		
		
		
		User user = new User();
		
		try{
			user = this.getUser(username, password);
		}catch (Exception e){
			e.printStackTrace();
		}	
		return user;
	}
	
	private User getUser(String username, String password) throws Exception {
		
		UserService us = new UserService();
		User user = us.getUserById(username);
		System.out.println(user.getPassword());
		
		if (user==null || !password.equals(user.getPassword())){
			throw new Exception ("Login / mot de passe incorrect !");
		} else {
			return user;
		}
	}
}
