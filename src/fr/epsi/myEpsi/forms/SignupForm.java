package fr.epsi.myEpsi.forms;

import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.UserService;

public class SignupForm extends AForm {
	
	private final String Username = "Admin";
	private final String Password = "MotDePasse";
	private final String CurrentPassword = "MotDePasseConfirmation";
	private Boolean admin;
	
	public SignupForm(){
		this.admin = false;
	}
	
	public SignupForm(Boolean admin){
		this.admin = admin;
	}
	
	public User createUser(HttpServletRequest request){
		String Username = getValueFromRequest(request, this.Username);
		String Password = getValueFromRequest(request, this.Password);
		String CurrentPassword = getValueFromRequest(request, this.CurrentPassword);
		Boolean resAdmin = admin;
		
		User user = new User(Username, Password, resAdmin);
		
		try{
			checkPassword(Password, CurrentPassword);
			try{
				user = addUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return user;
	}
	
	private User addUser( User newUser ) throws Exception {
        UserService us = new UserService();
        User user = us.addUser(newUser);
    	if ( user==null ) {
            throw new Exception( "Identifiant déjà utilisé" );
        }
		return user;
    }
	
	private void checkPassword(String password, String CurrentPassword) throws Exception {
		if (!password.equals(CurrentPassword)){
			throw new Exception ("Les mots de passe sont différents !");
		}
	}
}
