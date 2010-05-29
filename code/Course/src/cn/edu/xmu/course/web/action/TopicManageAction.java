package cn.edu.xmu.course.web.action;

import java.util.List;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Message;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.service.IMessageService;
import cn.edu.xmu.course.service.ITopicService;

/**
 * ����ѧԺ����Ա����ѧԺ�γ����Ե���
 * @author ֣����
 *
 */
public class TopicManageAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3629833816313676853L;
	private ITopicService topicService;	//���������������Ľӿ�
	private IMessageService messageService;	//����������ԵĽӿ�
	
	private List<Topic> topicList;	//���������б�
	private List<Message> messageList;	//�����б�
	private Topic topic;	//��������
	private Message message;	//����
	private int topicId;	//��������id
	private int messageId;	//����id
	private String topicKey;	//����ؼ���
	
	/**
	 * ��ȡ��ѧԺ�γ�����
	 * @return
	 */
	public String getTopicBySchool(){
		School school = super.getAdmin().getSchool();
		topicList = topicService.getTopicByShcool(school);
		if(topicList.size()==0){
			addActionMessage("��ѧԺ�γ�Ŀǰ�������ԣ�");
			return ERROR;
		}else{
			return SUCCESS;
		}
	}
	
	/**
	 * ɾ����������
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
	 * ��ʦɾ����������
	 * @return
	 */
	public String deleteTopicByTea(){
		topic = topicService.getTopicById(topicId);
		boolean result = topicService.deleteTopic(topic);
		if(result){
			return SUCCESS;
		}else{
			addActionError("ɾ�����԰�����ʧ�ܣ������²�����");
			return ERROR;
		}
	}
	
	/**
	 * ��ȡĳ�������������
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getMessageByTopic(){
		topic = topicService.getTopicById(topicId);
		messageList = messageService.getMessageByTopic(topic);
		//System.out.println(messageList.get(0).getUserInfo().getName());
		if(messageList.size()==0){
			addActionMessage("������Ŀǰ���޻ظ���");
			return ERROR;
		}else{
			return SUCCESS;
		}
	}
	
	/**
	 * ɾ������
	 * @return
	 */
	public String deleteMessage(){
		message = messageService.getMessageById(messageId);
		topic = message.getTopic();
		boolean result = messageService.deleteMessage(message);
		if(result){			
			return SUCCESS;
		}else{
			addActionError("ɾ������ʧ�ܣ������²�����");
			return ERROR;
		}
	}
	

	/**
	 * ��ʦɾ������
	 * @return
	 */
	public String deleteMessageByTea(){
		message = messageService.getMessageById(messageId);
		topic = message.getTopic();
		boolean result = messageService.deleteMessage(message);
		if(result){			
			return SUCCESS;
		}else{
			addActionError("ɾ������ʧ�ܣ������²�����");
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
