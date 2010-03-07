package cn.edu.xmu.course.web.action;

import java.util.ArrayList;
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
	private int pageNow = 1;
	private int pageSize = 5;
	private int pageCount = 0;
	private Student student;
	private Teacher teacher;
	private int flag;
	private String userName, password;

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
				System.out.println("���ڵ�½����"+teacher.getTeacherNo());
				addActionMessage("�װ���" + getUserInfo().getName() + "����ӭ�㣡");
				System.out.println(teacher.getPassword());
				ActionSession.getSession().put(TEACHER, teacher);
				ActionSession.getSession().put(USERINFO, teacher.getUserInfo());
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
				System.out.println("���ڵ�½����"+student.getStudentNo());
				addActionMessage("�װ���" + getUserInfo().getName() + "����ӭ�㣡");
				System.out.println("test1: " + student.getPassword());
				ActionSession.getSession().put(STUDENT, student);
				ActionSession.getSession().put(USERINFO, student.getUserInfo());
				return "student";
			}
		}
	}

	public String logoutFromMessageBoard() {
		student = (Student) ActionSession.getSession().get(STUDENT);
		teacher = (Teacher) ActionSession.getSession().get(TEACHER);
		if (null != student)
		{
			System.out.println("���ڵǳ�����"+student.getStudentNo());
			ActionSession.getSession().remove(STUDENT);
			return SUCCESS;
		}
		else if(null!=teacher)
		{
			System.out.println("���ڵǳ�����"+teacher.getTeacherNo());
			ActionSession.getSession().remove(TEACHER);
			return SUCCESS;
			}
		else
			return ERROR;
		
	}

	public String enterPersionalSpace() {
		student = (Student) ActionSession.getSession().get(STUDENT);
		teacher = (Teacher) ActionSession.getSession().get(TEACHER);
		if (null != student)
		{
			System.out.println("���ڽ���ռ����"+student.getStudentNo());
			return "student";
			}
		else if(null != teacher)
		{	
			System.out.println("���ڽ���ռ����"+teacher.getTeacherNo());
			return "teacher";
		
		}else
			return ERROR;

	}
	public String addNewMessage(){
		boolean result;
		userInfo=(UserInfo) ActionSession.getSession().get(USERINFO);
		System.out.println("******"+userInfo.getName()+"********");
		topic.setAuthorName(userInfo.getName());
		topicService.addTopic(super.getCourse(), topic);
		message.setGrade(1);
		message.setUserInfo(userInfo);
		result=messageService.addMessage(topic, message);
		if (result) {
			addActionMessage("������ӳɹ���");
			return SUCCESS;
		} else
		{
			addActionError("�������ʧ�ܣ�");
			return ERROR;
		}
		}
	public String goReply(){
		topic =topicService.getTopicById(topicId);
		System.out.println("����IDΪ��"+topic.getId()+"�Ļظ�ҳ��");
		userInfo=(UserInfo) ActionSession.getSession().get(USERINFO);
		if(getTopic()==null){
			addActionError("�����Ѿ������ڣ�");
			return ERROR;
		}
		else
		{
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
		student = (Student) ActionSession.getSession().get(STUDENT);
		teacher = (Teacher) ActionSession.getSession().get(TEACHER);
		if (null==student && null==teacher) {
			addActionError("����δ��¼�����ȵ�¼��");
			return "login";
		} else {
			if (teacher != null)
				userInfo = teacher.getUserInfo();
			else
				userInfo = student.getUserInfo();
			course = super.getCourse();
			topicList = getTopicService().getAllTopics(course);
			System.out.println("���ҵ�����" + topicList.size());
			if (getTopicList().size() > 0) {
				return "topics";
			} else {
				System.out.println("���γ���δ�����ԣ�");
				addActionError("���γ���δ�����ԣ�");
				return ERROR;
			}
		}

	}
	public String showMessages() {
	topic = topicService.getTopicById(topicId);
	messageList = messageService.getAllMessages(topic, pageSize,
			pageNow);
	System.out.println("���ҵ���" + messageList.size());
	pageCount = (messageList.size() + getPageSize() - 1)
			/ getPageSize();
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
	
	public String addReply(){
		boolean result;
//		System.out.println("ACTION���ڼ�������Ϊ��"+topicId+"������1");
//		topic = topicService.getTopicById(topicId);
		System.out.println("ACTION���ڼ�������Ϊ��"+topic.getId()+"������2");
		message.setGrade(topic.getCountReply()+2);
		result=messageService.addMessage(topic, message);
		if (result) {
			addActionMessage("������ӳɹ���");
			return SUCCESS;
		} else
		{
			addActionError("�������ʧ�ܣ�");
			return ERROR;
		}
	}
//	public String showMessages() {
//		topic = topicService.getTopicById(topicId);
//		messageInfoList = messageService.getAllMessages(topic, pageSize,
//				pageNow);
//		System.out.println("���ҵ���" + messageInfoList.size());
//		pageCount = (messageInfoList.size() + getPageSize() - 1)
//				/ getPageSize();
//		topic.setCountPerson(topic.getCountPerson() + 1);
//		topicService.updateTopic(topic);
//		if (getMessageInfoList().size() > 0) {
//			return "messages";
//		} else {
//			System.out.println("�鿴���Գ���");
//			addActionError("�鿴���Գ���");
//			return ERROR;
//		}
//		//		
//		// if
//		// ((this.messageInfoList=messageService.getAllMessages(topic)).size()
//		// != 0) {
//		//
//		// int length = this.messageInfoList.size();
//		// System.out.println("����������" + length);
//		// int start = (pageNow - 1) * pageSize;
//		// int end = start + pageSize;
//		// int flag = 0;
//		// System.out.println("length%pagesize="+length%pageSize);
//		// System.out.println("length/pagesize="+length/pageSize);
//		// if ((length % pageSize) > 0)
//		// flag = 1;
//		// else
//		// flag = 0;
//		// if (start == (length / pageSize + flag)) {
//		// end = length - 1;
//		// System.out.println("end:"+end);
//		// }
//		//			
//		// this.showMessageList.clear();
//		// System.out.println(start);
//		//
//		// if (start < 0) {
//		// JOptionPane.showMessageDialog(null, "û����Ϣ������ʾ��");
//		// for (int i = 0; i < pageSize; i++)
//		// this.showMessageList.add(this.messageInfoList.get(i));
//		// } else if (start >= length) {
//		// JOptionPane.showMessageDialog(null, "û����Ϣ������ʾ��");
//		// for (int i = length - pageSize; i < length; i++)
//		// this.showMessageList.add(this.messageInfoList.get(i));
//		// } else {
//		// for (int i = start; i < end; i++) {
//		// this.showMessageList.add(this.messageInfoList.get(i));
//		// }
//		// }
//		// if (showMessageList != null) {
//		// return "messages";
//		// } else {
//		// return ERROR;
//		// }
//		// } else{
//		// JOptionPane.showMessageDialog(null, "û����Ϣ������ʾ��");
//		// return ERROR;
//		// }
//	}

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
}
