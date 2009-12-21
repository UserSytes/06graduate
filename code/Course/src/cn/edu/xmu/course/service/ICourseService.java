package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.*;

public interface ICourseService {

	/**
	 * 添加新的课程
	 * @param course
	 * @param department
	 * @return
	 */
	public boolean addCourse(Course course, Department department);
	
	/**
	 * 申报课程
	 * @param teacher
	 * @param course
	 * @param teacherCourse
	 * @return
	 */
	public boolean applyCourse(Teacher teacher, Course course);
	
	/**
	 * 根据课程Id查找课程
	 * @param courseId
	 * @return
	 */
	public Course getCourseById(Integer courseId);
}
