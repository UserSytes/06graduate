package cn.edu.xmu.course.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.commons.CourseEvaluate;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.IEvaluateService;
import cn.edu.xmu.course.service.ILoginService;

public class EvaluationAction extends BaseAction {

	private IEvaluateService evaluateService;
	private ICourseService courseService;
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
	private Object stuAvgScore = 0;
	private Object expertAvgScore = 0;
	private Object stuCount;
	private Object expertCount;
	private Object teaAvgScore=0;
	private Object teaCount;
	private List<Evaluation> evaluationList;
	private Teacher teacher;
	private UserInfo userInfo;
	private int flag;
	private ILoginService loginService;
	private String userName, password;
	private String number;
	private boolean result;
	
	private List<Course> courseList;
	private List<String> courseIds;
	private List<CourseEvaluate> courseEvaluateList = new ArrayList<CourseEvaluate>() ;

	public String loginFromEvaluation() {
		course = super.getCourse();
		if (getFlag() == 0) {
			evaluation = getLoginService().expertLogin(userName, getPassword(),0);
			System.out.println(userName);
			if (null == evaluation) {
				addActionError("�û�������������뷵�����ԣ�");
				return ERROR;
			} else {
				System.out.println(evaluation.getPassword());
				super.getSession().put(EVALUATION, evaluation);
				return "expert";
			}
		} else if (getFlag() == 1) {
			evaluation = getLoginService().expertLogin(userName, getPassword(),1);
			System.out.println(userName);
			if (null == evaluation) {
				addActionError("�û�������������뷵�����ԣ�");
				return ERROR;
			} else {
				System.out.println(evaluation.getPassword());
				super.getSession().put(EVALUATION, evaluation);
				score = evaluation.getScore();
				if (score == null) {
					return "teacher";
				} else {
					if(number==null)
					{
						scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�"+ score.intValue() + "��";
						return "tesuccess";
					}
					else
						return "teacher";				
				}
			}
		} else {
			student = getLoginService().studentLogin(userName, getPassword());
			if (null == student) {
				addActionError("�û�������������뷵�����ԣ�");
				return ERROR;
			} else {
				userInfo = student.getUserInfo();
				super.getSession().put(STUDENT, student);
				super.getSession().put(USERINFO, student.getUserInfo());

				studentCourse = evaluateService.findByStudentAndCourse(course,student).get(0);
				score = studentCourse.getScore();
				if (score == null) {
					return "student";				
				} else {
					if(number==null)
					{
						scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�"+ score.intValue() + "��";
						return SUCCESS;
					}
					else
						return "student";
				}
			}
		}
	}

	/**
	 * ����γ�����
	 * 
	 * @return
	 */

	public String evaluate() {
		course = super.getCourse();
		return SUCCESS;
	}

