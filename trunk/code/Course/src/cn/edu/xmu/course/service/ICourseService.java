package cn.edu.xmu.course.service;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.pojo.*;

public interface ICourseService {

	/**
	 * �����µĿγ�
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
	
	/**
	 * ɾ���γ�
	 * @param course
	 * @return
	 */
	public boolean deleteCourse(Course course);

	
	
	
	/**
	 * ����ʱ��ͼ�����ҿγ�
	 * @param time
	 * @return
	 */
	public List findCourseListByTimeAndLevel(String time, String level);
	
	/**
	 * ���¿γ�
	 * @param course
	 * @return
	 */
	public boolean updateCourse(Course course);
	
	/**
	 * ����ѧԺ���δͨ���Ŀγ�
	 * @param school
	 * @return
	 */
	public List<Course> findNoPassCourse(School school);
	
	/**
	 * ����ѧԺ�ȴ���˵Ŀγ�
	 * @param school
	 * @return
	 */
	public List<Course> findApplicationCourse(School school);
	
	/**
	 * ���ұ�Ժ��ͨ����˵Ŀγ�
	 * @param school
	 * @return
	 */
	public List<Course> findBySchool(School school);

}