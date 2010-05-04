package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.commons.CourseEvaluate;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;

/**
 * 负责评价的接口
 * @author 赵海虹 何申密
 *
 */
public interface IEvaluateService {
	
	/**
	 * 更新学生评价
	 * @param studentCourse
	 * @return
	 */
	public boolean updateStudentCourse(StudentCourse studentCourse); 
	
	/**
	 * 根据学生ID查找学生评价
	 * @param id
	 * @return
	 */
	public StudentCourse findStudentCourseByStudentId(Integer id );
	
	/**
	 * 更新专家和老师的评价
	 * @param evaluation
	 * @return
	 */
	public boolean updateEvaluation(Evaluation evaluation); 
	
	/**
	 * 根据ID查找专家和老师的评价
	 * @param id
	 * @return
	 */
	public Evaluation findById(Integer id); 

	/**
	 * 计算专家或者老师的评价结果
	 * @param courseId
	 * @param sort
	 * @return
	 */
	public Object[] getEvaluationCalculateResult(int courseId, int sort);
	
	/**
	 * 查询学生对课程的平均评分
	 * @param courseId
	 * @return
	 */
	public Object[] getStudentCourseCalculateResult(int courseId);
	
	/**
	 * 根据课程和学生查找学生评价
	 * @param course
	 * @param student
	 * @return
	 */
	public List<StudentCourse>  findByStudentAndCourse(Course course, Student student);
	
	/**
	 * 根据课程，用户名和分类查找专家或者老师的评价
	 * @param course
	 * @param username
	 * @param sort
	 * @return
	 */
	public List<Evaluation> findByCourseAndUsernameAndSort(Course course,String username,int sort);
	
	/**
	 * 根据课程和分类查找专家或者老师的评价
	 * @param course
	 * @param sort
	 * @return
	 */
	public List<Evaluation> findByCourseAndSort(Course course,int sort);
	
	/**
	 * 根据课程，分类和状态专家或者老师的评价
	 * @param course
	 * @param sort
	 * @param status
	 * @return
	 */
	public List<Evaluation> findByCourseAndSortAndStatus(Course course,int sort,int status);
	
	/**
	 * 邀请专家评价
	 * @param evaluation
	 * @param course
	 * @return
	 */
	public boolean addEvaluation(Evaluation evaluation, Course course);
	
	/**
	 * 根据课程列表获取评价信息
	 * @param courseList
	 * @return
	 */
	public List<CourseEvaluate> getEvaluateByCourseList(List<Course> courseList);
}
