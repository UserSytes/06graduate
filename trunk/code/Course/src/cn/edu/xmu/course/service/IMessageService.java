package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Message;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.pojo.UserInfo;

public interface IMessageService {
	public List getAllMessages(Topic topic,int pageSize, int pageNow);
	public Message getMessageById(Integer id);
	/**
	 * 添加新的主题和留言
	 * @param topic
	 * @param message
	 * @param userinfo
	 * @return
	 */
	public boolean addMessage(Course course,Topic topic,Message message,UserInfo userinfo);
	
	/**
	 * 添加新的回复
	 * @param topic
	 * @param message
	 * @param userinfo
	 * @return
	 */
	public boolean addReplyMessage(Topic topic,Message message,UserInfo userinfo);
	public boolean updateMessage(Message Message);
	public boolean deleteMessage(Message Message);
	
	public List getMessageByTopic(Topic topic);
	public List getMessageByUserInfo(UserInfo userInfo);
}
