package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

public interface ICourseService {

	/**
	 * 添加新的课程
	 * @param course
	 * @param department
	 * @return
	 */
	public boolean addCourse(Course course, Department department,Teacher teacher);
	
	/**
	 * 根据课程Id查找课程
	 * @param courseId
	 * @return
	 */
	public Course getCourseById(Integer courseId);
	
	/**
	 * 根据教师查找课程
	 * @param teacherId
	 * @return
	 */
	public List findCoursesByTeacher(Integer teacherId,int type);
}
