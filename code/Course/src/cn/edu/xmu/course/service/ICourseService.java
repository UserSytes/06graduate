package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

public interface ICourseService {

	/**
	 * ����µĿγ�
	 * @param course
	 * @param department
	 * @return
	 */
	public boolean addCourse(Course course, Department department,Teacher teacher);
	
	/**
	 * ���ݿγ�Id���ҿγ�
	 * @param courseId
	 * @return
	 */
	public Course getCourseById(Integer courseId);
	
	/**
	 * ���ݽ�ʦ���ҿγ�
	 * @param teacherId
	 * @return
	 */
	public List findCoursesByTeacher(Integer teacherId,int type);
}
