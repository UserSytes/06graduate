package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.MessageDAO;
import cn.edu.xmu.course.pojo.Message;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.service.IMessageService;

public class MessageService implements IMessageService {
	private MessageDAO messageDAO;
	
	public boolean addMessage(Topic topic, Message message) {
		message.setTopic(topic);
		try {
			messageDAO.save(message);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteMessage(Message message) {
		try {
			messageDAO.delete(message);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List getAllMessages(Topic topic) {
		return messageDAO.findByTopic(topic);
	}

	public Message getMessageById(Integer id) {
		
		return messageDAO.findById(id);
	}

	public boolean updateMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			messageDAO.merge(message);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	public MessageDAO getMessageDAO() {
		return messageDAO;
	}

}
