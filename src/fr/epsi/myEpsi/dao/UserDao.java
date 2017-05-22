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

	@Override
	public List<User> getListOfUsers() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con;
		
		ResultSet resultats = null;
		String requete = "SELECT * FROM USERS";
		ArrayList<User> user = new ArrayList<User>();
		
		try{
			con = DriverManager.getConnection("jdbc:hsql:hsql://localhost:9003");
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
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con;
		ResultSet resultats = null;
		
		try {
			con = DriverManager.getConnection("jdbc:hsql:hsql://localhost:9003");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id = ?");
			ps.setString(1, id);
			resultats = ps.executeQuery();
			System.out.println(ps.getParameterMetaData());
			while(resultats.next()) {
				return new User(resultats.getString(1), resultats.getString(2), resultats.getBoolean(3));
			}		
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public void addUser(User user) {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		
		Connection con;
		
		try {
			con = DriverManager.getConnection("jdbc:hsql:hsql://localhost:9003");
			PreparedStatement ps = con.prepareStatement("INSERT INTO user VALUES ?,?,?");
			ps.setString(1, user.getId());
			ps.setString(2, user.getPassword());
			ps.setBoolean(3, user.getAdministrator());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(User user) {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con;
		
		try {
			con = DriverManager.getConnection("jdbc:hsql:hsql://localhost:9003");
			PreparedStatement ps = con.prepareStatement("UPDATE user SET password, administrator WHERE id = ?");
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
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con;
		
		try {
			con = DriverManager.getConnection("jdbc:hsql:hsql://localhost:9003");
			PreparedStatement ps = con.prepareStatement("DELETE user WHERE id = ?");
			ps.setString(1, user.getId());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
