package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Message;
import cn.edu.xmu.course.pojo.Topic;

public interface IMessageService {
	public List getAllMessages(Topic topic);
	public Message getMessageById(Integer id);
	public boolean addMessage(Topic topic,Message message);
	public boolean updateMessage(Message Message);
	public boolean deleteMessage(Message Message);
}