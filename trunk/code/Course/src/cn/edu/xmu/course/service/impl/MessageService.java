package cn.edu.xmu.course.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import cn.edu.xmu.course.commons.CompareTime;
import cn.edu.xmu.course.commons.MessageInfo;
import cn.edu.xmu.course.dao.MessageDAO;
import cn.edu.xmu.course.dao.TopicDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Message;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IMessageService;

public class MessageService implements IMessageService {
	private MessageDAO messageDAO;
	private TopicDAO topicDAO;

	public boolean addMessage(Course course, Topic topic, Message message,
			UserInfo userInfo) {
		System.out.println("正在加入帖子为：" + topic.getId() + "的留言");
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
		topic.setCountPerson(topic.getCountPerson()+1);
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

	public boolean deleteMessage(Message message) {
		try {
			messageDAO.delete(message);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List getAllMessages(Topic topic, int pageSize, int pageNow) {
		List list = messageDAO.queryByPage(topic, pageSize, pageNow);
		if (list.size() > 0) {
			return list;
		} else
			return null;
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

	public List getMessageByTopic(Topic topic) {
		return messageDAO.findByTopicByOrder(topic);
	}

	/**
	 * 根据用户查找主题（grade为1的message）
	 * 
	 * @param userInfo
	 * @return
	 */
	public List getMessageByUserInfo(UserInfo userInfo) {
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
