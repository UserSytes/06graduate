package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Message;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.service.IMessageService;
import cn.edu.xmu.course.service.ITopicService;

public class MessageAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	private Course course;
	private List<Topic> topicList;
	private List<Message> messageList;
	private Topic topic;
	private Integer topicId;
	private ITopicService topicService;
	private IMessageService messageService;
	/**
	 * 显示课程留言主题
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String showTopics(){
		course=super.getCourse();
		topicList=getTopicService().getAllTopics(course);
		System.out.println("共找到主题"+topicList.size());
		if(getTopicList().size()>0)
		{
			return "topics";
		}
		else
		{
			System.out.println("本课程尚未有留言！");
			addActionError("本课程尚未有留言！");
			return ERROR;
		}
			
	}
	public String showMessages(){
		topic=topicService.getTopicById(topicId);
		messageList=messageService.getAllMessages(topic);
		if(getMessageList().size()>0)
		{
			return "messages";
		}
		else
			{
			System.out.println("查看留言出错！");
			addActionError("查看留言出错！");
			return ERROR;
			}
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Course getCourse() {
		return course;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}

	public List<Topic> getTopicList() {
		return topicList;
	}

	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
	}

	public ITopicService getTopicService() {
		return topicService;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public Integer getTopicId() {
		return topicId;
	}
	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}
	public List<Message> getMessageList() {
		return messageList;
	}
	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}
	public IMessageService getMessageService() {
		return messageService;
	}

	}
