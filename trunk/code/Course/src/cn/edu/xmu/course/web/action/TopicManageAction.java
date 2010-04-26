package cn.edu.xmu.course.web.action;

import java.util.List;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Message;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.service.IMessageService;
import cn.edu.xmu.course.service.ITopicService;

/**
 * 负责学院管理员管理学院课程留言的类
 * @author 郑冰凌
 *
 */
public class TopicManageAction extends BaseAction{

	private ITopicService topicService;	//负责管理留言主题的接口
	private IMessageService messageService;	//负责管理留言的接口
	
	private List<Topic> topicList;	//留言主题列表
	private List<Message> messageList;	//留言列表
	private Topic topic;	//留言主题
	private Message message;	//留言
	private int topicId;	//留言主题id
	private int messageId;	//留言id
	private String topicKey;	//主题关键字
	
	/**
	 * 获取本学院课程留言
	 * @return
	 */
	public String getTopicBySchool(){
		Administrator admin = (Administrator) super.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		topicList = topicService.getTopicByShcool(school);
		if(topicList.size()==0){
			addActionMessage("本学院课程目前还无留言！");
			return ERROR;
		}else{
			return SUCCESS;
		}
	}
	
	/**
	 * 删除留言主题
	 * @return
	 */
	public String deleteTopic(){
		topic = topicService.getTopicById(topicId);
		boolean result = topicService.deleteTopic(topic);
		if(result){
			this.getTopicBySchool();
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	/**
	 * 获取某主题的所有留言
	 * @return
	 */
	public String getMessageByTopic(){
		topic = topicService.getTopicById(topicId);
		messageList = messageService.getMessageByTopic(topic);
		//System.out.println(messageList.get(0).getUserInfo().getName());
		if(messageList.size()==0){
			addActionMessage("本主题目前还无回复！");
			return ERROR;
		}else{
			return SUCCESS;
		}
	}
	
	/**
	 * 删除留言
	 * @return
	 */
	public String deleteMessage(){
		message = messageService.getMessageById(messageId);
		topic = message.getTopic();
		boolean result = messageService.deleteMessage(message);
		if(result){
			messageList = messageService.getMessageByTopic(topic);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	/**
	 * 根据主题关键字和学院查找主题
	 * @return
	 */
	public String searchTopic(){
		Administrator admin = (Administrator) super.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		topicList = topicService.searchTopicByKey(topicKey, school);
		if(topicList.size()==0){
			addActionMessage("没有找到相关留言！");
			return ERROR;
		}else{
			return SUCCESS;
		}
	}

	public ITopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
	}

	public IMessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}

	public List<Topic> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getTopicKey() {
		return topicKey;
	}

	public void setTopicKey(String topicKey) {
		this.topicKey = topicKey;
	}
	
}
