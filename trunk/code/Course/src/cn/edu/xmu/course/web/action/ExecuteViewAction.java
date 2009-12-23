package cn.edu.xmu.course.web.action;

import java.util.List;

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
	private School school;

	private ApplicationForm applicationForm;
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
	 * @param department
	 * @return
	 */

	public String findCourseByDepartment() {
		Department dept = departmentService.getDepartmentById(Integer
				.parseInt(departmentId));
		setCourseList(searchCourseService.findCourseByDepartment(dept));
		System.out.print("\n&&&&&&&&&&&&&&&&&&&&&&" + getCourseList().size()
				+ getCourseList().get(0).getName()
				+ getCourseList().get(0).getId());
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
	 * @param courseName
	 * @return
	 */
	public String findCourseByName() {
		courseList = searchCourseService.findCourseByName(courseName);
		System.out.print("\n&&&&&&&&&&&&&&&&&&&&&&" + courseList.size()
				+ courseList.get(0).getName() + courseList.get(0).getId());
		if (courseList.size() == 0) {
			return ERROR;
		} else
			return "courses";
	}

	public String enterCourse() {
		course = searchCourseService.findCourseById(courseId);
		if (course == null) {
			return ERROR;
		} else
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


	public ApplicationForm getApplicationForm() {
		return applicationForm;
	}

	public void setApplicationForm(ApplicationForm applicationForm) {
		this.applicationForm = applicationForm;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
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

}
