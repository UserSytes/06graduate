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

/**
 * �������۵���
 * 
 * @author �Ժ���
 * @author ������
 * @author ������
 * 
 */
public class EvaluationAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4926852401033424156L;
	private IEvaluateService evaluateService;// ���۹������Ľӿ�
	private ICourseService courseService;// �γ̹������Ľӿ�
	private StudentCourse studentCourse;// ѧ���������Ľӿ�
	private Float score;// ���۷���
	private Object viewScore;// ���۷���
	private String scorestring;// ���۽��
	private Student student;// ѧ��
	private Evaluation evaluation;// ����
	private String content;// ��������
	private Course course;// �γ�
	private int courseId;// �γ�ID
	private int evaluationId;// ����ID
	private Object stuAvgScore = 0;// ѧ������ƽ������
	private Object expertAvgScore = 0;// ר������ƽ������
	private Object stuCount;// ѧ����Ŀ
	private Object expertCount;// ר����Ŀ
	private Object teaAvgScore = 0;// ��ʦ���۷���
	private Object teaCount;// ��ʦ��Ŀ
	private List<Evaluation> evaluationList;// �����б�
	private Teacher teacher;// ��ʦ
	private UserInfo userInfo;// �û���Ϣ
	private int flag;// ��־
	private ILoginService loginService;// ��½�������Ľӿ�
	private String userName, password;// �û���������
	private boolean result;// ���

	private List<Course> courseList;// �γ��б�
	private List<String> courseIds;// �γ�ID
	private List<CourseEvaluate> courseEvaluateList = new ArrayList<CourseEvaluate>();// �γ������б�

	/**
	 * ������ҳ���½
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String loginFromEvaluation() {
		course = super.getCourse();
		if (getFlag() == 0) {
			evaluation = getLoginService().expertLogin(userName, getPassword(),
					0);
			if (null == evaluation) {
				addActionError("�û�������������뷵�����ԣ�");
				return ERROR;
			} else if (!evaluation.getCourse().getId().equals(course.getId())) {
				addActionError("�Բ��𣬸�ר���ʺŲ������ڸÿγ̣��뷵�����ԣ�");
				return ERROR;
			} else {
				super.getSession().remove(EVALUATION);
				super.getSession().put(EVALUATION, evaluation);
				getExpertAverage(evaluation.getCourse().getId());
				score = evaluation.getScore();
				if (score == null) {
					return "expert";
				} else {
					scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�" + score.intValue()
							+ "��";
					return "exsuccess";
				}
			}
		} else if (getFlag() == 1) {
			evaluation = getLoginService().expertLogin(userName, getPassword(),
					1);
			if (null == evaluation) {
				addActionError("�û�������������뷵�����ԣ�");
				return ERROR;
			} else if (!evaluation.getCourse().getId().equals(course.getId())) {
				addActionError("�Բ��𣬸�ͬ���ʺŲ������ڸÿγ̣��뷵�����ԣ�");
				return ERROR;
			} else {
				super.getSession().remove(EVALUATION);
				super.getSession().put(EVALUATION, evaluation);
				getTeaAverage(evaluation.getCourse().getId());
				score = evaluation.getScore();
				if (score == null) {
					return "teacher";
				} else {
					scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�" + score.intValue()
							+ "��";
					return "tesuccess";
				}
			}
		} else {
			student = getLoginService().studentLogin(userName, getPassword());
			if (null == student) {
				addActionError("�û�������������뷵�����ԣ�");
				return ERROR;
			} else {
				List<StudentCourse> scList = evaluateService
						.findByStudentAndCourse(course, student);
				if (scList.size() == 0) {
					addActionError("������¼���ʺŲ��Ǹÿγ̵�ѧ�����޷��������ۣ�");
					return ERROR;
				}
				userInfo = student.getUserInfo();
				super.getSession().put(STUDENT, student);
				super.getSession().put(USERINFO, student.getUserInfo());
				getStuAverage(course.getId());
				score = scList.get(0).getScore();
				if (score == null) {
					return "student";
				} else {
					scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�" + score.intValue()
							+ "��";
					return SUCCESS;
				}
			}
		}
	}

	/**
	 * ר�ҿγ����۽��
	 * 
	 * @return
	 */
	public String expertEvaluateResult() {
		course = super.getCourse();
		evaluationList = evaluateService.findByCourseAndSortAndStatus(course,
				0, 1);
		return SUCCESS;
	}

	/**
	 * ͬ�н�ʦ�γ����۽��
	 * 
	 * @return
	 */
	public String teacherEvaluateResult() {
		course = super.getCourse();
		evaluationList = evaluateService.findByCourseAndSortAndStatus(course,
				1, 1);
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
		return SUCCESS;
	}

	/**
	 * ѧ���γ�����
	 * 
	 * @return
	 */
	public String studentEvaluate() {
		student = super.getStudent();
		course = super.getCourse();
		studentCourse = (StudentCourse) evaluateService.findByStudentAndCourse(course, student)
				.get(0);
		studentCourse.setScore(score);
		result = evaluateService.updateStudentCourse(studentCourse);
		if (result) {
			scorestring = "���۳ɹ�����������ǣ�" + score.intValue() + "��";
			getStuAverage(course.getId());
			return SUCCESS;
		} else {
			addActionError("����ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ר�ҿγ�����
	 * 
	 * @return
	 */
	public String expertEvaluate() {
		course = super.getCourse();
		score = evaluation.getScore();
		evaluation.setStatus(1);
		result = evaluateService.updateEvaluation(evaluation);
		if (result) {
			scorestring = "���۳ɹ�����������ǣ�" + score.intValue() + "��";
			getExpertAverage(course.getId());
			return SUCCESS;
		} else {
			addActionError("����ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ��ʦ�γ�����
	 * 
	 * @return
	 */
	public String teacherEvaluate() {
		teacher = super.getTeacher();
		course = super.getCourse();
		score = evaluation.getScore();
		evaluation.setStatus(1);
		result = evaluateService.updateEvaluation(evaluation);
		if (result) {
			scorestring = "���۳ɹ�����������ǣ�" + score.intValue() + "��";
			getTeaAverage(course.getId());
			return SUCCESS;
		} else {
			addActionError("����ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ר�ҿγ����ۣ��ݸ壩
	 * 
	 * @return
	 */
	public String expertEvaluateDraft() {
		course = super.getCourse();
		score = evaluation.getScore();
		evaluation.setStatus(0);
		result = evaluateService.updateEvaluation(evaluation);
		if (result) {
			scorestring = "����ݸ�ɹ���";
			return SUCCESS;
		} else {
			addActionError("����ݸ�ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ��ʦ�γ����ۣ��ݸ壩
	 * 
	 * @return
	 */
	public String teacherEvaluateDraft() {
		teacher = super.getTeacher();
		course = super.getCourse();
		score = evaluation.getScore();
		evaluation.setStatus(0);
		result = evaluateService.updateEvaluation(evaluation);
		if (result) {
			scorestring = "����ݸ�ɹ���";
			return SUCCESS;
		} else {
			addActionError("����ݸ�ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ר�����۽��
	 * 
	 * @return
	 */
	public String reExpertEvaluation() {
		evaluation = evaluateService.findById(evaluationId);
		getExpertAverage(evaluation.getCourse().getId());
		return SUCCESS;
	}

	/**
	 * ��ʦ���۽��
	 * 
	 * @return
	 */
	public String reTeaEvaluation() {
		evaluation = evaluateService.findById(evaluationId);
		getTeaAverage(evaluation.getCourse().getId());
		return SUCCESS;
	}

	/**
	 * ѧ�����۽��
	 * 
	 * @return
	 */
	public String reStuEvaluation() {
		getStuAverage(super.getCourse().getId());
		return SUCCESS;
	}

	/**
	 * ר�ҽ�������
	 * 
	 * @return
	 */
	public String eDetailEvaluate() {
		course = super.getCourse();
		evaluation = (Evaluation) super.getSession().get(EVALUATION);
		if (null == evaluation || evaluation.getSort() == 1) {
			return "evalogin";
		} else if (!evaluation.getCourse().getId().equals(course.getId())) {
			addActionError("�Բ��𣬸�ר���ʺŲ������ڸÿγ̣��뷵�����ԣ�");
			return ERROR;
		} else {
			getExpertAverage(course.getId());
			score = evaluation.getScore();
			if (score == null) {
				return "evluate";
			} else {
				if (evaluation.getStatus() == 1)
					scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�" + score.intValue()
							+ "��";
				else
					scorestring = "��������ݸ壬����һ�ζԸÿγ̵������ǣ�" + score.intValue()
							+ "��";
				return SUCCESS;
			}
		}
	}

	/**
	 * ��ʦ��������
	 * 
	 * @return
	 */
	public String tDetailEvaluate() {
		course = super.getCourse();
		evaluation = (Evaluation) super.getSession().get(EVALUATION);
		if (null == evaluation || evaluation.getSort() == 0) {
			return "evalogin";
		} else if (!evaluation.getCourse().getId().equals(course.getId())) {
			addActionError("�Բ��𣬸�ͬ���ʺŲ������ڸÿγ̣��뷵�����ԣ�");
			return ERROR;
		} else {
			getTeaAverage(course.getId());
			score = evaluation.getScore();
			if (score == null) {
				return "evluate";
			} else {
				if (evaluation.getStatus() == 1)
					scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�" + score.intValue()
							+ "��";
				else
					scorestring = "��������ݸ壬����һ�ζԸÿγ̵������ǣ�" + score.intValue()
							+ "��";
				return SUCCESS;
			}
		}
	}

	/**
	 * ѧ����������
	 * 
	 * @return
	 */
	public String sDetailEvaluate() {
		student = super.getStudent();
		if (null == student) {
			return "evalogin";
		} else {
			course = super.getCourse();
			List<StudentCourse> scList = evaluateService
					.findByStudentAndCourse(course, student);
			if (scList.size() == 0) {
				addActionError("������¼���ʺŲ��Ǹÿγ̵�ѧ�����޷��������ۣ�");
				return ERROR;
			}
			getStuAverage(course.getId());
			score = scList.get(0).getScore();
			if (score == null) {
				return "evluate";
			} else {
				scorestring = "���Ѿ����۹�������һ�ζԸÿγ̵������ǣ�" + score.intValue() + "��";
				return SUCCESS;
			}
		}
	}

	/**
	 * ��øÿγ�ר�������б���ʦ��
	 * 
	 * @return
	 */
	public String getEvaluationListByCourse() {
		evaluationList = evaluateService.findByCourseAndSort(super.getCourse(),
				0);
		return SUCCESS;
	}

	/**
	 * ��øÿγ�ͬ�������б���ʦ��
	 * 
	 * @return
	 */
	public String getEvaTeacherListByCourse() {
		evaluationList = evaluateService.findByCourseAndSort(super.getCourse(),
				1);
		return SUCCESS;
	}

	/**
	 * ��ȡ�γ����۽������ʦ��
	 * 
	 * @return
	 */
	public String getEvaluationResult() {
		course = super.getCourse();
		getExpertAverage(course.getId());
		getTeaAverage(course.getId());
		getStuAverage(course.getId());
		return SUCCESS;
	}

	/**
	 * ���ר������ƽ������
	 * 
	 * @param courseId
	 */
	public void getExpertAverage(int courseId) {
		Object[] evaluationResult = evaluateService
				.getEvaluationCalculateResult(courseId, 0);
		expertCount = evaluationResult[0];
		if (evaluationResult[1] != null)
			expertAvgScore = evaluationResult[1];
	}

	/**
	 * ��ý�ʦ����ƽ������
	 * 
	 * @param courseId
	 */
	public void getTeaAverage(int courseId) {
		Object[] teaResult = evaluateService.getEvaluationCalculateResult(
				courseId, 1);
		teaCount = teaResult[0];
		if (teaResult[1] != null)
			teaAvgScore = teaResult[1];
	}

	/**
	 * ���ѧ������ƽ������
	 * 
	 * @param courseId
	 */
	public void getStuAverage(int courseId) {
		Object[] scResult = evaluateService
				.getStudentCourseCalculateResult(courseId);
		stuCount = scResult[0];
		if (scResult[1] != null)
			stuAvgScore = scResult[1];
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
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
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
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String showEvaluateCourses() {
		courseList = new ArrayList<Course>();
		for (int i = 0; i < courseIds.size(); i++) {
			Course course = courseService.getCourseById(Integer
					.parseInt(courseIds.get(i)));
			courseList.add(course);
		}
		if (courseList.size() == 0) {
			addActionError("��δѡ���κογ̣�");
			return ERROR;
		} else {
			courseEvaluateList = evaluateService
					.getEvaluateByCourseList(courseList);
			super.getSession().put("data", courseEvaluateList);
			return SUCCESS;
		}
	}

	/**
	 * ���ɿγ�����ͼ
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String genrEvaluateChart() {
		try {
			Administrator admin = (Administrator) super.getSession().get(ADMIN);
			School school = admin.getSchool();
			Date currentDate = new Date();
			super.getSession().put("title", school.getName() + "�γ����۶Ա�����ͼ");
			super.getSession().put("abscissa", "�γ�");
			super.getSession().put("ordinate", "ƽ����");

			return SUCCESS;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * ɾ���γ�����
	 * 
	 * @return
	 */
	public String deleteEvaluation() {
		Evaluation eva = evaluateService.findById(evaluationId);
		if (evaluateService.deleteEvaluation(eva))
			return SUCCESS;
		else {
			addActionError("ɾ���γ�����ʧ�ܣ������²�����");
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