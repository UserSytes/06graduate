package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.commons.CourseEvaluate;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;

/**
 * �������۵Ľӿ�
 * @author �Ժ��� ������
 *
 */
public interface IEvaluateService {
	
	/**
	 * ����ѧ������
	 * @param studentCourse
	 * @return
	 */
	public boolean updateStudentCourse(StudentCourse studentCourse); 
	
	/**
	 * ����ѧ��ID����ѧ������
	 * @param id
	 * @return
	 */
	public StudentCourse findStudentCourseByStudentId(Integer id );
	
	/**
	 * ����ר�Һ���ʦ������
	 * @param evaluation
	 * @return
	 */
	public boolean updateEvaluation(Evaluation evaluation); 
	
	/**
	 * ����ID����ר�Һ���ʦ������
	 * @param id
	 * @return
	 */
	public Evaluation findById(Integer id); 

	/**
	 * ����ר�һ�����ʦ�����۽��
	 * @param courseId
	 * @param sort
	 * @return
	 */
	public Object[] getEvaluationCalculateResult(int courseId, int sort);
	
	/**
	 * ��ѯѧ���Կγ̵�ƽ������
	 * @param courseId
	 * @return
	 */
	public Object[] getStudentCourseCalculateResult(int courseId);
	
	/**
	 * ���ݿγ̺�ѧ������ѧ������
	 * @param course
	 * @param student
	 * @return
	 */
	public List<StudentCourse>  findByStudentAndCourse(Course course, Student student);
	
	/**
	 * ���ݿγ̣��û����ͷ������ר�һ�����ʦ������
	 * @param course
	 * @param username
	 * @param sort
	 * @return
	 */
	public List<Evaluation> findByCourseAndUsernameAndSort(Course course,String username,int sort);
	
	/**
	 * ���ݿγ̺ͷ������ר�һ�����ʦ������
	 * @param course
	 * @param sort
	 * @return
	 */
	public List<Evaluation> findByCourseAndSort(Course course,int sort);
	
	/**
	 * ���ݿγ̣������״̬ר�һ�����ʦ������
	 * @param course
	 * @param sort
	 * @param status
	 * @return
	 */
	public List<Evaluation> findByCourseAndSortAndStatus(Course course,int sort,int status);
	
	/**
	 * ����ר������
	 * @param evaluation
	 * @param course
	 * @return
	 */
	public boolean addEvaluation(Evaluation evaluation, Course course);
	
	/**
	 * ���ݿγ��б��ȡ������Ϣ
	 * @param courseList
	 * @return
	 */
	public List<CourseEvaluate> getEvaluateByCourseList(List<Course> courseList);
}
