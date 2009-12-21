package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.*;

public interface ICourseService {

	/**
	 * ����µĿγ�
	 * @param course
	 * @param department
	 * @return
	 */
	public boolean addCourse(Course course, Department department);
	
	/**
	 * �걨�γ�
	 * @param teacher
	 * @param course
	 * @param teacherCourse
	 * @return
	 */
	public boolean applyCourse(Teacher teacher, Course course);
	
	/**
	 * ���ݿγ�Id���ҿγ�
	 * @param courseId
	 * @return
	 */
	public Course getCourseById(Integer courseId);
}
