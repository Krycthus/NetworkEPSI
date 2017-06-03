package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


import fr.epsi.myEpsi.beans.User;

public class UserDao implements IUserDao {
	
	private Connection con;
	
	public UserDao() {
		try{
			Class.forName("org.hsqldb.jdbcDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003","SA","");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getListOfUsers() {
		
		ResultSet resultats = null;
		String requete = "SELECT * FROM USERS";
		ArrayList<User> user = new ArrayList<User>();
		
		try{
			Statement stmt = con.createStatement();
			resultats = stmt.executeQuery(requete);
			while(resultats.next()){
				user.add(new User(resultats.getString(1), resultats.getString(2), resultats.getBoolean(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserById(String id) {
		ResultSet resultats = null;
		User user = null;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS WHERE ID = ?");
			ps.setString(1, id);
			resultats = ps.executeQuery();
			System.out.println(ps.getParameterMetaData());
			while(resultats.next()) {
				user = new User(resultats.getString(1), resultats.getString(2), resultats.getBoolean(3));
			}		
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}		
		return user;
	}

	@Override
	public User addUser(User user) {
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO USERS (ID, PASSWORD, ISADMINISTRATOR) VALUES (?,?,?);");
			ps.setString(1, user.getId());
			ps.setString(2, user.getPassword());
			ps.setBoolean(3, user.getAdministrator());
			System.out.println(user.getId() + " " + user.getPassword() + " " + user.getAdministrator());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void updateUser(User user) {
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE USERS SET password, administrator WHERE id = ?;");
			ps.setString(1, user.getId());
			ps.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User user) {
		try {
			PreparedStatement ps = con.prepareStatement("DELETE user WHERE id = ?");
			ps.setString(1, user.getId());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public User getUser (User user){
		ResultSet resultat = null;
		User newUser = null;
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?" );
			ps.setString(1, user.getId());
			ps.setString(2, user.getPassword());
			resultat = ps.executeQuery();
			while(resultat.next()){
				newUser = new User(resultat.getString(1), resultat.getString(2), resultat.getBoolean(3));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newUser;
	}
}
