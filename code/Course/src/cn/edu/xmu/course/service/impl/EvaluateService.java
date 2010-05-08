package cn.edu.xmu.course.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import cn.edu.xmu.course.commons.CourseEvaluate;
import cn.edu.xmu.course.dao.EvaluationDAO;
import cn.edu.xmu.course.dao.StudentCourseDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.service.IEvaluateService;

/**
 * 负责评价的类
 * 
 * @author 赵海虹
 * @author 何申密
 * 
 */
public class EvaluateService implements IEvaluateService {

	private StudentCourseDAO studentCourseDAO;
	private EvaluationDAO evaluationDAO;
	private List<StudentCourse> studentCourse;
	private Object score;
	private List<Evaluation> evaluation;

	/*
	 * 更新学生评价(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#updateStudentCourse(cn.edu
	 * .xmu.course.pojo.StudentCourse)
	 */
	public boolean updateStudentCourse(StudentCourse studentCourse) {
		try {
			studentCourseDAO.merge(studentCourse);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 根据学生ID查找学生评价(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#findStudentCourseByStudentId
	 * (java.lang.Integer)
	 */
	public StudentCourse findStudentCourseByStudentId(Integer id) {
		return studentCourseDAO.findById(id);
	}

	/*
	 * 根据课程和学生查找学生评价(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#findByStudentAndCourse(cn.
	 * edu.xmu.course.pojo.Course, cn.edu.xmu.course.pojo.Student)
	 */
	public List<StudentCourse> findByStudentAndCourse(Course course,
			Student student) {
		return studentCourse = studentCourseDAO.findByStudentAndCourse(course,
				student);
	}

	/*
	 * 更新专家和老师的评价(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#updateEvaluation(cn.edu.xmu
	 * .course.pojo.Evaluation)
	 */
	public boolean updateEvaluation(Evaluation evaluation) {
		try {
			evaluationDAO.merge(evaluation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 根据ID查找专家和老师的评价(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#findById(java.lang.Integer)
	 */
	public Evaluation findById(Integer id) {
		return evaluationDAO.findById(id);
	}

	/*
	 * 计算专家或者老师的评价结果(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#getEvaluationCalculateResult
	 * (int, int)
	 */
	public Object[] getEvaluationCalculateResult(int courseId, int sort) {
		List result = evaluationDAO.findCountAndScoreAvg(courseId, sort);
		ListIterator iterator = result.listIterator();
		Object[] rows = (Object[]) iterator.next();
		return rows;
	}

	/*
	 * 根据课程列表获取评价信息(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#getEvaluateByCourseList(java
	 * .util.List)
	 */
	public List<CourseEvaluate> getEvaluateByCourseList(List<Course> courseList) {
		List<CourseEvaluate> courseEvaluateList = new ArrayList<CourseEvaluate>();
		for (Course course : courseList) {
			CourseEvaluate courseEvaluate = new CourseEvaluate();
			courseEvaluate.setCourseName(course.getName());
			courseEvaluate.setTeacherName(course.getTeacher().getUserInfo()
					.getName());
			Object[] expertEvaluationResult = this
					.getEvaluationCalculateResult(course.getId(), 0);
			Object[] teacherEvaluationResult = this
					.getEvaluationCalculateResult(course.getId(), 1);
			Object[] scResult = this.getStudentCourseCalculateResult(course
					.getId());
			courseEvaluate.setStuCount(scResult[0]);
			courseEvaluate.setExpertCount(expertEvaluationResult[0]);
			courseEvaluate.setTeacherCount(teacherEvaluationResult[0]);

			if (scResult[1] != null)
				courseEvaluate.setStuAvgScore(scResult[1]);
			if (expertEvaluationResult[1] != null)
				courseEvaluate.setExpertAvgScore(expertEvaluationResult[1]);
			if (teacherEvaluationResult[1] != null)
				courseEvaluate.setTeacherAvgScore(teacherEvaluationResult[1]);
			courseEvaluateList.add(courseEvaluate);
		}
		return courseEvaluateList;
	}

	/*
	 * 查询学生对课程的平均评分(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#getStudentCourseCalculateResult
	 * (int)
	 */
	public Object[] getStudentCourseCalculateResult(int courseId) {
		List result = studentCourseDAO.findCountAndScoreAvg(courseId);
		ListIterator iterator = result.listIterator();
		Object[] rows = (Object[]) iterator.next();
		return rows;
	}

	/*
	 * 根据课程，用户名和分类查找专家或者老师的评价(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#findByCourseAndUsernameAndSort
	 * (cn.edu.xmu.course.pojo.Course, java.lang.String, int)
	 */
	public List<Evaluation> findByCourseAndUsernameAndSort(Course course,
			String username, int sort) {
		return evaluationDAO.findByCourseAndUsernameAndSort(course, username,
				sort);

	}

	/*
	 * 根据课程和分类查找专家或者老师的评价(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#findByCourseAndSort(cn.edu
	 * .xmu.course.pojo.Course, int)
	 */
	public List<Evaluation> findByCourseAndSort(Course course, int sort) {
		return evaluationDAO.findByCourseAndSort(course, sort);

	}

	/*
	 * 根据课程，分类和状态专家或者老师的评价(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#findByCourseAndSortAndStatus
	 * (cn.edu.xmu.course.pojo.Course, int, int)
	 */
	public List<Evaluation> findByCourseAndSortAndStatus(Course course,
			int sort, int status) {
		return evaluationDAO.findByCourseAndSortAndStatus(course, sort, status);

	}

	/*
	 * 邀请专家评价(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#addEvaluation(cn.edu.xmu.course
	 * .pojo.Evaluation, cn.edu.xmu.course.pojo.Course)
	 */
	public boolean addEvaluation(Evaluation evaluation, Course course) {
		// TODO Auto-generated method stub
		evaluation.setCourse(course);
		evaluation.setStatus(0);

		try {
			evaluationDAO.save(evaluation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 删除课程评价
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IEvaluateService#deleteEvaluation(cn.edu.xmu
	 * .course.pojo.Evaluation)
	 */
	public boolean deleteEvaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		try {
			evaluationDAO.delete(evaluation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setStudentCourseDAO(StudentCourseDAO studentCourseDAO) {
		this.studentCourseDAO = studentCourseDAO;
	}

	public StudentCourseDAO getStudentCourseDAO() {
		return studentCourseDAO;
	}

	public EvaluationDAO getEvaluationDAO() {
		return evaluationDAO;
	}

	public void setEvaluationDAO(EvaluationDAO evaluationDAO) {
		this.evaluationDAO = evaluationDAO;
	}

	public Object getScore() {
		return score;
	}

	public void setScore(Object score) {
		this.score = score;
	}

	public List<Evaluation> getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(List<Evaluation> evaluation) {
		this.evaluation = evaluation;
	}

	public List<StudentCourse> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(List<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}

}
