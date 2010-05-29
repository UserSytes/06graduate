package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Message;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.pojo.UserInfo;
/**
 * �������԰������ԵĽӿ�
 * @author ������
 * @author ������
 *
 */
public interface IMessageService {
	
	/**
	 * ����ID��������
	 * @param id
	 * @return
	 */
	public Message getMessageById(Integer id);
	/**
	 * ����µ����������
	 * @param topic
	 * @param message
	 * @param userinfo
	 * @return
	 */
	public boolean addMessage(Course course,Topic topic,Message message,UserInfo userinfo);
	
	/**
	 * ����µĻظ�
	 * @param topic
	 * @param message
	 * @param userinfo
	 * @return
	 */
	public boolean addReplyMessage(Topic topic,Message message,UserInfo userinfo);

	/**
	 * ��������
	 * @param Message
	 * @return
	 */
	public boolean updateMessage(Message Message);
	
	/**
	 * ɾ������
	 * @param Message
	 * @return
	 */
	public boolean deleteMessage(Message Message);
	
	/**
	 * ��������������Ը���
	 * @param topic
	 * @return
	 */
	public List<Message> getMessageByTopic(Topic topic);
	
	/**
	 * �����ҵ������б�
	 * @param userInfo
	 * @return
	 */
	public List<Message> getMessageByUserInfo(UserInfo userInfo);

}
