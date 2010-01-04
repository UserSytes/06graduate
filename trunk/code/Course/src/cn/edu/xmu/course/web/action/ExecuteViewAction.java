package cn.edu.xmu.course.web.action;

import java.util.List;

import org.apache.struts2.config.Namespace;

import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.IApplicationFormService;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.IDepartmentService;
import cn.edu.xmu.course.service.ISearchCourseService;

public class ExecuteViewAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Department department;
	private String departmentId;
	private String courseName;
	private int courseId;
	private List<Course> courseList;
	private Course course;
	private String teacherName;
	private ISearchCourseService searchCourseService;
	private IDepartmentService departmentService;
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * 通过院系查找
	 * 
	 * @return
	 */

	public String findCourseByDepartment() {
		Department dept = departmentService.getDepartmentById(Integer
				.parseInt(departmentId));
		setCourseList(searchCourseService.findCourseByDepartment(dept));
		if (getCourseList().size() == 0) {
			return ERROR;
		} else
			return "courses";
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * 通过名称查找
	 * 
	 * @return
	 */
	public String findCourseByName() {
		courseList = searchCourseService.findCourseByName(courseName);
		if (courseList.size() == 0) {
			return ERROR;
		} else
			return "courses";
	}
	/**
	 * 通过教师查找
	 * @return
	 */
	public String findCourseByTeacher(){
		courseList = searchCourseService.findCourseByTeacher(teacherName);
		if (courseList.size() == 0) {
			return ERROR;
		} else
			return "courses";
	}
	/**
	 * 进入课程
	 * @return
	 */
	public String enterCourse() {
		course = searchCourseService.findCourseById(courseId);
		if (course == null) {
			return ERROR;
		} else
			ActionSession.getSession().put(COURSE,course);
			return "course";

	}
	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public ISearchCourseService getSearchCourseService() {
		return searchCourseService;
	}

	public void setSearchCourseService(ISearchCourseService searchCourseService) {
		this.searchCourseService = searchCourseService;
	}


	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public IDepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherName() {
		return teacherName;
	}


}
