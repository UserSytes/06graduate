package cn.edu.xmu.course.service.impl;

import java.util.List;
import java.util.ListIterator;

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
	private Object score ;
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
	
	public List<StudentCourse>  findByStudentAndCourse(Course course, Student student) {
		return studentCourse=studentCourseDAO.findByStudentAndCourse(course, student);
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

	// 算课程评价得分
	public Object calculatStudent(int courseId) {
		Object result = getStudentCourseCalculateResult(courseId)[1];
		return result;
	}
	
	public Object[] getEvaluationCalculateResult(int courseId){
		List result  = evaluationDAO.findCountAndScoreAvg(courseId);
		ListIterator iterator=result.listIterator();
		Object[] rows=(Object[])iterator.next();
		System.out.println("資料筆數:"+rows[0]+"\n平均年齡:"+rows[1]);
		return  rows;
	}
	
	public Object[] getStudentCourseCalculateResult(int courseId){
		List result  = studentCourseDAO.findCountAndScoreAvg(courseId);
		ListIterator iterator=result.listIterator();
		Object[] rows=(Object[])iterator.next();
		return rows;
	}

	// 根据课程ID找Evaluation
	public List<Evaluation> findEvaluationByCourseId(int courseId) {
		return evaluationDAO.findByCourse(courseId);
	}
	//根据课程和用户名找Evaluation
	public List<Evaluation> findByCourseAndUsernameAndSort(Course course,String username,int sort) {
		System.out.println("findByCourseAndUsername");
		System.out.println("course:"+course.getName());
		System.out.println("username:"+username);
		return  evaluationDAO.findByCourseAndUsernameAndSort(course, username,sort);
		
	}
	//根据课程和分类找Evaluation
	public List<Evaluation> findByCourseAndSort(Course course,int sort) {	
		return evaluationDAO.findByCourseAndSort(course, sort);
		
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

	public boolean addStudentCourse(StudentCourse  studentCourse, Course course) {
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
