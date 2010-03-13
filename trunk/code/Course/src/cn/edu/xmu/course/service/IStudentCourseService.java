package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Collection;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;

/**
 * ���� ѧ���γ̹�ϵ��ҵ�� �Ľӿ�
 * @author ֣����
 *
 */
public interface IStudentCourseService {

	/**
	 * ͨ���γ̲���ѧ���γ̱�
	 * @param course
	 * @return
	 */
	public List<StudentCourse> findByCourse(Course course);
	
	/**
	 * ����id����ѧ��
	 * @param id
	 * @return
	 */
	public Student findStudentById(int id);
	
	/**
	 * ͨ��ѧ�Ų���ѧ��
	 * @param studentNo
	 * @return
	 */
	public Student findStudentByStudentNo(String studentNo);
	
	/**
	 * ���ݿγ̡�ѧ��ɾ�� StudentCourse
	 * @param course
	 * @param student
	 * @return
	 */
	public boolean delete(Course course, Student student);
	
	/**
	 * ���ѧ���γ̹�ϵ
	 * @param studentCourse
	 * @return
	 */
	public boolean addStudentCourse(StudentCourse studentCourse);
	
	/**
	 * �������ѧ���γ̹�ϵ
	 * @param course
	 * @param studentFile
	 * @return
	 */
	public String addMoreStudentCourse(Course course, File studentFile);
	
	/**
	 * ����ѧ�����ҿγ�
	 * @param student
	 * @return
	 */
	public List<StudentCourse> findByStudent(Student student);
	
	/**
	 * ����ѧ�������ղؿγ�
	 * @param student
	 * @return
	 */
	public List<Collection> findCollectionByStudent(Student student);
	
	/**
	 * ɾ��ĳ�ſγ��ղ�
	 * @param student
	 * @param course
	 * @return
	 */
	public boolean deleteCollection(Student student, Course course);
	
	/**
	 * ����ĳѧ���ʺ��Ƿ���Լ���ĳ�γ�
	 * @param course
	 * @param studentNo
	 * @return
	 */
	public boolean checkStudent(Course course, Student student);
}
