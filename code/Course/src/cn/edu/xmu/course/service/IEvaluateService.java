package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.StudentCourse;

public interface IEvaluateService {
	
	public boolean updateStudentCourse(StudentCourse studentCourse); 
	public StudentCourse findStudentCourseByStudentId(Integer id );
	public boolean updateEvaluation(Evaluation evaluation); 
	public Evaluation findById(Integer id); 
	public Float calculatStudent(int courseId);

	public List<Evaluation>  findEvaluationByCourseId(int courseId);
	
	/**
	 * ÑûÇë×¨¼ÒÆÀ¼Û
	 * @param evaluation
	 * @param course
	 * @return
	 */
	public boolean addEvaluation(Evaluation evaluation, Course course);
}
