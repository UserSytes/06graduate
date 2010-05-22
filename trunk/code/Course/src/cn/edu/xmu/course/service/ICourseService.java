package cn.edu.xmu.course.service;

import java.util.List;
import cn.edu.xmu.course.pojo.*;
/**
 * �������γ̵Ľӿ�
 * @author ֣����
 * @author ������
 *
 */
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
	
	/**
	 * ɾ���γ�
	 * @param course
	 * @return
	 */
	public boolean deleteCourse(Course course);

	/**
	 * ���ݼ�����ҿγ�
	 * @param time
	 * @return
	 */
	public List findCourseListLevel(String level);

	/**
	 * ���ݼ�����ҿγ�
	 * @param time
	 * @return
	 */
	public List findCourseListByLevel(String level);
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
	public List findNoPassCourse(School school);
	
	/**
	 * ����ѧԺ�ȴ���˵Ŀγ�
	 * @param school
	 * @return
	 */
	public List findApplicationCourse(School school);
	
	/**
	 * ���ұ�Ժ��ͨ����˵Ŀγ�
	 * @param school
	 * @return
	 */
	public List findBySchool(School school);
	

}
