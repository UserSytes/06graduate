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
	
	/**
	 * 根据ID查找留言
	 * @param id
	 * @return
	 */
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

	/**
	 * 更新留言
	 * @param Message
	 * @return
	 */
	public boolean updateMessage(Message Message);
	
	/**
	 * 删除留言
	 * @param Message
	 * @return
	 */
	public boolean deleteMessage(Message Message);
	
	/**
	 * 根据主题查找留言更表
	 * @param topic
	 * @return
	 */
	public List<Message> getMessageByTopic(Topic topic);
	
	/**
	 * 查找我的留言列表
	 * @param userInfo
	 * @return
	 */
	public List<Message> getMessageByUserInfo(UserInfo userInfo);

}
