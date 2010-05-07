package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Message;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.ILoginService;
import cn.edu.xmu.course.service.IMessageService;
import cn.edu.xmu.course.service.ITopicService;
/**
 * 负责留言板的类
 * @author 何申密
 * @author 许子彦
 *
 */
public class MessageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Course course; // 课程
	private List<Topic> topicList; // 主题列表
	private List<Message> messageList; // 留言列表
	private Topic topic; // 主题
	private Message message; // 留言
	private UserInfo userInfo; // 用户信息
	private Integer topicId; // 主题ID
	private ITopicService topicService; // 负责主题的接口
	private IMessageService messageService; // 负责留言的接口
	private ILoginService loginService; // 负责登陆的接口
	private Student student; // 学生
	private Teacher teacher; // 老师
	private int flag; // 登陆类型
	private String userName, password; // 用户名、密码
	private int time = 0; // 次数
	private String replyString = ""; // 回复、引用标题
	private int replyGrade; // 回复楼层
	private String replyContent = ""; // 回复、引用内容

	/**
	 * 从留言板登陆
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
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
				super.getSession().put(USERINFO, userInfo);
				super.getSession().put("user", userInfo.getName() + "老师");
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
				super.getSession().put(USERINFO, userInfo);
				super.getSession().put("user", userInfo.getName() + "同学");
			}
		}
		topicList = getTopicService().getAllTopics(super.getCourse());
		return SUCCESS;
	}

	/**
	 * 添加新留言
	 * 
	 * @return
	 */
	public String addNewMessage() {
		course = super.getCourse();
		boolean result = messageService.addMessage(super.getCourse(), topic,
				message, super.getUserInfo());
		if (result) {
			userInfo = super.getUserInfo();
			message = null;
			return SUCCESS;
		} else {
			addActionError("添加帖子失败！");
			return ERROR;
		}
	}

	/**
	 * 跳转到回复页面
	 * 
	 * @return
	 */
	public String goReply() {
		course = super.getCourse();
		topic = topicService.getTopicById(topicId);
		userInfo = (UserInfo) super.getSession().get(USERINFO);
		if (getTopic() == null) {
			addActionError("该贴已经不存在！");
			return ERROR;
		} else {
			return SUCCESS;
		}

	}

	/**
	 * 跳转到回复给某人页面
	 * 
	 * @return
	 */
	public String goReplyToSomeone() {
		course = super.getCourse();
		topic = topicService.getTopicById(topicId);
		System.out.println(getReplyString());
		setReplyString("" + "<b>回复 第" + getReplyGrade() + "楼<i> "
				+ getReplyString()
				+ "</i> 的帖子：</b><br />------------------------------");
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
	 * 跳转到引用某人页面
	 * 
	 * @return
	 */
	public String goReplyWithQuote() {
		course = super.getCourse();
		System.out.println(getReplyString());
		topic = topicService.getTopicById(topicId);
		setReplyString("<quote:msgheader>" + "QUOTE:原帖由第" + getReplyGrade()
				+ "楼<i> " + getReplyString()
				+ "</i> 的帖子：</quote:msgheader><br /><br />"
				+ "<quote:msgborder>" + getReplyContent()
				+ "</quote:msgborder>");
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
			if (topicList.size() > 0) {
				return "topics";
			} else {
				System.out.println("本课程尚未有留言！");
				addActionError("本课程尚未有留言！");
				return ERROR;
			}
		}
	}

	/**
	 * 查找学生个人留言主题
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String myTopics() {
		messageList = messageService.getMessageByUserInfo(super.getUserInfo());
		if (messageList.size() == 0) {
			addActionMessage("您目前还未发表帖子留言！");
		}
		return SUCCESS;

	}

	/**
	 * 显示所有留言
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String showMessages() {
		course = super.getCourse();
		userInfo = super.getUserInfo();
		topic = topicService.getTopicById(topicId);
		messageList = messageService.getMessageByTopic(topic);
		System.out.println("查找到：" + messageList.size() + "个留言");
		topic.setCountPerson(topic.getCountPerson() + 1);
		topicService.updateTopic(topic);
		if (getMessageList().size() > 0) {
			return "messages";
		} else {
			addActionError("该贴已无任何留言！");
			return ERROR;
		}
	}

	/**
	 * 跳转到新主题页面
	 * 
	 * @return
	 */
	public String goNewTopic() {
		userInfo = super.getUserInfo();
		return SUCCESS;
	}

	/**
	 * 添加新主题
	 * 
	 * @return
	 */
	public String addReply() {
		course = super.getCourse();
		System.out.println("ACTION正在加入帖子为：" + topic.getId() + "的留言2");
		topicId = topic.getId();
		topic = topicService.getTopicById(topic.getId());
		boolean result = messageService.addReplyMessage(topic, message, super
				.getUserInfo());
		if (result) {
			message = null;
			return SUCCESS;
		} else {
			addActionError("添加帖子失败！");
			return ERROR;
		}
	}

	/**
	 * 根据教师查看主题
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
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
