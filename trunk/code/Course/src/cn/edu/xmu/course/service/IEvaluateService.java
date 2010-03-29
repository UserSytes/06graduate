package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;

public interface IEvaluateService {
	
	public boolean updateStudentCourse(StudentCourse studentCourse); 
	public StudentCourse findStudentCourseByStudentId(Integer id );
	public boolean updateEvaluation(Evaluation evaluation); 
	public Evaluation findById(Integer id); 
	public Object calculatStudent(int courseId);

	public Object[] getEvaluationCalculateResult(int courseId);
	public Object[] getStudentCourseCalculateResult(int courseId);
	public List<Evaluation>  findEvaluationByCourseId(int courseId);
	public List<StudentCourse>  findByStudentAndCourse(Course course, Student student);
	public List<Evaluation> findByCourseAndUsernameAndSort(Course course,String username,int sort);
	public List<Evaluation> findByCourseAndSort(Course course,Object object);
	/**
	 * ÑûÇë×¨¼ÒÆÀ¼Û
	 * @param evaluation
	 * @param course
	 * @return
	 */
	public boolean addEvaluation(Evaluation evaluation, Course course);
	public boolean addStudentCourse(StudentCourse  studentcourse, Course course);
}
