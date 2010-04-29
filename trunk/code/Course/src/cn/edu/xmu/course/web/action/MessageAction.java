package cn.edu.xmu.course.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.Action;

import cn.edu.xmu.course.commons.MessageInfo;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Message;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.ILoginService;
import cn.edu.xmu.course.service.IMessageService;
import cn.edu.xmu.course.service.ITopicService;

public class MessageAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private Course course;
	private List<Topic> topicList;
	private List<Message> messageList;
	private List<MessageInfo> messageInfoList = new ArrayList<MessageInfo>();
	private List<MessageInfo> showMessageList = new ArrayList<MessageInfo>();
	private Topic topic;
	private Message message;
	private UserInfo userInfo;
	private Integer topicId;
	private ITopicService topicService;
	private IMessageService messageService;
	private ILoginService loginService;
	private Student student;
	private Teacher teacher;
	private int flag;
	private String userName, password;
	private int time = 0;
	private String keyword="";
	private String authorName="";
	private Date keydate;
	private int searchFlag;
	private String replyString="";
	private int replyGrade;
	private String replyContent="";
	public String loginFromMessageBoard() {
		if (getFlag() == 0) {
			Teacher teacher = getLoginService().teacherLogin(userName,
					getPassword());
			if (null == teacher) {
				addActionError("用户名获密码错误！请返回重试！");
				return ERROR;
			} else {
				userInfo = teacher.getUserInfo();				
				super.getSession().put(TEACHER, teacher);
				super.getSession().put(USERINFO, teacher.getUserInfo());				
			}
		} else {
			Student student = getLoginService().studentLogin(userName,
					getPassword());
			if (null == student) {
				addActionError("用户名获密码错误！请返回重试！");
				return ERROR;
			} else {
				userInfo = student.getUserInfo();			
				super.getSession().put(STUDENT, student);
				super.getSession().put(USERINFO, student.getUserInfo());				
			}
		}
		topicList = getTopicService().getAllTopics(super.getCourse());
		return SUCCESS;
	}

	public String logoutFromMessageBoard() {
		student = (Student) super.getSession().get(STUDENT);
		teacher = (Teacher) super.getSession().get(TEACHER);
		if (null != student) {
			System.out.println("正在登出的是" + student.getStudentNo());
			super.getSession().remove(STUDENT);
			super.getSession().remove(USERINFO);
			return SUCCESS;
		} else if (null != teacher) {
			System.out.println("正在登出的是" + teacher.getTeacherNo());
			super.getSession().remove(TEACHER);
			super.getSession().remove(USERINFO);
			return SUCCESS;
		} else
			return ERROR;

	}

	public String enterPersionalSpace() {
		student = (Student) super.getSession().get(STUDENT);
		teacher = (Teacher) super.getSession().get(TEACHER);
		if (null != student) {
			System.out.println("正在进入空间的是" + student.getStudentNo());
			return "student";
		} else if (null != teacher) {
			System.out.println("正在进入空间的是" + teacher.getTeacherNo());
			return "teacher";

		} else
			return ERROR;

	}

	public String addNewMessage() {		
		course=super.getCourse();
		boolean result = messageService.addMessage(super.getCourse(), topic,
				message, super.getUserInfo());
		if (result) {
			userInfo = super.getUserInfo();
			topicList = getTopicService().getAllTopics(course);
			message = null;
			return SUCCESS;
		} else {
			addActionError("添加帖子失败！");
			return ERROR;
		}
	}

	public String goReply() {
		course=super.getCourse();
		topic = topicService.getTopicById(topicId);
		userInfo = (UserInfo) super.getSession().get(USERINFO);
		if (getTopic() == null) {
			addActionError("该贴已经不存在！");
			return ERROR;
		} else {
			return SUCCESS;
		}

	}
	public String goReplyToSomeone() {
		course=super.getCourse();
		topic = topicService.getTopicById(topicId);
		System.out.println(getReplyString());
		setReplyString(""+"<b>回复 第"+getReplyGrade()+"楼<i> "+getReplyString()+"</i> 的帖子：</b><br />------------------------------");
		System.out.println(getReplyString());
		userInfo = (UserInfo) super.getSession().get(USERINFO);
		if (getTopic() == null) {
			addActionError("该贴已经不存在！");
			return ERROR;
		} else {
			return SUCCESS;
		}

	}
	public String goReplyWithQuote() {
		course=super.getCourse();
		System.out.println(getReplyString());
		topic = topicService.getTopicById(topicId);
		setReplyString("<quote:msgheader>"+"QUOTE:原帖由第"+getReplyGrade()+"楼<i> "+getReplyString()+"</i> 的帖子：</quote:msgheader><br /><br />"+"<quote:msgborder>"+getReplyContent()+"</quote:msgborder>");
		System.out.println(getReplyString());
		userInfo = (UserInfo) super.getSession().get(USERINFO);
		if (getTopic() == null) {
			addActionError("该贴已经不存在！");
			return ERROR;
		} else {
			return SUCCESS;
		}

	}
	/**
	 * 显示课程留言主题
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String showTopics() {
		student = (Student) super.getSession().get(STUDENT);
		teacher = (Teacher) super.getSession().get(TEACHER);
		course = super.getCourse();
		if (null == student && null == teacher) {		
			addActionError("您还未登录，请先登录！");
			return "login";
		} else {

				userInfo = super.getUserInfo();
				topicList = getTopicService().getAllTopics(course);
			if (topicList.size()> 0) {
				return "topics";
			} else {
				System.out.println("本课程尚未有留言！");
				addActionError("本课程尚未有留言！");
				return ERROR;
			}
		}

	}
	public String showMessages2() {
		course = super.getCourse();
		userInfo=super.getUserInfo();
		topic = topicService.getTopicById(topicId);
		messageList = messageService.getMessageByTopic(topic);
		System.out.println("查找到：" + messageList.size()+"个留言");
		topic.setCountPerson(topic.getCountPerson() + 1);
		topicService.updateTopic(topic);
		if (getMessageList().size() > 0) {
			return "messages";
		} else {
			System.out.println("查看留言出错！");
			addActionError("查看留言出错！");
			return ERROR;
		}
	}
	public String goNewTopic(){
		userInfo=super.getUserInfo();
		return SUCCESS;
	}
	public String addReply() {
		// System.out.println("ACTION正在加入帖子为："+topicId+"的留言1");
		// topic = topicService.getTopicById(topicId);
		course=super.getCourse();
		System.out.println("ACTION正在加入帖子为：" + topic.getId() + "的留言2");
		topic = topicService.getTopicById(topic.getId());
		// topic.setCountReply(topic.getCountReply()+1);
		// topic.setLastUpdate(new Date());
		// topic.setLastAnswer(super.getUserInfo().getName());
		// topicService.updateTopic(topic);
		// System.out.println(message.getContent());
		// message.setGrade(topic.getCountReply()+2);
		boolean result = messageService.addReplyMessage(topic, message, super
				.getUserInfo());
		if (result) {
			messageList = messageService.getMessageByTopic(topic);
			message = null;
			return SUCCESS;
		} else {
			addActionError("添加帖子失败！");
			return ERROR;
		}
	}
	public String showTopicsByTeacher() {
		topicList = getTopicService().getTopicsByTeacher(super.getTeacher(),
				getTime());
		super.getSession().put(USERINFO, super.getTeacher().getUserInfo());
		return SUCCESS;
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

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setMessageInfoList(List<MessageInfo> messageInfoList) {
		this.messageInfoList = messageInfoList;
	}

	public List<MessageInfo> getMessageInfoList() {
		return messageInfoList;
	}

	public List<MessageInfo> getShowMessageList() {
		return showMessageList;
	}

	public void setShowMessageList(List<MessageInfo> showMessageList) {
		this.showMessageList = showMessageList;
	}


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getFlag() {
		return flag;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getTime() {
		return time;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeydate(Date keydate) {
		this.keydate = keydate;
	}

	public Date getKeydate() {
		return keydate;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setSearchFlag(int searchFlag) {
		this.searchFlag = searchFlag;
	}

	public int getSearchFlag() {
		return searchFlag;
	}

	public void setReplyString(String replyString) {
		this.replyString = replyString;
	}

	public String getReplyString() {
		return replyString;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyGrade(int replyGrade) {
		this.replyGrade = replyGrade;
	}

	public int getReplyGrade() {
		return replyGrade;
	}

}
