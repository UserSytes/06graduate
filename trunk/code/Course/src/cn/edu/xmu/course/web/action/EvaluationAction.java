package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.dao.EvaluationDAO;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.service.IEvaluateService;



public class EvaluationAction extends BaseAction{
	private IEvaluateService  evaluateService;
	private StudentCourse  studentCourse;
	private Float score;
	private String scorestring;
	private Student student;
	private Evaluation evaluation;
	private String name;
	private String company;
	private String position;
	private Long phone;
	private String email;
	private String content;
	private Course course;
	private int courseId;
	private int evaluationId;
	private List<Evaluation> evaluationList;

	/**
	 * 进入课程评价
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String evaluate(){
			return SUCCESS;
	}
	/**
	 * 学生课程评价结果
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String studentEvaluateResult(){
		score=evaluateService.calculatStudent(courseId);
		System.out.println("test_3: "+score.compareTo(-1.0f));
		scorestring=score.toString()+"分";
		System.out.println("test_4: "+scorestring);
		if(score.compareTo(-1.0f)==0){
			scorestring="该课程还没有学生评价";
		}
		System.out.println("test_4: "+scorestring);
		if(scorestring!=null){
			return SUCCESS;
		}else
			return ERROR;
	}
	/**
	 * 专家课程评价结果
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String expertEvaluateResult(){
		evaluationList=evaluateService.findEvaluationByCourseId(courseId);
		System.out.println("test_1: "+evaluationList.size());
		if (evaluationList == null) {
			return ERROR;
		} else
			return SUCCESS;
	}
	/**
	 * 专家课程评价内容
	 * @return
	 */
	 public String enterEvaluation(){
		 evaluation=evaluateService.findById(evaluationId);
			if (evaluation == null) {
				return ERROR;
			} else
				return SUCCESS;
	    }
	/**
	 * 课程评价
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String studentEvaluate(){
		//student =  (Student) ActionSession.getSession().get(STUDENT);
		//System.out.println("test_1: "+student.getId());
		//studentCourse=evaluateService.findStudentCourseByStudentId(student.getId());
		studentCourse=evaluateService.findStudentCourseByStudentId(1);
		System.out.println("test_2: "+studentCourse.getId());
		studentCourse.setScore(score);
		content=content.substring(3, content.length()-4);
		studentCourse.setContent(content);
		boolean result = evaluateService.updateStudentCourse(studentCourse);
		System.out.println("test_3: "+result);
		if(result){
			return SUCCESS;
		}else
			return ERROR;
	}
	
	public String expertEvaluate(){
		course=evaluateService.findCourseById(courseId);
		System.out.println("test_1: "+course.getName());
		content=content.substring(3, content.length()-4);
		evaluation.setCompany(company);
		evaluation.setContent(content);
		evaluation.setEmail(email);
		evaluation.setName(name);
		evaluation.setPhone(phone);
		evaluation.setPosition(position);
		evaluation.setScore(score);
		evaluation.setCourse(course);
		System.out.println("test_2: "+evaluation.getName());
		boolean result = evaluateService.updateEvaluation(evaluation);
		System.out.println("test_3: "+result);
		if(result){
			return SUCCESS;
		}else
			return ERROR;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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



	
	
}