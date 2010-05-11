package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Message;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.ILoginService;
import cn.edu.xmu.course.service.IMessageService;
import cn.edu.xmu.course.service.IStudentCourseService;
import cn.edu.xmu.course.service.ITopicService;

/**
 * �������԰����
 * 
 * @author ������
 * @author ������
 * 
 */
public class MessageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Course course; // �γ�
	private List<Topic> topicList; // �����б�
	private List<Message> messageList; // �����б�
	private Topic topic; // ����
	private Message message; // ����
	private UserInfo userInfo; // �û���Ϣ
	private Integer topicId; // ����ID
	private Integer messageId; // ����id
	private ITopicService topicService; // ��������Ľӿ�
	private IMessageService messageService; // �������ԵĽӿ�
	private ILoginService loginService; // �����½�Ľӿ�
	private IStudentCourseService studentCourseService;
	private Student student; // ѧ��
	private Teacher teacher; // ��ʦ
	private int flag; // ��½����
	private String userName, password; // �û���������
	private int time = 0; // ����
	private String replyString = ""; // �ظ������ñ���

	/**
	 * �����԰��½
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String loginFromMessageBoard() {
		if (getFlag() == 0) {
			Teacher teacher = getLoginService().teacherLogin(userName,
					getPassword());
			if (null == teacher) {
				addActionError("�û�������������뷵�����ԣ�");
				return ERROR;
			} else {
				userInfo = teacher.getUserInfo();
				super.getSession().put(TEACHER, teacher);
				super.getSession().put(USERINFO, userInfo);
				super.getSession().put("user", userInfo.getName() + "��ʦ");
			}
		} else {
			Student student = getLoginService().studentLogin(userName,
					getPassword());
			if (null == student) {
				addActionError("�û�������������뷵�����ԣ�");
				return ERROR;
			} else {
				if (studentCourseService
						.findByStudentAndCourse(super.getCourse(), student).size() == 0) {
					addActionError("������¼���ʺŲ��Ǹÿγ̵�ѧ�����޷��������԰壡");
					return ERROR;
				}
				userInfo = student.getUserInfo();
				super.getSession().put(STUDENT, student);
				super.getSession().put(USERINFO, userInfo);
				super.getSession().put("user", userInfo.getName() + "ͬѧ");
			}
		}
		topicList = getTopicService().getAllTopics(super.getCourse());
		return SUCCESS;
	}

	/**
	 * ���������
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
			addActionError("�������ʧ�ܣ�");
			return ERROR;
		}
	}

	/**
	 * ��ת���ظ�ҳ��
	 * 
	 * @return
	 */
	public String goReply() {
		course = super.getCourse();
		topic = topicService.getTopicById(topicId);
		userInfo = (UserInfo) super.getSession().get(USERINFO);
		if (getTopic() == null) {
			addActionError("�����Ѿ������ڣ�");
			return ERROR;
		} else {
			return SUCCESS;
		}

	}

	/**
	 * ��ת���ظ���ĳ��ҳ��
	 * 
	 * @return
	 */
	public String goReplyToSomeone() {
		course = super.getCourse();
		topic = topicService.getTopicById(topicId);
		Message rMsg = messageService.getMessageById(getMessageId());
		setReplyString("" + "<b>�ظ� ��" + rMsg.getGrade() + "¥<i> "
				+ rMsg.getUserInfo().getName()
				+ "</i> �����ӣ�</b><br />--------------------------------------");
		userInfo = (UserInfo) super.getSession().get(USERINFO);
		if (getTopic() == null) {
			addActionError("�����Ѿ������ڣ�");
			return ERROR;
		} else {
			return SUCCESS;
		}

	}

	/**
	 * ���ûظ�����
	 * 
	 * @return
	 */
	public String goReplyWithQuote() {
		course = super.getCourse();
		topic = topicService.getTopicById(topicId);
		Message rMsg = messageService.getMessageById(getMessageId());
		setReplyString("<quote:msgheader>" + "QUOTE:ԭ���ɵ�" + rMsg.getGrade()
				+ "¥<i> " + rMsg.getUserInfo().getName()
				+ "</i> �����ӣ�</quote:msgheader><br /><br />" + rMsg.getContent()
				+ "</b><br />--------------------------------------");
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
		if (null == teacher) {
			if (null == student) {
				addActionError("����δ��¼�����ȵ�¼��");
				return "login";
			} else {
				if (studentCourseService
						.findByStudentAndCourse(course, student).size() == 0) {
					addActionError("������¼���ʺŲ��Ǹÿγ̵�ѧ�����޷��������԰壡");
					return ERROR;
				}
			}
		}
		userInfo = super.getUserInfo();
		topicList = getTopicService().getAllTopics(course);
		return "topics";
	}

	/**
	 * ����ѧ��������������
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String myTopics() {
		messageList = messageService.getMessageByUserInfo(super.getUserInfo());
		if (messageList.size() == 0) {
			addActionMessage("��Ŀǰ��δ�����������ԣ�");
		}
		return SUCCESS;

	}

	/**
	 * ��ʾ��������
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String showMessages() {
		course = super.getCourse();
		userInfo = super.getUserInfo();
		topic = topicService.getTopicById(topicId);
		messageList = messageService.getMessageByTopic(topic);
		System.out.println("���ҵ���" + messageList.size() + "������");
		topic.setCountPerson(topic.getCountPerson() + 1);
		topicService.updateTopic(topic);
		if (getMessageList().size() > 0) {
			return "messages";
		} else {
			addActionError("���������κ����ԣ�");
			return ERROR;
		}
	}

	/**
	 * ��ת��������ҳ��
	 * 
	 * @return
	 */
	public String goNewTopic() {
		userInfo = super.getUserInfo();
		return SUCCESS;
	}

	/**
	 * ���������
	 * 
	 * @return
	 */
	public String addReply() {
		course = super.getCourse();
		System.out.println("ACTION���ڼ�������Ϊ��" + topic.getId() + "������2");
		topicId = topic.getId();
		topic = topicService.getTopicById(topic.getId());
		boolean result = messageService.addReplyMessage(topic, message, super
				.getUserInfo());
		if (result) {
			message = null;
			return SUCCESS;
		} else {
			addActionError("�������ʧ�ܣ�");
			return ERROR;
		}
	}

	/**
	 * ���ݽ�ʦ�鿴����
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
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

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public IStudentCourseService getStudentCourseService() {
		return studentCourseService;
	}

	public void setStudentCourseService(IStudentCourseService studentCourseService) {
		this.studentCourseService = studentCourseService;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getReplyString() {
		return replyString;
	}

	public void setReplyString(String replyString) {
		this.replyString = replyString;
	}

	

}
