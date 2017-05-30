package fr.epsi.myEpsi.service;

import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.dao.MessageDao;

public class MessageService implements IMessageService {

	private MessageDao messageDAO;
	
	public MessageService() {
		this.messageDAO = new MessageDao();
	}

	@Override
	public List<Message> getListOfMessages(User user) {
		List<Message> messages = messageDAO.getListOfMessages(user);
		return messages;
	}

	@Override
	public Message getMessage(Long id) {
		return messageDAO.getMessage(id);
	}

	@Override
	public void addMessage(Message message) {
		messageDAO.addMessage(message);
		
	}

	@Override
	public void updateMessageStatus(Message message, int status) {
		
	}

	@Override
	public void deleteMessage(Message message) {
		messageDAO.deleteMessage(message);
	}
	
	

}
