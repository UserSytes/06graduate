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
	public List<Course> findCourseByTeacher(String teacherName);
	
	public List<Course> findCourseByNameAndTeacher(String courseName, String teacherName);
	public List<Course> findCourseByDepartmentAndTeacher(String teacherName, Department department);
	public List<Course> findCourseByNameAndDepartment(String courseName, Department department);
	public List<Course> findCourseByNameAndDepartmentAndTeacher(String courseName, Department department,  String teacherName);
	
	public List<Course> findCourseByDate(int day);
	public List<Course> findLatestTenCourse();
}
