package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.CourseDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.service.ISearchCourseService;

public class SearchCourseService implements ISearchCourseService {
	private CourseDAO courseDAO;
	@SuppressWarnings("unchecked")
	public List<Course> findCourseByDepartment(Department department){	
		return courseDAO.findByDepartment(department);
	}
	@SuppressWarnings("unchecked")
	public List<Course> findCourseByName(String name) {
		List<Course> courses= courseDAO.findByName(name);
		if(courses.size()==0)
			return null;
		else 
			return courses;
	}
	
	public Course findCourseById(int id){
		return courseDAO.findById(id);
	}
	
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
	@SuppressWarnings("unchecked")
	public List<Course> findCourseByTeacher(String teacherName) {
		return courseDAO.findByTeacher(teacherName);
	}
}
