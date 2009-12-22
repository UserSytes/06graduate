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
		return courseDAO.findByProperty("Department", department);		
	}
	@SuppressWarnings("unchecked")
	public List<Course> findCourseByName(String name) {
		
		return courseDAO.findByName(name);
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
}
