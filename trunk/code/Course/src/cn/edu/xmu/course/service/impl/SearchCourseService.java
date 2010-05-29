package cn.edu.xmu.course.service.impl;

import java.util.Calendar;
import java.util.List;

import cn.edu.xmu.course.commons.CalculateDate;
import cn.edu.xmu.course.dao.CourseDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.service.ISearchCourseService;

/**
 * ¿Î³ÌËÑË÷
 * 
 * @author ÕÔº£ºç
 * @author Ö£±ùÁè
 * 
 */
public class SearchCourseService implements ISearchCourseService {
	private CourseDAO courseDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ISearchCourseService#findCourseByDepartment
	 * (cn.edu.xmu.course.pojo.Department)
	 */
	public List<Course> findCourseByDepartment(Department department) {
		return courseDAO.findByDepartment(department);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ISearchCourseService#findCourseByName(java.
	 * lang.String)
	 */
	public List<Course> findCourseByName(String name) {
		List<Course> courses = courseDAO.findByName(name);
		if (courses.size() == 0)
			return null;
		else
			return courses;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ISearchCourseService#findCourseByNameAndTeacher
	 * (java.lang.String, java.lang.String)
	 */
	public List<Course> findCourseByNameAndTeacher(String courseName,
			String teacherName) {
		return courseDAO.findCourseByNameAndTeacher(courseName, teacherName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecn.edu.xmu.course.service.ISearchCourseService#
	 * findCourseByDepartmentAndTeacher(java.lang.String,
	 * cn.edu.xmu.course.pojo.Department)
	 */
	public List<Course> findCourseByDepartmentAndTeacher(String teacherName,
			Department department) {
		return courseDAO.findCourseByDepartmentAndTeacher(teacherName,
				department);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ISearchCourseService#findCourseByNameAndDepartment
	 * (java.lang.String, cn.edu.xmu.course.pojo.Department)
	 */
	public List<Course> findCourseByNameAndDepartment(String courseName,
			Department department) {
		return courseDAO.findCourseByNameAndDepartment(courseName, department);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecn.edu.xmu.course.service.ISearchCourseService#
	 * findCourseByNameAndDepartmentAndTeacher(java.lang.String,
	 * cn.edu.xmu.course.pojo.Department, java.lang.String)
	 */
	public List<Course> findCourseByNameAndDepartmentAndTeacher(
			String courseName, Department department, String teacherName) {
		return courseDAO.findCourseByNameAndDepartmentAndTeacher(courseName,
				department, teacherName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.ISearchCourseService#findCourseByDate(int)
	 */
	public List<Course> findCourseByDate(int day) {
		Calendar date = CalculateDate
				.addDate(Calendar.getInstance(), (0 - day));
		return courseDAO.findCourseByDate(CalculateDate.toDate(date.getTime()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.ISearchCourseService#findCourseById(int)
	 */
	public Course findCourseById(int id) {
		return courseDAO.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ISearchCourseService#findCourseByTeacher(java
	 * .lang.String)
	 */
	public List<Course> findCourseByTeacher(String teacherName) {
		return courseDAO.findByTeacher(teacherName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.ISearchCourseService#findLatestTenCourse()
	 */
	public List<Course> findLatestTenCourse() {
		// TODO Auto-generated method stub
		return courseDAO.findLatestTenCourses();
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
}