	/**
	 * ѧ���γ����۽��
	 * 
	 * @return
	 */
	public String studentEvaluateResult() {
		course = super.getCourse();
		viewScore = evaluateService.calculatStudent(1);
		if (viewScore == null) {
			scorestring = "�ÿγ̻�û��ѧ������";
			return SUCCESS;
		}
		if (viewScore != null) {			
			int i = viewScore.toString().lastIndexOf(".");
			scorestring = viewScore.toString().substring(0, i) + "��";
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ר�ҿγ����۽��
	 * 
	 * @return
	 */
	public String expertEvaluateResult() {
		course = super.getCourse();	
		evaluationList=evaluateService.findByCourseAndSortAndStatus(course, 0,1);
		if (evaluationList == null) {
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * ͬ�н�ʦ�γ����۽��
	 * 
	 * @return
	 */
	public String teacherEvaluateResult() {
		course = super.getCourse();	
		evaluationList=evaluateService.findByCourseAndSortAndStatus(course, 1,1);
		if (evaluationList == null) {
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * ר�ҿγ���������
	 * 
	 * @return
	 */
	public String enterEvaluation() {
		course = super.getCourse();
		evaluation = evaluateService.findById(evaluationId);
		if (evaluation == null) {
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * ͬ�н�ʦ�γ���������
	 * 
	 * @return
	 */
	public String enterTeaEvaluation() {
		course = super.getCourse();
		evaluation = evaluateService.findById(evaluationId);
		if (evaluation == null) {
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * ѧ���γ�����
	 * 
	 * @return
	 */
	public String studentEvaluate() {
		student = (Student) super.getSession().get(STUDENT);
		course = super.getCourse();
    	studentCourse = evaluateService.findByStudentAndCourse(course, student).get(0);
		studentCourse.setScore(score);
		result = evaluateService.updateStudentCourse(studentCourse);
		if (result) {
			scorestring = "���۳ɹ�����������ǣ�" + score.intValue()
					+ "��";
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ר�ҿγ�����
	 * 
	 * @return
	 */
	public String expertEvaluate() {
		course=super.getCourse();
		score=evaluation.getScore();
		evaluation.setStatus(1);
		result = evaluateService.updateEvaluation(evaluation);
		if (result) {
			scorestring = "���۳ɹ�����������ǣ�" + score.intValue()
			+ "��";
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��ʦ�γ�����
	 * 
	 * @return
	 */
	public String teacherEvaluate() {
		teacher = super.getTeacher();
		course = super.getCourse();
		score=evaluation.getScore();
		evaluation.setStatus(1);
		result = evaluateService.updateEvaluation(evaluation);
    	if (result) {
			scorestring = "���۳ɹ�����������ǣ�" + score.intValue()
			+ "��";
			return SUCCESS;
		} else
			return ERROR;
	}
	/**
	 * ר�ҿγ����ۣ��ݸ壩
	 * 
	 * @return
	 */
	public String expertEvaluateDraft() {
		course=super.getCourse();
		score=evaluation.getScore();
		evaluation.setStatus(0);
		result = evaluateService.updateEvaluation(evaluation);
		if (result) {
			scorestring = "����ݸ�ɹ���";
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��ʦ�γ����ۣ��ݸ壩
	 * 
	 * @return
	 */
	public String teacherEvaluateDraft() {
		teacher = super.getTeacher();
		course = super.getCourse();
		score=evaluation.getScore();
		evaluation.setStatus(0);
		result = evaluateService.updateEvaluation(evaluation);
    	if (result) {
			scorestring = "����ݸ�ɹ���";
			return SUCCESS;
		} else
			return ERROR;
	}
	
	public String eDetailEvaluate() {
		course=super.getCourse();
		// evaluation = evaluateService.findById(1);
		evaluation = (Evaluation) super.getSession().get(EVALUATION);
		if (null == evaluation||evaluation.getSort()==1) {
			addActionError("����δ��¼�����ȵ�¼��");
			return "login";
		} else {
			course = super.getCourse();
			score = evaluation.getScore();
			if (score == null) {
				return "evluate";
			} else {
				if(number==null)
				{
					scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�"
						+ score.intValue() + "��";
					return SUCCESS;
				}
				else
					return "evluate";			
			}
		}
	}

	public String tDetailEvaluate() {
		course=super.getCourse();
		evaluation = (Evaluation) super.getSession().get(EVALUATION);
		if (null == evaluation||evaluation.getSort()==0) {
			addActionError("����δ��¼�����ȵ�¼��");
			return "login";
		} else {
			course = super.getCourse();		
           score = evaluation.getScore();
			if (score == null) {
				return "evluate";
			} else {
				if(number==null)
				{
					scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�"
						+ score.intValue() + "��";
					return SUCCESS;
				}
				else
					return "evluate";			
			}
		}
	}

	public String sDetailEvaluate() {
		course=super.getCourse();
		student = (Student) super.getSession().get(STUDENT);
		if (null == student && null == teacher) {
			addActionError("����δ��¼�����ȵ�¼��");
			return "login";
		} else {
			userInfo = student.getUserInfo();
			if(course != null){			
				course = courseService.getCourseById(course.getId());
				super.getSession().put(COURSE,course);
			}else{
				course = super.getCourse();
			}

			studentCourse = evaluateService.findByStudentAndCourse(course,
					student).get(0);
			score = studentCourse.getScore();
			if (score == null) {
				return "evluate";			
			} else {
				if(number==null)
				{
					scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�"
						+ score.intValue() + "��";
					return SUCCESS;
				}
				else
					return "evluate";
			}
		}
	}

	/**
	 * ��øÿγ�ר�������б���ʦ��
	 * 
	 * @return
	 */
	public String getEvaluationListByCourse() {
		evaluationList = evaluateService.findByCourseAndSort(super
				.getCourse(),0);
		return SUCCESS;
	}
	
	/**
	 * ��øÿγ�ͬ�������б���ʦ��
	 * 
	 * @return
	 */
	public String getEvaTeacherListByCourse() {
		evaluationList = evaluateService.findByCourseAndSort(super
				.getCourse(),1);
		return SUCCESS;
	}

	/**
	 * ��ȡ�γ����۽������ʦ��
	 * 
	 * @return
	 */
	public String getEvaluationResult() {
		course=super.getCourse();
		Object[] evaluationResult = evaluateService
				.getEvaluationCalculateResult(course.getId(), 0);
		Object[] teaResult = evaluateService
		.getEvaluationCalculateResult(course.getId(), 1);
		Object[] scResult = evaluateService
				.getStudentCourseCalculateResult(course.getId());
		stuCount = scResult[0];
		expertCount = evaluationResult[0];
		teaCount = teaResult[0];
		if(teaResult[1] !=null)
			teaAvgScore = teaResult[1];
		if (scResult[1] != null)
			stuAvgScore = scResult[1];
		if (evaluationResult[1] != null)
			expertAvgScore = evaluationResult[1];
		return SUCCESS;
	}

	/**
	 * �����µ�ר�ҽ������ۣ���ʦ)
	 * 
	 * @return
	 */
	public String addEvaluation() {
		evaluation.setSort(0);
		if (evaluateService.addEvaluation(evaluation, super.getCourse()))
			return SUCCESS;
		else {
			addActionError("����ר��ʱ�������������²�����");
			return ERROR;
		}
	}
	/**
	 * �����µ�ͬ�н������ۣ���ʦ)
	 * 
	 * @return
	 */
	public String addEvaTeacher() {
		evaluation.setSort(1);
		if (evaluateService.addEvaluation(evaluation, super.getCourse()))
			return SUCCESS;
		else {
			addActionError("����ר��ʱ�������������²�����");
			return ERROR;
		}
	}
	
	/**
	 * ��ȡѧԺ�γ��б�
	 * 
	 * @return
	 */
	public String findCourse() {
		Administrator admin = (Administrator) super.getSession().get(
				ADMIN);
		School school = admin.getSchool();
		courseList = courseService.findBySchool(school);
		if (courseList.size() == 0) {
			addActionError("���޿γ̣�");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}
	
	/**
	 * ��ȡѡ��Ŀγ�
	 * @return
	 */
	public String showEvaluateCourses() {
		courseList = new ArrayList<Course>();
		for(int i = 0; i< courseIds.size(); i++){
			Course course = courseService.getCourseById( Integer.parseInt(courseIds.get(i)) );
			courseList.add(course);
		}
		if(courseList.size()==0){
			addActionError("��δѡ���κογ̣�");
			return ERROR;
		}else{
			courseEvaluateList = evaluateService.getEvaluateByCourseList(courseList);
			super.getSession().put("data", courseEvaluateList);
			return SUCCESS;
		}
	}
	
	/**
	 * ���ɿγ�����ͼ
	 * @return
	 */
	public String genrEvaluateChart() {
		try {
			Administrator admin = (Administrator) super.getSession().get(
					ADMIN);
			School school = admin.getSchool();
			Date currentDate = new Date();
			super.getSession().put(
					"title", school.getName()+ "�γ����۶Ա�����ͼ");
			super.getSession().put("abscissa", "�γ�");
			super.getSession().put("ordinate", "ƽ����");

			return SUCCESS;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String getEvaluationDetail() {
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public List<String> getCourseIds() {
		return courseIds;
	}

	public void setCourseIds(List<String> courseIds) {
		this.courseIds = courseIds;
	}

	public List<CourseEvaluate> getCourseEvaluateList() {
		return courseEvaluateList;
	}

	public void setCourseEvaluateList(List<CourseEvaluate> courseEvaluateList) {
		this.courseEvaluateList = courseEvaluateList;
	}

	public void setTeaCount(Object teaCount) {
		this.teaCount = teaCount;
	}

	public Object getTeaCount() {
		return teaCount;
	}

	public void setTeaAvgScore(Object teaAvgScore) {
		this.teaAvgScore = teaAvgScore;
	}

	public Object getTeaAvgScore() {
		return teaAvgScore;
	}

}