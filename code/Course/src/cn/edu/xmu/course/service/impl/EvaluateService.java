package cn.edu.xmu.course.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import cn.edu.xmu.course.commons.CourseEvaluate;
import cn.edu.xmu.course.dao.CourseDAO;
import cn.edu.xmu.course.dao.EvaluationDAO;
import cn.edu.xmu.course.dao.StudentCourseDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.service.IEvaluateService;

public class EvaluateService implements IEvaluateService {

	private StudentCourseDAO studentCourseDAO;
	private EvaluationDAO evaluationDAO;
	private List<StudentCourse> studentCourse;
	private Object score;
	private List<Evaluation> evaluation;

	public boolean updateStudentCourse(StudentCourse studentCourse) {
		try {
			studentCourseDAO.merge(studentCourse);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public StudentCourse findStudentCourseByStudentId(Integer id) {
		return studentCourseDAO.findById(id);
	}

	public List<StudentCourse> findByStudentAndCourse(Course course,
			Student student) {
		return studentCourse = studentCourseDAO.findByStudentAndCourse(course,
				student);
	}

	public boolean updateEvaluation(Evaluation evaluation) {
		try {
			evaluationDAO.merge(evaluation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Evaluation findById(Integer id) {
		return evaluationDAO.findById(id);
	}

	/**
	 * 查询学生对课程的平均评分
	 * 
	 */
	public Object calculatStudent(int courseId) {
		Object result = getStudentCourseCalculateResult(courseId)[1];
		return result;
	}

	public Object[] getEvaluationCalculateResult(int courseId, int sort) {
		List result = evaluationDAO.findCountAndScoreAvg(courseId, sort);
		ListIterator iterator = result.listIterator();
		Object[] rows = (Object[]) iterator.next();
		System.out.println("資料筆數:" + rows[0] + "\n平均年齡:" + rows[1]);
		return rows;
	}

	/**
	 * 根据课程列表获取评价信息
	 * @param courseList
	 * @return
	 */
	public List<CourseEvaluate> getEvaluateByCourseList(List<Course> courseList){
		List<CourseEvaluate> courseEvaluateList = new ArrayList<CourseEvaluate>() ;
		for(Course course : courseList){
			CourseEvaluate courseEvaluate = new CourseEvaluate();
			courseEvaluate.setCourseName(course.getName());
			courseEvaluate.setTeacherName(course.getTeacher().getUserInfo().getName());
			Object[] expertEvaluationResult = this.getEvaluationCalculateResult(course.getId(), 0);
			Object[] teacherEvaluationResult = this.getEvaluationCalculateResult(course.getId(), 1);
			Object[] scResult = this.getStudentCourseCalculateResult(course.getId());
			courseEvaluate.setStuCount( scResult[0]);
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

	public Object[] getStudentCourseCalculateResult(int courseId) {
		List result = studentCourseDAO.findCountAndScoreAvg(courseId);
		ListIterator iterator = result.listIterator();
		Object[] rows = (Object[]) iterator.next();
		return rows;
	}


	// 根据课程和用户名找Evaluation
	public List<Evaluation> findByCourseAndUsernameAndSort(Course course,
			String username, int sort) {
		System.out.println("findByCourseAndUsername");
		System.out.println("course:" + course.getName());
		System.out.println("username:" + username);
		return evaluationDAO.findByCourseAndUsernameAndSort(course, username,
				sort);

	}

	// 根据课程和分类找Evaluation
	public List<Evaluation> findByCourseAndSort(Course course, int sort) {
		return evaluationDAO.findByCourseAndSort(course, sort);

	}
	// 根据课程和分类找Evaluation
	public List<Evaluation> findByCourseAndSortAndStatus(Course course, int sort,int status) {
		return evaluationDAO.findByCourseAndSortAndStatus(course, sort,status);

	}
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

	public boolean addStudentCourse(StudentCourse studentCourse, Course course) {
		// TODO Auto-generated method stub
		studentCourse.setCourse(course);
		studentCourse.setStatus(0);
		try {
			studentCourseDAO.save(studentCourse);
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
