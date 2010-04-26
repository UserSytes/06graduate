package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

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
 * �������ѧ����ҳ����
 * @author ֣����
 * 
 */
public class StudentInfoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6085308815177983503L;
	private IStudentInfoService studentInfoService;	//����ѧ����Ϣ�Ľӿ�
	private IStudentCourseService studentCourseService;	//����ѧ���γ���Ϣ�Ľӿ�
	private ICourseService courseService;	//����γ���Ϣ�Ľӿ�

	private Student student;	//ѧ��
	private UserInfo userInfo;	//�û���Ϣ
	private List<Course> courseList;	//�γ��б�
	private Course course;	//�γ�
	private int courseId;	//�γ�id
	private String oldPassword;	//ԭ����
	private String newPassword;	//������


	private IMessageService messageService;	//����������Ϣ�Ľӿ�
	private List<Message> messageList;	//�����б�

	private File upload;	//ͷ���ļ�
	private String uploadContentType;	//ͷ���ļ�����
	private String uploadFileName;	//ͷ���ļ�����
	private String photoPath;	//ͷ��·��

	/**
	 * ����ѧ��������������
	 * @return
	 */
	public String myTopics() {
		student = (Student) super.getSession().get(STUDENT);
		userInfo = student.getUserInfo();
		messageList = messageService.getMessageByUserInfo(userInfo);
		if (messageList.size() == 0) {
			addActionMessage("��Ŀǰ��δ�����������ԣ�");
		}
		return SUCCESS;

	}

	/**
	 * �޸�ͷ��
	 * @return
	 */
	public String changeHead() {
		student = (Student) super.getSession().get(STUDENT);
		String oldPhoto = student.getUserInfo().getPhoto();
		int pos = uploadFileName.lastIndexOf(".");
		String fileLink = "photo/" + new Date().getTime()+uploadFileName.substring(pos);
		student.getUserInfo().setPhoto(fileLink);
		if (studentInfoService.addStudentPhoto(student.getUserInfo(), upload,
				oldPhoto)) {
			userInfo = student.getUserInfo();
			return SUCCESS;
		} else {
			addActionError("�ϴ�ͷ��ʧ�ܣ��������ϴ���");
			return ERROR;
		}
	}

	/**
	 * ����ѧ��������Ϣ
	 * 
	 * @return
	 */
	public String findStudentInfo() {
		student = null;
		student = (Student) super.getSession().get(STUDENT);
		student = studentInfoService.findById(student.getId());
		if (student == null) {
			addActionError("����δ��¼�����ȵ�¼��");
			return ERROR;
		} else {
			userInfo = student.getUserInfo();
			return SUCCESS;
		}
	}

	/**
	 * �޸�ѧ����Ϣ
	 * 
	 * @return
	 */
	public String changeStudentInfo() {
		boolean result = studentInfoService.updateStudent(student, userInfo);
		if (result) {
			student = studentInfoService.findById(student.getId());
			userInfo = student.getUserInfo();
			super.getSession().put(STUDENT, student);
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * �޸�����
	 * 
	 * @return
	 */
	public String changePassword() {
		student = (Student) super.getSession().get(STUDENT);
		if (student.getPassword().equals(oldPassword)) {
			student.setPassword(newPassword);
			boolean result = studentInfoService.updatePassword(student);
			if (result) {
				addActionMessage("�޸�����ɹ���");
				return SUCCESS;
			} else
				return SUCCESS;
		} else {
			addActionError("ԭ�������");
			return SUCCESS;
		}
	}

	/**
	 * �����ҵĿγ�
	 * 
	 * @return
	 */
	public String findMyCourses() {
		student = (Student) super.getSession().get(STUDENT);
		List<StudentCourse> studentCourses = new ArrayList<StudentCourse>();
		studentCourses = studentCourseService.findByStudent(student);
		if (studentCourses.size() == 0) {
			addActionError("�����޿γ̣�");
			return SUCCESS;
		}
		courseList = new ArrayList<Course>();
		for (StudentCourse sc : studentCourses) {
			courseList.add(sc.getCourse());
		}
		return SUCCESS;
	}

	/**
	 * �����ҵ��ղؿγ�
	 * 
	 * @return
	 */
	public String findMyCollection() {
		student = (Student) super.getSession().get(STUDENT);
		List<Collection> collections = new ArrayList<Collection>();
		collections = studentCourseService.findCollectionByStudent(student);
		if (collections.size() == 0) {
			addActionError("����δ�ղ��κογ̣�");
			return SUCCESS;
		}
		courseList = new ArrayList<Course>();
		for (Collection c : collections) {
			courseList.add(c.getCourse());
		}
		return SUCCESS;
	}

	/**
	 * ɾ���ղؿγ�
	 * 
	 * @return
	 */
	public String deleteCollection() {
		student = (Student) super.getSession().get(STUDENT);
		course = courseService.getCourseById(courseId);
		boolean result = studentCourseService.deleteCollection(student, course);
		if (result) {
			this.findMyCollection();
			return SUCCESS;
		} else
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

	public void setStudentCourseService(
			IStudentCourseService studentCourseService) {
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
	
	public IMessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getPhotoPath() {
		return photoPath;
	}

}
