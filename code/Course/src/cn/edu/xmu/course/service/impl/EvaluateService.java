package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.CourseDAO;
import cn.edu.xmu.course.dao.EvaluationDAO;
import cn.edu.xmu.course.dao.StudentCourseDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.service.IEvaluateService;

public class EvaluateService implements IEvaluateService {

	private StudentCourseDAO studentCourseDAO;
	private EvaluationDAO evaluationDAO;
	private List<StudentCourse> studentCourseList;
	private Float score = 0.0f;

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

	// ��γ����۵÷�
	public Float calculatStudent(int courseId) {
		score = 0.0f;
		studentCourseList = studentCourseDAO.findByCourse(courseId);
		System.out.println("test_1: " + studentCourseList.size());
		if (studentCourseList.size() == 0) {
			score = -1.0f;
			System.out.println("test_2: " + score);
		} else {
			for (int i = 0; i < studentCourseList.size(); i++) {
				score += studentCourseList.get(i).getScore();
			}
			score = score / studentCourseList.size();
		}
		return score;
	}

	// ���ݿγ�ID��Evaluation
	public List<Evaluation> findEvaluationByCourseId(int courseId) {
		return evaluationDAO.findByCourse(courseId);
	}

	public boolean addEvaluation(Evaluation evaluation, Course course) {
		// TODO Auto-generated method stub
		evaluation.setCourse(course);
		try {
			evaluationDAO.save(evaluation);
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

	public List<StudentCourse> getStudentCourse() {
		return studentCourseList;
	}

	public void setStudentCourse(List<StudentCourse> studentCourse) {
		this.studentCourseList = studentCourse;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

}
