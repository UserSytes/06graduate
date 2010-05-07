package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Message;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.pojo.UserInfo;
/**
 * 负责留言板中留言的接口
 * @author 许子彦
 * @author 何申密
 *
 */
public interface IMessageService {
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
