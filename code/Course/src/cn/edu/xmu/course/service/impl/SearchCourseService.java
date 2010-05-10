package cn.edu.xmu.course.service.impl;

import java.util.Calendar;
import java.util.List;

import cn.edu.xmu.course.commons.CalculateDate;
import cn.edu.xmu.course.dao.CourseDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.service.ISearchCourseService;

public class SearchCourseService implements ISearchCourseService {
	private CourseDAO courseDAO;

	@SuppressWarnings("unchecked")
	public List<Course> findCourseByDepartment(Department department) {
		return courseDAO.findByDepartment(department);
	}

	@SuppressWarnings("unchecked")
	public List<Course> findCourseByName(String name) {
		List<Course> courses = courseDAO.findByName(name);
		if (courses.size() == 0)
			return null;
		else
			return courses;
	}

	public List<Course> findCourseByNameAndTeacher(String courseName,
			String teacherName) {
		return courseDAO.findCourseByNameAndTeacher(courseName, teacherName);
	}

	public List<Course> findCourseByDepartmentAndTeacher(String teacherName,
			Department department) {
		return courseDAO.findCourseByDepartmentAndTeacher(teacherName,
				department);
	}

	public List<Course> findCourseByNameAndDepartment(String courseName,
			Department department) {
		return courseDAO.findCourseByNameAndDepartment(courseName, department);
	}

	public List<Course> findCourseByNameAndDepartmentAndTeacher(
			String courseName, Department department, String teacherName) {
		return courseDAO.findCourseByNameAndDepartmentAndTeacher(courseName,
				department, teacherName);
	}

	/**
	 * 按时间查找课程
	 * 
	 * @param day
	 * @return
	 */
	public List<Course> findCourseByDate(int day) {
		Calendar date = CalculateDate
				.addDate(Calendar.getInstance(), (0 - day));
		return courseDAO.findCourseByDate(CalculateDate.toDate(date.getTime()));
	}

	public Course findCourseById(int id) {
		return courseDAO.findById(id);
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public List<Course> findCourseByTeacher(String teacherName) {
		return courseDAO.findByTeacher(teacherName);
	}

	public List<Course> findLatestTenCourse() {
		// TODO Auto-generated method stub	
		return  courseDAO.findLatestTenCourses();
	}

}
