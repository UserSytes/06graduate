package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;

/**
 * ¿Î³ÌËÑË÷
 * @author 
 *
 */
public interface ISearchCourseService {
	public List<Course> findCourseByDepartment(Department department);
	public List<Course> findCourseByName(String name);
	public Course findCourseById(int id);
}
