package cn.edu.xmu.course.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.Action;

import cn.edu.xmu.course.commons.MessageInfo;
import cn.edu.xmu.course.commons.PageBean;
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
	private int pageNow = 1;
	private int pageSize = 5;
	private int pageCount = 0;
	private Student student;
	private Teacher teacher;
	private int flag;
	private String userName, password;
	private int time = 0;
	private String keyword="";
	private String authorName="";
	private Date keydate;
	//调试的分页如下 
    private int page;    //第几页
    private PageBean pageBean;    //包含分布信息的bean
    
	public String loginFromMessageBoard() {

		if (getFlag() == 0) {
			Teacher teacher = getLoginService().teacherLogin(userName,
					getPassword());
			System.out.println(userName);
			if (null == teacher) {
				addActionError("用户名获密码错误！请返回重试！");
				return ERROR;
			} else {
				userInfo = teacher.getUserInfo();
				System.out.println("正在登陆的是" + teacher.getTeacherNo());
				addActionMessage("亲爱的" + getUserInfo().getName() + "，欢迎你！");
				System.out.println(teacher.getPassword());
				super.getSession().put(TEACHER, teacher);
				super.getSession().put(USERINFO, teacher.getUserInfo());
				return "teacher";
			}
		} else {
			Student student = getLoginService().studentLogin(userName,
					getPassword());
			System.out.println(userName);
			if (null == student) {
				addActionError("用户名获密码错误！请返回重试！");
				return ERROR;
			} else {
				userInfo = student.getUserInfo();
				System.out.println("正在登陆的是" + student.getStudentNo());
				addActionMessage("亲爱的" + getUserInfo().getName() + "，欢迎你！");
				System.out.println("test1: " + student.getPassword());
				super.getSession().put(STUDENT, student);
				super.getSession().put(USERINFO, student.getUserInfo());
				return "student";
			}
		}
	}

	public String logoutFromMessageBoard() {
		student = (Student) super.getSession().get(STUDENT);
		teacher = (Teacher) super.getSession().get(TEACHER);
		if (null != student) {
			System.out.println("正在登出的是" + student.getStudentNo());
			super.getSession().remove(STUDENT);
			return SUCCESS;
		} else if (null != teacher) {
			System.out.println("正在登出的是" + teacher.getTeacherNo());
			super.getSession().remove(TEACHER);
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
		// userInfo=(UserInfo) super.getSession().get(USERINFO);
		// System.out.println("******"+userInfo.getName()+"********");
		// topic.setAuthorName(userInfo.getName());
		// topicService.addTopic(super.getCourse(), topic);
		// message.setGrade(1);
		// message.setUserInfo(userInfo);
		boolean result = messageService.addMessage(super.getCourse(), topic,
				message, super.getUserInfo());
		if (result) {
			addActionMessage("添加帖子成功！");
			return SUCCESS;
		} else {
			addActionError("添加帖子失败！");
			return ERROR;
		}
	}

	public String goReply() {
		topic = topicService.getTopicById(topicId);
		System.out.println("进入ID为：" + topic.getId() + "的回复页面");
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
		if (null == student && null == teacher) {
			addActionError("您还未登录，请先登录！");
			return "login";
		} else {

				userInfo = super.getUserInfo();
			course = super.getCourse();
			this.pageBean = getTopicService().queryForPage(pageSize, page);
			if (getPageBean().getAllRow() > 0) {
				return "topics";
			} else {
				System.out.println("本课程尚未有留言！");
				addActionError("本课程尚未有留言！");
				return ERROR;
			}
		}

	}
	public String showMessages() {
		userInfo=super.getUserInfo();
		topic = topicService.getTopicById(topicId);
		messageList = messageService.getAllMessages(topic, pageSize, pageNow);
		System.out.println("查找到：" + messageList.size()+"个留言");
		pageCount = (messageList.size() + getPageSize() - 1) / getPageSize();
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
			addActionMessage("添加帖子成功！");
			return SUCCESS;
		} else {
			addActionError("添加帖子失败！");
			return ERROR;
		}
	}

	public String searchTopicByKey() {
		System.out.println("keyword=" + keyword);
		System.out.println("authorName=" + authorName);
		System.out.println("keydate=" + keydate);
		Course course = super.getCourse();
		if (keydate == null) {
			if (authorName.equals("")) {// 按主题名称搜索
				System.out.println("按主题名称搜索:" + keyword);
				topicList = topicService.searchTopicByName(course, keyword);
			} else {
				if (keyword.equals("")) {
					// 按作者名称搜索
					System.out.println("按作者名称搜索:" + getAuthorName());
					topicList = topicService.searchTopicByAuthorName(course,
							getAuthorName());
				} else {
					// 按主题名称和作者名称搜索
					System.out.println("按主题名称和作者名称搜索:" + keyword + "  "
							+ getAuthorName());
					topicList = topicService.searchtopicByNameAndAuthorName(
							course, keyword, getAuthorName());
				}
			}
		} else {
			if (authorName.equals("")) {
				if (keyword.equals("")) { // 按时间搜索
					System.out.println("按时间搜索:" + keydate);
					topicList = topicService.searchTopicByTime(course, keydate);
				} else { // 按关键字和时间搜索
					System.out.println("按关键字和时间搜索:" + keyword + "" + keydate);
					topicList = topicService.searchTopicByNameAndTime(course,
							keyword, keydate);
				}
			} else {
				if (keyword.equals("")) { // 按作者名和时间搜索
					System.out.println("按作者名和时间搜索:" + getAuthorName() + "   "
							+ keydate);
					topicList = topicService.searchTopicByAuthorNameAndTime(
							course, getAuthorName(), keydate);
				} else { // 按主题名称、作者名和时间搜索
					System.out.println("按主题名称、作者名和时间搜索:" + keyword + "   "
							+ getAuthorName() + "  " + keydate);
					topicList = topicService
							.searchTopicByNameAndAuthorNameAndTime(course,
									keyword, getAuthorName(), keydate);
				}
			}
		}
		addActionMessage("共为您搜索到"+topicList.size()+"个符合条件的主题");
		System.out.println(topicList.size());
		return SUCCESS;
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

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<MessageInfo> getShowMessageList() {
		return showMessageList;
	}

	public void setShowMessageList(List<MessageInfo> showMessageList) {
		this.showMessageList = showMessageList;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageCount() {
		return pageCount;
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

	public void setPage(int page) {
		this.page = page;
	}

	public int getPage() {
		return page;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public PageBean getPageBean() {
		return pageBean;
	}
}
