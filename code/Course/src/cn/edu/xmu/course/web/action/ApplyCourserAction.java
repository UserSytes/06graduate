package cn.edu.xmu.course.web.action;

import cn.edu.xmu.course.pojo.*;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.IDepartmentService;
import cn.edu.xmu.course.service.ITeacherInfoService;

public class ApplyCourserAction extends BaseAction {

	private String departmentId;
	private String courseId;
	private Department department;
	private Teacher teacher;
	private TeacherCourse teacherCourse;
	private Course course;

	private ITeacherInfoService teacherInfoService;
	private ICourseService courseService;
	private IDepartmentService departmentService;

	private final String userName = "123";

	public String applyCourse() {
		Course course = getCourseService().getCourseById(Integer.parseInt(courseId));
		Teacher teacher = teacherInfoService.getTeacher(userName);
		if (getCourseService().applyCourse(teacher, course, teacherCourse))
			return SUCCESS;
		else
			return ERROR;
	}

	public String addNewCourse() {
		Department dept = departmentService.getDepartmentById(Integer
				.parseInt(departmentId));
		if (getCourseService().addCourse(course, dept))
			return SUCCESS;
		else
			return ERROR;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public TeacherCourse getTeacherCourse() {
		return teacherCourse;
	}

	public void setTeacherCourse(TeacherCourse teacherCourse) {
		this.teacherCourse = teacherCourse;
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

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public ICourseService getCourseService() {
		return courseService;
	}
}
