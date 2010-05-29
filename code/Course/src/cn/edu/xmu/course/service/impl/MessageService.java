package cn.edu.xmu.course.service.impl;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.dao.MessageDAO;
import cn.edu.xmu.course.dao.TopicDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Message;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IMessageService;

/**
 * 负责留言板中留言的接口
 * 
 * @author 许子彦
 * @author 何申密
 * 
 */
public class MessageService implements IMessageService {
	private MessageDAO messageDAO;
	private TopicDAO topicDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IMessageService#addMessage(cn.edu.xmu.course
	 * .pojo.Course, cn.edu.xmu.course.pojo.Topic,
	 * cn.edu.xmu.course.pojo.Message, cn.edu.xmu.course.pojo.UserInfo)
	 */
	public boolean addMessage(Course course, Topic topic, Message message,
			UserInfo userInfo) {
		topic.setCourse(course);
		topic.setTime(new Date());
		topic.setCountPerson(0);
		topic.setCountReply(0);
		topic.setLastAnswer("无");
		topic.setAuthorName(userInfo.getName());
		topic.setLastAnswer(userInfo.getName());
		topic.setLastUpdate(new Date());
		message.setGrade(1);
		message.setUserInfo(userInfo);
		message.setTopic(topic);
		message.setTime(new Date());
		try {
			topicDAO.save(topic);
			messageDAO.save(message);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IMessageService#addReplyMessage(cn.edu.xmu.
	 * course.pojo.Topic, cn.edu.xmu.course.pojo.Message,
	 * cn.edu.xmu.course.pojo.UserInfo)
	 */
	public boolean addReplyMessage(Topic topic, Message message,
			UserInfo userInfo) {
		// TODO Auto-generated method stub
		topic.setCountReply(topic.getCountReply() + 1);
		topic.setCountPerson(topic.getCountPerson() + 1);
		topic.setLastUpdate(new Date());
		topic.setLastAnswer(userInfo.getName());
		message.setGrade(topic.getCountReply() + 1);
		message.setUserInfo(userInfo);
		message.setTopic(topic);
		message.setTime(new Date());
		try {
			topicDAO.merge(topic);
			messageDAO.save(message);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IMessageService#deleteMessage(cn.edu.xmu.course
	 * .pojo.Message)
	 */
	public boolean deleteMessage(Message message) {
		try {
			messageDAO.delete(message);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IMessageService#getMessageById(java.lang.Integer
	 * )
	 */
	public Message getMessageById(Integer id) {

		return messageDAO.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IMessageService#updateMessage(cn.edu.xmu.course
	 * .pojo.Message)
	 */
	public boolean updateMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			messageDAO.merge(message);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IMessageService#getMessageByTopic(cn.edu.xmu
	 * .course.pojo.Topic)
	 */
	public List<Message> getMessageByTopic(Topic topic) {
		return messageDAO.findByTopicByOrder(topic);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IMessageService#getMessageByUserInfo(cn.edu
	 * .xmu.course.pojo.UserInfo)
	 */
	public List<Message> getMessageByUserInfo(UserInfo userInfo) {
		return messageDAO.findTopicByUserInfo(userInfo);
	}

	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	public MessageDAO getMessageDAO() {
		return messageDAO;
	}

	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}

	public TopicDAO getTopicDAO() {
		return topicDAO;
	}

}
