package fr.epsi.myEpsi.service;

import fr.epsi.myEpsi.beans.User;

public class ConnectionService implements IConnectionService {

	@Override
	public boolean isAuthorized(User user) {
		Boolean res = false;
		if(user.getAdministrator()){
			res = true;
		}
		return res;
	}
}
