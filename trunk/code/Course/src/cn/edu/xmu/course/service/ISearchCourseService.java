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
	
	public List findCourseByDepartment(Department department);
	public List findCourseByName(String name);
	public Course findCourseById(int id);
	public List findCourseByTeacher(String teacherName);
	
	public List findCourseByNameAndTeacher(String courseName, String teacherName);
	public List findCourseByDepartmentAndTeacher(String teacherName, Department department);
	public List findCourseByNameAndDepartment(String courseName, Department department);
	public List findCourseByNameAndDepartmentAndTeacher(String courseName, Department department,  String teacherName);
	
	public List findCourseByDate(int day);
	public List findLatestTenCourse();
}
