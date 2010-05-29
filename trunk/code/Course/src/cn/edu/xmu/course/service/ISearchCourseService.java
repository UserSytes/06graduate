package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;

/**
 * �γ�����
 * @author �Ժ���
 * @author ֣����
 *
 */
public interface ISearchCourseService {
	
	/**
	 * ����ϵ���ҿγ��б�
	 * @param department
	 * @return
	 */
	public List<Course> findCourseByDepartment(Department department);
	
	/**
	 * �������ֲ��ҿγ��б�
	 * @param name
	 * @return
	 */
	public List<Course> findCourseByName(String name);
	
	/**
	 * ����ID���ҿγ�
	 * @param id
	 * @return
	 */
	public Course findCourseById(int id);
	
	/**
	 * ������ʦ���ҿγ��б�
	 * @param teacherName
	 * @return
	 */
	public List<Course> findCourseByTeacher(String teacherName);
	
	/**
	 * ���ݿγ����ֺ���ʦ�����γ�
	 * @param courseName
	 * @param teacherName
	 * @return
	 */
	public List<Course> findCourseByNameAndTeacher(String courseName, String teacherName);
	
	/**
	 * ���ݽ�ʦ��ϵ���ҿγ�
	 * @param teacherName
	 * @param department
	 * @return
	 */
	public List<Course> findCourseByDepartmentAndTeacher(String teacherName, Department department);
	
	/**
	 * ���ݿγ�����ѧԺ�����ҿγ�
	 * @param courseName
	 * @param department
	 * @return
	 */
	public List<Course> findCourseByNameAndDepartment(String courseName, Department department);

	/**
	 * ���ݿγ�����ϵ�ͽ�ʦ�����ҿγ�
	 * @param courseName
	 * @param department
	 * @param teacherName
	 * @return
	 */
	public List<Course> findCourseByNameAndDepartmentAndTeacher(String courseName, Department department,  String teacherName);
	
	/**
	 * ����ʱ����ҿγ�
	 * @param day
	 * @return
	 */
	public List<Course> findCourseByDate(int day);
	
	/**
	 * �������µĿγ�
	 * @return
	 */
	public List<Course> findLatestTenCourse();
}
