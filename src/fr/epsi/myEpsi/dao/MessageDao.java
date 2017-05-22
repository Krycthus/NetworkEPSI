package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.beans.Status;

public class MessageDao implements IMessageDao {

	@Override
	public List<Message> getListOfMessages(User user) {
		
		List<Message> messages = new ArrayList<>();
		ResultSet resultats = null;
		
		try{
			Connection con = DriverManager.getConnection("jdbc:hsql:hsql://localhost:9003");
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM MESSAGES WHERE USER_ID = ? ORDER BY UPDATE_DATE DESC");
			preparedStatement.setString(1, user.getId());
			resultats = preparedStatement.executeQuery();
			while(resultats.next()) {
				Message message = new Message(resultats.getLong(1), resultats.getString(2), resultats.getString(3), user, resultats.getTimestamp(5), resultats.getTimestamp(6), Status.values()[resultats.getInt(7)] );
				messages.add(message);
			}		
			preparedStatement.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return messages;
	}

	@Override
	public Message getMessage(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMessage(Message message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMessageStatus(Message message, int status) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub

	}

}
