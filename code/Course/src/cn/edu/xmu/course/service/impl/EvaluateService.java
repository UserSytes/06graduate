package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.CourseDAO;
import cn.edu.xmu.course.dao.EvaluationDAO;
import cn.edu.xmu.course.dao.StudentCourseDAO;
import cn.edu.xmu.course.pojo.Achievement;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.service.IEvaluateService;


public class EvaluateService implements IEvaluateService{

	private StudentCourseDAO studentCourseDAO;
	private EvaluationDAO evaluationDAO;
	private List<StudentCourse> studentCourse;
	private Float score=0.0f;
	private CourseDAO courseDAO;
	
	public boolean updateStudentCourse(StudentCourse studentCourse) {
		try{
			studentCourseDAO.merge(studentCourse);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public StudentCourse findStudentCourseByStudentId(Integer id ) {
			return studentCourseDAO.findById(id);
	}
	
	public boolean  updateEvaluation(Evaluation evaluation) {
		try{
			evaluationDAO.merge(evaluation);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public Evaluation findById(Integer id){
		return evaluationDAO.findById(id);
	}
	//算课程评价得分
	public Float calculatStudent(int courseId){
		score=0.0f;
		studentCourse=studentCourseDAO.findByCourse(courseId);
		System.out.println("test_1: "+studentCourse.size());
		if(studentCourse.size()==0){
			score=-1.0f;
			System.out.println("test_2: "+score);
		}
		else{
			for(int i=0;i<studentCourse.size();i++)
			{
				score+=studentCourse.get(i).getScore();
			}
			score=score/studentCourse.size();
		}
		
		return score;
	}
	//根据课程ID找课程
	public Course findCourseById(int courseId){
		return courseDAO.findById(courseId);
	}
	
	//根据课程ID找Evaluation
	public List<Evaluation>  findEvaluationByCourseId(int courseId){
		return evaluationDAO.findByCourse(courseId);
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
		return studentCourse;
	}
	public void setStudentCourse(List<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}


	

}
