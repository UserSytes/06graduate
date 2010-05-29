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

	/**
	 * 
	 */
	private static final long serialVersionUID = -3629833816313676853L;
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
		School school = super.getAdmin().getSchool();
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
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	

	/**
	 * 老师删除留言主题
	 * @return
	 */
	public String deleteTopicByTea(){
		topic = topicService.getTopicById(topicId);
		boolean result = topicService.deleteTopic(topic);
		if(result){
			return SUCCESS;
		}else{
			addActionError("删除留言板主题失败，请重新操作！");
			return ERROR;
		}
	}
	
	/**
	 * 获取某主题的所有留言
	 * @return
	 */
	@SuppressWarnings("unchecked")
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
			return SUCCESS;
		}else{
			addActionError("删除留言失败，请重新操作！");
			return ERROR;
		}
	}
	

	/**
	 * 教师删除留言
	 * @return
	 */
	public String deleteMessageByTea(){
		message = messageService.getMessageById(messageId);
		topic = message.getTopic();
		boolean result = messageService.deleteMessage(message);
		if(result){			
			return SUCCESS;
		}else{
			addActionError("删除留言失败，请重新操作！");
			return ERROR;
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
