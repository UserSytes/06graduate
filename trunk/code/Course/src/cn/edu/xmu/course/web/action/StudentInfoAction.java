package cn.edu.xmu.course.web.action;

import java.util.ArrayList;
import java.util.List;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Collection;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Message;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.IMessageService;
import cn.edu.xmu.course.service.IStudentCourseService;
import cn.edu.xmu.course.service.IStudentInfoService;
import cn.edu.xmu.course.service.ITopicService;

/**
 * ѧ����ҳ
 * @author Sky
 *
 */
public class StudentInfoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6085308815177983503L;
	private IStudentInfoService studentInfoService;
	private IStudentCourseService studentCourseService;
	private ICourseService courseService;

	private Student student;
	private UserInfo userInfo;
	private List<Course> courseList;
	private Course course;
	private int courseId;
	private String oldPassword;
	private String newPassword;
	
	
	private ITopicService topicService;
	private IMessageService messageService;
	
	private List<Topic> topicList;
	private List<Message> messageList;
	
	private Topic topic;
	private int topicId;
	
	public String myTopics(){
		student = (Student) super.getSession().get(STUDENT);
		userInfo = student.getUserInfo();
		messageList = messageService.getMessageByUserInfo(userInfo);
		if(messageList.size()==0){
			addActionMessage("��Ŀǰ��δ�����������ԣ�");
			return ERROR;
		}else{
			return SUCCESS;
		}
	}
	
//	public String myReplyTopics(){
//		student = (Student) super.getSession().get(STUDENT);
//		userInfo = student.getUserInfo();
//		messageList = messageService.getReplyMessageByUserInfo(userInfo);
//		System.out.println("�ҵ����ӣ�"+messageList.get(0).getGrade());
//		System.out.println("�ҵ�����2��"+messageList.get(0).getTopic().getName());
//		if(messageList.size()==0){
//			addActionMessage("��Ŀǰ��δ���κ����Իظ���");
//			return ERROR;
//		}else{
//			return SUCCESS;
//		}
//	}
	
	/**
	 * ����ѧ��������Ϣ
	 * @return
	 */
	public String findStudentInfo(){
		student = null;
		student = (Student) super.getSession().get(STUDENT);
		student = studentInfoService.findById(student.getId());
		if(student == null){
			addActionError("����δ��¼�����ȵ�¼��");
			return ERROR;
		}else{
			userInfo = student.getUserInfo();
			return SUCCESS;
		}
	}
	
	/**
	 * �޸�ѧ����Ϣ
	 * @return
	 */
	public String changeStudentInfo(){
		boolean result = studentInfoService.updateStudent(student, userInfo);
		if(result){
			student = studentInfoService.findById(student.getId());
			userInfo = student.getUserInfo();
			return SUCCESS;
		}else
			return ERROR;
	}
	
	/**
	 * �޸�����
	 * @return
	 */
	public String changePassword(){
		student = (Student) super.getSession().get(STUDENT);
		if(student.getPassword().equals(oldPassword)){
			student.setPassword(newPassword);
			boolean result = studentInfoService.updatePassword(student);
			if(result){
				addActionMessage("�޸�����ɹ���");
				return SUCCESS;
			}
			else
				return ERROR;
		}
		else{
			addActionError("ԭ�������");
			return SUCCESS;
		}
	}
	/**
	 * �����ҵĿγ�
	 * @return
	 */
	public String findMyCourses(){
		student = (Student) super.getSession().get(STUDENT);
		List<StudentCourse> studentCourses = new ArrayList<StudentCourse>();
		studentCourses = studentCourseService.findByStudent(student);
		if(studentCourses.size()==0){
			addActionError("�����޿γ̣�");
			return ERROR;
		}
		courseList =  new ArrayList<Course>();
		for(StudentCourse sc: studentCourses){
			courseList.add(sc.getCourse());
		}
		return SUCCESS;
	}
	
	/**
	 * �����ҵ��ղؿγ�
	 * @return
	 */
	public String findMyCollection(){
		student = (Student) super.getSession().get(STUDENT);
		List<Collection> collections = new ArrayList<Collection>();
		collections = studentCourseService.findCollectionByStudent(student);
		if(collections.size()==0){
			addActionError("����δ�ղ��κογ̣�");
			return ERROR;
		}
		courseList =  new ArrayList<Course>();
		for(Collection c: collections){
			courseList.add(c.getCourse());
		}
		return SUCCESS;
	}
	
	/**
	 * ɾ���ղؿγ�
	 * @return
	 */
	public String deleteCollection(){
		student = (Student) super.getSession().get(STUDENT);
		course = courseService.getCourseById(courseId);
		boolean result = studentCourseService.deleteCollection(student, course);
		if(result){
			this.findMyCollection();
			return SUCCESS;
		}else
			return ERROR;
		
	}

	public IStudentInfoService getStudentInfoService() {
		return studentInfoService;
	}

	public void setStudentInfoService(IStudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
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

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
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

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}
