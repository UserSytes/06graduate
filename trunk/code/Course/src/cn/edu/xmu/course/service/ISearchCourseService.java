package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;

/**
 * 课程搜索
 * @author 赵海虹
 * @author 郑冰凌
 *
 */
public interface ISearchCourseService {
	
	/**
	 * 根据系查找课程列表
	 * @param department
	 * @return
	 */
	public List<Course> findCourseByDepartment(Department department);
	
	/**
	 * 根据名字查找课程列表
	 * @param name
	 * @return
	 */
	public List<Course> findCourseByName(String name);
	
	/**
	 * 根据ID查找课程
	 * @param id
	 * @return
	 */
	public Course findCourseById(int id);
	
	/**
	 * 根据老师查找课程列表
	 * @param teacherName
	 * @return
	 */
	public List<Course> findCourseByTeacher(String teacherName);
	
	/**
	 * 根据课程名字和老师搜索课程
	 * @param courseName
	 * @param teacherName
	 * @return
	 */
	public List<Course> findCourseByNameAndTeacher(String courseName, String teacherName);
	
	/**
	 * 根据教师和系查找课程
	 * @param teacherName
	 * @param department
	 * @return
	 */
	public List<Course> findCourseByDepartmentAndTeacher(String teacherName, Department department);
	
	/**
	 * 根据课程名和学院名查找课程
	 * @param courseName
	 * @param department
	 * @return
	 */
	public List<Course> findCourseByNameAndDepartment(String courseName, Department department);

	/**
	 * 根据课程名、系和教师名查找课程
	 * @param courseName
	 * @param department
	 * @param teacherName
	 * @return
	 */
	public List<Course> findCourseByNameAndDepartmentAndTeacher(String courseName, Department department,  String teacherName);
	
	/**
	 * 根据时间查找课程
	 * @param day
	 * @return
	 */
	public List<Course> findCourseByDate(int day);
	
	/**
	 * 查找最新的课程
	 * @return
	 */
	public List<Course> findLatestTenCourse();
}
