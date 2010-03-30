package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IEvaluateService;
import cn.edu.xmu.course.service.ILoginService;
import cn.edu.xmu.course.service.ILoginService;

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
	private Object stuAvgScore = 0;
	private Object expertAvgScore = 0;
	private Object stuCount;
	private Object expertCount;
	private List<Evaluation> evaluationList;
	private Teacher teacher;
	private UserInfo userInfo;
	private int flag;
	private ILoginService loginService;
	private String userName, password;
	private String number;
	private boolean result;

	public String loginFromEvaluation() {
		course = super.getCourse();
		if (getFlag() == 0) {
			evaluation = getLoginService().expertLogin(userName, getPassword());
			System.out.println(userName);
			if (null == evaluation) {
				addActionError("�û�������������뷵�����ԣ�");
				return ERROR;
			} else {
				//addActionMessage("�װ���" + evaluation.getName() + "����ӭ�㣡");
				System.out.println(evaluation.getPassword());
				super.getSession().put(EVALUATION, evaluation);
				// super.getSession().put(USERINFO, teacher.getUserInfo());
				return "expert";
			}
		} else if (getFlag() == 1) {
			teacher = getLoginService().teacherLogin(userName, getPassword());
			System.out.println(userName);
			if (null == teacher) {
				addActionError("�û�������������뷵�����ԣ�");
				return ERROR;
			} else {
				userInfo = teacher.getUserInfo();
				System.out.println("���ڵ�½����" + teacher.getTeacherNo());
				//addActionMessage("�װ���" + getUserInfo().getName() + "����ӭ�㣡");
				System.out.println(teacher.getPassword());
				super.getSession().put(TEACHER, teacher);
				super.getSession().put(USERINFO, teacher.getUserInfo());
	
				System.out.println(course.getName());
				evaluation=evaluateService.findByCourseAndUsernameAndSort(course, teacher.getTeacherNo(),1).get(0);
				score = evaluation.getScore();
				if (score == null) {
					return "teacher";
				} else {
					if(number==null)
					{
						int i = score.toString().indexOf(".");
						scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�"
								+ score.toString().substring(0, i) + "��";
						System.out.println(scorestring);
						return "tesuccess";
					}
					else
					{
						return "teacher";
					}
					
				}
			}
		} else {
			student = getLoginService().studentLogin(userName, getPassword());
			System.out.println(userName);
			if (null == student) {
				addActionError("�û�������������뷵�����ԣ�");
				return ERROR;
			} else {
				userInfo = student.getUserInfo();
				System.out.println("���ڵ�½����" + student.getStudentNo());
				//addActionMessage("�װ���" + getUserInfo().getName() + "����ӭ�㣡");
				System.out.println("test1: " + student.getPassword());
				super.getSession().put(STUDENT, student);
				super.getSession().put(USERINFO, student.getUserInfo());

				studentCourse = evaluateService.findByStudentAndCourse(course,
						student).get(0);
				score = studentCourse.getScore();
				if (score == null) {
					return "student";
					
				} else {
					if(number==null)
					{
						int i = score.toString().indexOf(".");
						scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�"
								+ score.toString().substring(0, i) + "��";
						System.out.println(scorestring);
						return SUCCESS;
					}
					else
					{
						return "student";
					}
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
		System.out.println("test_4: " + viewScore);
		if (viewScore == null) {
			scorestring = "�ÿγ̻�û��ѧ������";
		}
		if (viewScore != null) {
			
			int i = viewScore.toString().lastIndexOf(".");
			scorestring = viewScore.toString().substring(0, i) + "��";
			System.out.println("test_4: " + scorestring);
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
		evaluationList = evaluateService.findEvaluationByCourseId(course
				.getId());
		System.out.println("test_ר�����۽��1: " + evaluationList.size());
		for (int i = 0; i < evaluationList.size(); i++) {
			if (evaluationList.get(i).getSort() == 1)
				evaluationList.remove(i);
		}
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
		evaluationList = evaluateService.findEvaluationByCourseId(course
				.getId());
		System.out.println("test_��ʦ���۽��1: " + evaluationList.size());
		for (int i = 0; i < evaluationList.size(); i++) {
			System.out.println("test_��ʦ���۽��2: "
					+ evaluationList.get(i).getName());
			if (evaluationList.get(i).getSort() == 0) {
				evaluationList.remove(i);
				i = i - 1;
				System.out.println("test_��ʦ���۽��3: " + evaluationList.size());
			}
		}
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
		int i = score.toString().indexOf(".");
		int j = score.toString().length();
		if (score < 0.0f || score > 100.0f
				|| !score.toString().substring(i + 1, j).equals("0")) {
			addActionMessage("������0��100�ֵ�����");
			return ERROR;
		}

		studentCourse = evaluateService.findByStudentAndCourse(course, student)
				.get(0);
		studentCourse.setScore(score);
		result = evaluateService.updateStudentCourse(studentCourse);

		if (result) {
			scorestring = "���۳ɹ�����������ǣ�" + score.toString().substring(0, i)
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
		score=evaluation.getScore();
		int i = score.toString().indexOf(".");
		int j = score.toString().length();
		if (score < 0.0f || score > 100.0f
				|| !score.toString().substring(i + 1, j).equals("0")) {
			addActionMessage("������0��100�ֵ�����");
			return ERROR;
		}
		result = evaluateService.updateEvaluation(evaluation);
		System.out.println("test_3: " + result);
		if (result) {
			scorestring = "���۳ɹ�����������ǣ�" + score.toString().substring(0, i)
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
		int i = score.toString().indexOf(".");
		int j = score.toString().length();
		if (score < 0.0f || score > 100.0f
				|| !score.toString().substring(i + 1, j).equals("0")) {
			addActionMessage("������0��100�ֵ�����");
			return ERROR;
		}
		result = evaluateService.updateEvaluation(evaluation);
		System.out.println(evaluation.getEmail());
		System.out.println("test_4: " + result);

		if (result) {
			scorestring = "���۳ɹ�����������ǣ�" + score.toString().substring(0, i)
			+ "��";
			return SUCCESS;
		} else
			return ERROR;
	}

	public String eDetailEvaluate() {
		// evaluation = evaluateService.findById(1);
		evaluation = (Evaluation) super.getSession().get(EVALUATION);
		if (null == evaluation) {
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
					int i = score.toString().indexOf(".");
					scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�"
							+ score.toString().substring(0, i) + "��";
					System.out.println(scorestring);
					return SUCCESS;
				}
				else
				{
					return "evluate";
				}
				
			}

		}

	}

	public String tDetailEvaluate() {
		// evaluation = evaluateService.findById(1);
		teacher = (Teacher) super.getSession().get(TEACHER);
		if (null == student && null == teacher) {
			addActionError("����δ��¼�����ȵ�¼��");
			return "login";
		} else {
			userInfo = teacher.getUserInfo();
			course = super.getCourse();
			
			evaluation=evaluateService.findByCourseAndUsernameAndSort(course, teacher.getTeacherNo(),1).get(0);
			score = evaluation.getScore();
			if (score == null) {
				return "evluate";
			} else {
				if(number==null)
				{
					int i = score.toString().indexOf(".");
					scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�"
							+ score.toString().substring(0, i) + "��";
					System.out.println(scorestring);
					return SUCCESS;
				}
				else
				{
					return "evluate";
				}
				
			}

		}
	}

	public String sDetailEvaluate() {
		student = (Student) super.getSession().get(STUDENT);
		if (null == student && null == teacher) {
			addActionError("����δ��¼�����ȵ�¼��");
			return "login";
		} else {
			userInfo = student.getUserInfo();
			course = super.getCourse();
			studentCourse = evaluateService.findByStudentAndCourse(course,
					student).get(0);
			score = studentCourse.getScore();
			if (score == null) {
				return "evluate";
				
			} else {
				if(number==null)
				{
					int i = score.toString().indexOf(".");
					scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�"
							+ score.toString().substring(0, i) + "��";
					System.out.println(scorestring);
					return SUCCESS;
				}
				else
				{
					System.out.println("test-sDetailEvaluate"+number);
					return "evluate";
				}
			}

		}
	}

	/**
	 * ��øÿγ������б���ʦ��
	 * 
	 * @return
	 */
	public String getEvaluationListByCourse() {
		evaluationList = evaluateService.findEvaluationByCourseId(super
				.getCourse().getId());
		return SUCCESS;
	}

	/**
	 * ��ȡ�γ����۽������ʦ��
	 * 
	 * @return
	 */
	public String getEvaluationResult() {

		Object[] evaluationResult = evaluateService
				.getEvaluationCalculateResult(super.getCourse().getId());
		Object[] scResult = evaluateService
				.getStudentCourseCalculateResult(super.getCourse().getId());
		stuCount = scResult[0];
		expertCount = evaluationResult[0];
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

}