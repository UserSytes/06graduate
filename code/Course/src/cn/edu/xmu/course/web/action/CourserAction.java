package cn.edu.xmu.course.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.xmu.course.pojo.*;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.IDepartmentService;
import cn.edu.xmu.course.service.ITeacherInfoService;

/**
 * 
 * @author ������
 * @author ֣����
 * 
 */
public class CourserAction extends BaseAction {

	private String departmentId;
	private int courseId;
	private Department department;
	private Teacher teacher;
	private Course course;
	private List<Course> myCoursesList;
	private int type = 2;

	private ITeacherInfoService teacherInfoService;
	private ICourseService courseService;
	private IDepartmentService departmentService;

	private List<Course> applicationCourseList;
	private String refuseReason;
	
	private final String userName = "123";

	/**
	 * �걨�γ�
	 * 
	 * @return
	 */
	public String addNewCourse() {
		Department dept = departmentService.getDepartmentById(Integer
				.parseInt(departmentId));
		Teacher tea = teacherInfoService.getTeacher(userName);
		if (getCourseService().addCourse(course, dept, tea)) {
			addActionMessage("�걨�γ̳ɹ���");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��ȡĳ��ʦ�Ŀγ�
	 * 
	 * @return
	 */
	public String findMyCoursesList() {
		Teacher tea = teacherInfoService.getTeacher(userName);
		myCoursesList = courseService.findCoursesByTeacher(tea.getId(), type);
		if (myCoursesList.size() == 0) {
			addActionError("�����κογ̣�");
			return null;
		} else
			return SUCCESS;
	}

	/**
	 * ɾ���γ�
	 * 
	 * @return
	 */
	public String deleteCourse() {
		Course deleteCourse = courseService.getCourseById(courseId);
		if (courseService.deleteCourse(deleteCourse)) {
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��ȡ����γ��б�
	 * 
	 * @return
	 */
	public String findApplicationCourse() {
		Administrator admin = (Administrator) ActionSession.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		applicationCourseList = courseService.findApplicationCourse(school);
		if (applicationCourseList.size() == 0) {
			addActionError("�������걨�γ̣�");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	public String courseDetail(){
		course = courseService.getCourseById(courseId);
		if(course == null){
			return ERROR;
		}
		else
			return SUCCESS;
	}
	
	/**
	 * ��˿γ�ͨ��
	 * 
	 * @return
	 */
	public String coursePass() {
		course = courseService.getCourseById(courseId);
		course.setStatus(1);
		boolean result = courseService.updateCourse(course);
		if (result) {
			this.findApplicationCourse();
			addActionError(course.getName()+"�γ�ͨ����ˣ�");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��˿γ�δͨ��
	 * 
	 * @return
	 */
	public String courseNoPass() {
		course = courseService.getCourseById(course.getId());
		course.setStatus(2);
		course.setRefuseReason(refuseReason);
		boolean result = courseService.updateCourse(course);
		if (result) {
			addActionError(course.getName()+"�γ���˺��˻أ�");
			//this.findApplicationCourse();
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��ȡѧԺ�γ��б�
	 * 
	 * @return
	 */
	public String findCourse() {
		Administrator admin = (Administrator) ActionSession.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		applicationCourseList = courseService.findBySchool(school);
		if (applicationCourseList.size() == 0) {
			addActionError("���޿γ̣�");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * ��ȡѧԺ�˻ؿγ��б�
	 * 
	 * @return
	 */
	public String findNoPassCourse() {
		Administrator admin = (Administrator) ActionSession.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		applicationCourseList = courseService.findNoPassCourse(school);
		if (applicationCourseList.size() == 0) {
			addActionError("�����˻ؿγ̣�");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	public String saveCurrentCourse() {
		Course currentCourse = courseService.getCourseById(courseId);
		try {
			ActionSession.getSession().put(COURSE, currentCourse);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}

	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Course getCourse() {
		return course;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public IDepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setTeacherInfoService(ITeacherInfoService teacherInfoService) {
		this.teacherInfoService = teacherInfoService;
	}

	public ITeacherInfoService getTeacherInfoService() {
		return teacherInfoService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setMyCoursesList(List<Course> myCoursesList) {
		this.myCoursesList = myCoursesList;
	}

	public List<Course> getMyCoursesList() {
		return myCoursesList;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public List<Course> getApplicationCourseList() {
		return applicationCourseList;
	}

	public void setApplicationCourseList(List<Course> applicationCourseList) {
		this.applicationCourseList = applicationCourseList;
	}

	public int getCourseId() {
		return courseId;
	}

	public String getUserName() {
		return userName;
	}

	public String getRefuseReason() {
		return refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}

}
