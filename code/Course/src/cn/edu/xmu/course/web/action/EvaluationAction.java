package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.service.IEvaluateService;


public class EvaluationAction extends BaseAction {

	private IEvaluateService evaluateService;
	private StudentCourse studentCourse;
	private Float score;
	private Object viewScore;
	private String scorestring;
	private Student student;
	private Evaluation evaluation;
	private String content;
	private Course course;
	private int courseId;
	private int evaluationId;
	private Object stuAvgScore=0;
	private Object expertAvgScore=0;
	private Object stuCount;
	private Object expertCount;
	private List<Evaluation> evaluationList;

	/**
	 * 进入课程评价
	 * 
	 * @return
	 */

	public String evaluate() {
		return SUCCESS;
	}

	/**
	 * 学生课程评价结果
	 * 
	 * @return
	 */
	public String studentEvaluateResult() {
		viewScore = evaluateService.calculatStudent(courseId);
		//System.out.println("test_3: " + viewScore.compareTo(-1.0f));		
		System.out.println("test_4: " + scorestring);
		if (viewScore == null) {
			scorestring = "该课程还没有学生评价";
		}
		System.out.println("test_4: " + scorestring);
		if (scorestring != null) {
			scorestring = viewScore.toString() + "分";
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 专家课程评价结果
	 * 
	 * @return
	 */
	public String expertEvaluateResult() {
		evaluationList = evaluateService.findEvaluationByCourseId(courseId);
		System.out.println("test_1: " + evaluationList.size());
		if (evaluationList == null) {
			return ERROR;
		} else
			return SUCCESS;
	}	

	/**
	 * 专家课程评价内容
	 * 
	 * @return
	 */
	public String enterEvaluation() {
		evaluation = evaluateService.findById(evaluationId);
		if (evaluation == null) {
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * 课程评价
	 * 
	 * @return
	 */
	public String studentEvaluate() {
		// student = (Student) ActionSession.getSession().get(STUDENT);
		// System.out.println("test_1: "+student.getId());
		// studentCourse=evaluateService.findStudentCourseByStudentId(student.
		// getId());
		studentCourse = evaluateService.findStudentCourseByStudentId(1);
		System.out.println("test_2: " + studentCourse.getId());
		studentCourse.setScore(score);
		boolean result = evaluateService.updateStudentCourse(studentCourse);
		System.out.println("test_3: " + result);
		if (result) {
			return SUCCESS;
		} else
			return ERROR;
	}

	public String expertEvaluate() {

		// course=evaluateService.findCourseById(courseId);
		// System.out.println("test_1: "+course.getName());
		//content=content.substring(3, content.length()-4);
		// evaluation.setCompany(company);
		// evaluation.setContent(content);
		// evaluation.setEmail(email);
		// evaluation.setName(name);
		// evaluation.setPhone(phone);
		// evaluation.setPosition(position);
		 evaluation.setScore(score);
		// evaluation.setCourse(course);
		// System.out.println("test_2: "+evaluation.getName());
		System.out.println(evaluation.getEmail());
		boolean result = evaluateService.updateEvaluation(evaluation);
		System.out.println("test_3: " + result);
		if (result) {
			return SUCCESS;
		} else
			return ERROR;
	}

	public String eDetailEvaluate() {
		evaluation = evaluateService.findById(1);
		return SUCCESS;
	
	
	}
	public String sDetailEvaluate() {
		return SUCCESS;
	}
	
	/**
	 * 获得该课程评价列表（教师）
	 * @return
	 */
	public String getEvaluationListByCourse() {
		evaluationList = evaluateService.findEvaluationByCourseId(super.getCourse().getId());
		return SUCCESS;
	}
	
	/**
	 * 获取课程评价结果（教师）
	 * 
	 * @return
	 */
	public String getEvaluationResult(){
		
		Object[] evaluationResult = evaluateService.getEvaluationCalculateResult(super.getCourse().getId());
		Object[] scResult = evaluateService.getStudentCourseCalculateResult(super.getCourse().getId());
		stuCount = scResult[0];
		expertCount = evaluationResult[0];
		if(scResult[1]!=null)
			stuAvgScore = scResult[1];
		if(evaluationResult[1]!=null)
			expertAvgScore = evaluationResult[1];
		return SUCCESS;
	}
	
	/**
	 * 邀请新的专家进行评价（教师)
	 * @return
	 */
	public String addEvaluation(){
		if(evaluateService.addEvaluation(evaluation, super.getCourse()))
			return SUCCESS;
		else {
			addActionError("邀请专家时发生错误，请重新操作！");
			return ERROR;
		}		
	}

	public String getEvaluationDetail(){
		evaluation = evaluateService.findById(evaluationId);
		return SUCCESS;
	}

	public void setEvaluateService(IEvaluateService evaluateService) {
		this.evaluateService = evaluateService;
	}

	public IEvaluateService getEvaluateService() {
		return evaluateService;
	}

	public StudentCourse getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(StudentCourse studentCourse) {
		this.studentCourse = studentCourse;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public List<Evaluation> getEvaluationList() {
		return evaluationList;
	}

	public void setEvaluationList(List<Evaluation> evaluationList) {
		this.evaluationList = evaluationList;
	}

	public int getEvaluationId() {
		return evaluationId;
	}

	public void setEvaluationId(int evaluationId) {
		this.evaluationId = evaluationId;
	}

	public String getScorestring() {
		return scorestring;
	}

	public void setScorestring(String scorestring) {
		this.scorestring = scorestring;
	}

	public Object getStuAvgScore() {
		return stuAvgScore;
	}

	public void setStuAvgScore(Object stuAvgScore) {
		this.stuAvgScore = stuAvgScore;
	}

	public Object getExpertAvgScore() {
		return expertAvgScore;
	}

	public void setExpertAvgScore(Object expertAvgScore) {
		this.expertAvgScore = expertAvgScore;
	}

	public Object getStuCount() {
		return stuCount;
	}

	public void setStuCount(Object stuCount) {
		this.stuCount = stuCount;
	}

	public Object getExpertCount() {
		return expertCount;
	}

	public void setExpertCount(Object expertCount) {
		this.expertCount = expertCount;
	}

	public void setViewScore(Object viewScore) {
		this.viewScore = viewScore;
	}

	public Object getViewScore() {
		return viewScore;
	}

}