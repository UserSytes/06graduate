package cn.edu.xmu.course.service;

import java.util.List;

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
}
