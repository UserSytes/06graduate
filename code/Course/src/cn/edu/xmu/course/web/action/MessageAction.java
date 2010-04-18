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
	private int pageSize = 10;
	private int pageCount = 0;
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
	//���Եķ�ҳ���� 
    private int page;    //�ڼ�ҳ
    private PageBean pageBean;    //�����ֲ���Ϣ��bean
	public String loginFromMessageBoard() {

		if (getFlag() == 0) {
			Teacher teacher = getLoginService().teacherLogin(userName,
					getPassword());
			System.out.println(userName);
			if (null == teacher) {
				addActionError("�û�������������뷵�����ԣ�");
				return ERROR;
			} else {
				userInfo = teacher.getUserInfo();
				System.out.println("���ڵ�½����" + teacher.getTeacherNo());
				addActionMessage("�װ���" + getUserInfo().getName() + "����ӭ�㣡");
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
				addActionError("�û�������������뷵�����ԣ�");
				return ERROR;
			} else {
				userInfo = student.getUserInfo();
				System.out.println("���ڵ�½����" + student.getStudentNo());
				addActionMessage("�װ���" + getUserInfo().getName() + "����ӭ�㣡");
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
			System.out.println("���ڵǳ�����" + student.getStudentNo());
			super.getSession().remove(STUDENT);
			return SUCCESS;
		} else if (null != teacher) {
			System.out.println("���ڵǳ�����" + teacher.getTeacherNo());
			super.getSession().remove(TEACHER);
			return SUCCESS;
		} else
			return ERROR;

	}

	public String enterPersionalSpace() {
		student = (Student) super.getSession().get(STUDENT);
		teacher = (Teacher) super.getSession().get(TEACHER);
		if (null != student) {
			System.out.println("���ڽ���ռ����" + student.getStudentNo());
			return "student";
		} else if (null != teacher) {
			System.out.println("���ڽ���ռ����" + teacher.getTeacherNo());
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
		course=super.getCourse();
		boolean result = messageService.addMessage(super.getCourse(), topic,
				message, super.getUserInfo());
		if (result) {
			addActionMessage("������ӳɹ���");
			return SUCCESS;
		} else {
			addActionError("�������ʧ�ܣ�");
			return ERROR;
		}
	}

	public String goReply() {
		course=super.getCourse();
		topic = topicService.getTopicById(topicId);
		userInfo = (UserInfo) super.getSession().get(USERINFO);
		if (getTopic() == null) {
			addActionError("�����Ѿ������ڣ�");
			return ERROR;
		} else {
			return SUCCESS;
		}

	}
	public String goReplyToSomeone() {
		course=super.getCourse();
		topic = topicService.getTopicById(topicId);
		System.out.println(getReplyString());
		setReplyString(""+"<b>�ظ� ��"+getReplyGrade()+"¥<i> "+getReplyString()+"</i> �����ӣ�</b><br />------------------------------");
		System.out.println(getReplyString());
		userInfo = (UserInfo) super.getSession().get(USERINFO);
		if (getTopic() == null) {
			addActionError("�����Ѿ������ڣ�");
			return ERROR;
		} else {
			return SUCCESS;
		}

	}
	public String goReplyWithQuote() {
		course=super.getCourse();
		System.out.println(getReplyString());
		topic = topicService.getTopicById(topicId);
		setReplyString("<quote:msgheader>"+"QUOTE:ԭ���ɵ�"+getReplyGrade()+"¥<i> "+getReplyString()+"</i> �����ӣ�</quote:msgheader><br /><br />"+"<quote:msgborder>"+getReplyContent()+"</quote:msgborder>");
		System.out.println(getReplyString());
		userInfo = (UserInfo) super.getSession().get(USERINFO);
		if (getTopic() == null) {
			addActionError("�����Ѿ������ڣ�");
			return ERROR;
		} else {
			return SUCCESS;
		}

	}
	/**
	 * ��ʾ�γ���������
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String showTopics() {
		student = (Student) super.getSession().get(STUDENT);
		teacher = (Teacher) super.getSession().get(TEACHER);
		course = super.getCourse();
		if (null == student && null == teacher) {		
			addActionError("����δ��¼�����ȵ�¼��");
			return "login";
		} else {

				userInfo = super.getUserInfo();
			this.pageBean = getTopicService().queryForPage(course,pageSize, page);
			if (getPageBean().getAllRow() > 0) {
				return "topics";
			} else {
				System.out.println("���γ���δ�����ԣ�");
				addActionError("���γ���δ�����ԣ�");
				return ERROR;
			}
		}

	}
	public String showMessages() {
		course = super.getCourse();
		userInfo=super.getUserInfo();
		topic = topicService.getTopicById(topicId);
		messageList = messageService.getAllMessages(topic, pageSize, pageNow);
		System.out.println("���ҵ���" + messageList.size()+"������");
		pageCount = (messageList.size() + getPageSize() - 1) / getPageSize();
		topic.setCountPerson(topic.getCountPerson() + 1);
		topicService.updateTopic(topic);
		if (getMessageList().size() > 0) {
			return "messages";
		} else {
			System.out.println("�鿴���Գ���");
			addActionError("�鿴���Գ���");
			return ERROR;
		}
	}
	public String showMessages2() {
		course = super.getCourse();
		userInfo=super.getUserInfo();
		topic = topicService.getTopicById(topicId);
		this.pageBean = getMessageService().queryForPage(topic, pageSize, page);
		System.out.println("getAllRow:"+getPageBean().getAllRow());
		topic.setCountPerson(topic.getCountPerson() + 1);
		topicService.updateTopic(topic);
		if (getPageBean().getAllRow() > 0) {
			return "messages";
		} else {
			System.out.println("�鿴���Գ���");
			addActionError("�鿴���Գ���");
			return ERROR;
		}
	}
	public String goNewTopic(){
		userInfo=super.getUserInfo();
		return SUCCESS;
	}
	public String addReply() {
		// System.out.println("ACTION���ڼ�������Ϊ��"+topicId+"������1");
		// topic = topicService.getTopicById(topicId);
		course=super.getCourse();
		System.out.println("ACTION���ڼ�������Ϊ��" + topic.getId() + "������2");
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
			addActionMessage("������ӳɹ���");
			return SUCCESS;
		} else {
			addActionError("�������ʧ�ܣ�");
			return ERROR;
		}
	}
	public String goQuickSearchTopic(){
		course = super.getCourse();
		System.out.println("keyword=" + keyword);
		if(searchFlag==0)
		{
			this.pageBean = topicService.searchTopicByName(course, keyword,pageSize, page);
		}
		else
			this.pageBean = topicService.searchTopicByAuthorName(course,
					keyword,pageSize, page);
		return SUCCESS;
			
	}
	public String searchTopicByKey() {
		System.out.println("keyword=" + keyword);
		System.out.println("authorName=" + authorName);
		System.out.println("keydate=" + keydate);
		course = super.getCourse();
		if (keydate == null) {
			if (authorName.equals("")) {// ��������������
				System.out.println("��������������:" + keyword);
				this.pageBean = topicService.searchTopicByName(course, keyword,pageSize, page);
			} else {
				if (keyword.equals("")) {
					// ��������������
					System.out.println("��������������:" + getAuthorName());
					this.pageBean = topicService.searchTopicByAuthorName(course,
							getAuthorName(),pageSize, page);
				} else {
					// ���������ƺ�������������
					System.out.println("���������ƺ�������������:" + keyword + "  "
							+ getAuthorName());
					this.pageBean = topicService.searchtopicByNameAndAuthorName(
							course, keyword, getAuthorName(),pageSize, page);
				}
			}
		} else {
			if (authorName.equals("")) {
				if (keyword.equals("")) { // ��ʱ������
					System.out.println("��ʱ������:" + keydate);
					this.pageBean = topicService.searchTopicByTime(course, keydate,pageSize, page);
				} else { // ���ؼ��ֺ�ʱ������
					System.out.println("���ؼ��ֺ�ʱ������:" + keyword + "" + keydate);
					this.pageBean  = topicService.searchTopicByNameAndTime(course,
							keyword, keydate,pageSize, page);
				}
			} else {
				if (keyword.equals("")) { // ����������ʱ������
					System.out.println("����������ʱ������:" + getAuthorName() + "   "
							+ keydate);
					this.pageBean  = topicService.searchTopicByAuthorNameAndTime(
							course, getAuthorName(), keydate,pageSize, page);
				} else { // ���������ơ���������ʱ������
					System.out.println("���������ơ���������ʱ������:" + keyword + "   "
							+ getAuthorName() + "  " + keydate);
					this.pageBean  = topicService
							.searchTopicByNameAndAuthorNameAndTime(course,
									keyword, getAuthorName(), keydate,pageSize, page);
				}
			}
		}
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
