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
				addActionError("用户名获密码错误！请返回重试！");
				return ERROR;
			} else {
				//addActionMessage("亲爱的" + evaluation.getName() + "，欢迎你！");
				System.out.println(evaluation.getPassword());
				super.getSession().put(EVALUATION, evaluation);
				// super.getSession().put(USERINFO, teacher.getUserInfo());
				return "expert";
			}
		} else if (getFlag() == 1) {
			teacher = getLoginService().teacherLogin(userName, getPassword());
			System.out.println(userName);
			if (null == teacher) {
				addActionError("用户名获密码错误！请返回重试！");
				return ERROR;
			} else {
				userInfo = teacher.getUserInfo();
				System.out.println("正在登陆的是" + teacher.getTeacherNo());
				//addActionMessage("亲爱的" + getUserInfo().getName() + "，欢迎你！");
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
						scorestring = "您已经评价过，你上一次对该课程的评分是："
								+ score.toString().substring(0, i) + "分";
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
				addActionError("用户名获密码错误！请返回重试！");
				return ERROR;
			} else {
				userInfo = student.getUserInfo();
				System.out.println("正在登陆的是" + student.getStudentNo());
				//addActionMessage("亲爱的" + getUserInfo().getName() + "，欢迎你！");
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
						scorestring = "您已经评价过，你上一次对该课程的评分是："
								+ score.toString().substring(0, i) + "分";
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
	 * 进入课程评价
	 * 
	 * @return
	 */

	public String evaluate() {
		course = super.getCourse();
		return SUCCESS;
	}

	/**
	 * 学生课程评价结果
	 * 
	 * @return
	 */
	public String studentEvaluateResult() {
		course = super.getCourse();
		viewScore = evaluateService.calculatStudent(1);
		System.out.println("test_4: " + viewScore);
		if (viewScore == null) {
			scorestring = "该课程还没有学生评价";
		}
		if (viewScore != null) {
			
			int i = viewScore.toString().lastIndexOf(".");
			scorestring = viewScore.toString().substring(0, i) + "分";
			System.out.println("test_4: " + scorestring);
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
		course = super.getCourse();
		evaluationList = evaluateService.findEvaluationByCourseId(course
				.getId());
		System.out.println("test_专家评价结果1: " + evaluationList.size());
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
	 * 同行教师课程评价结果
	 * 
	 * @return
	 */
	public String teacherEvaluateResult() {
		course = super.getCourse();
		evaluationList = evaluateService.findEvaluationByCourseId(course
				.getId());
		System.out.println("test_教师评价结果1: " + evaluationList.size());
		for (int i = 0; i < evaluationList.size(); i++) {
			System.out.println("test_教师评价结果2: "
					+ evaluationList.get(i).getName());
			if (evaluationList.get(i).getSort() == 0) {
				evaluationList.remove(i);
				i = i - 1;
				System.out.println("test_教师评价结果3: " + evaluationList.size());
			}
		}
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
	 * 同行教师课程评价内容
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
	 * 学生课程评价
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
			addActionMessage("请输入0到100分的整数");
			return ERROR;
		}

		studentCourse = evaluateService.findByStudentAndCourse(course, student)
				.get(0);
		studentCourse.setScore(score);
		result = evaluateService.updateStudentCourse(studentCourse);

		if (result) {
			scorestring = "评价成功，你的评分是：" + score.toString().substring(0, i)
					+ "分";
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 专家课程评价
	 * 
	 * @return
	 */
	public String expertEvaluate() {
		score=evaluation.getScore();
		int i = score.toString().indexOf(".");
		int j = score.toString().length();
		if (score < 0.0f || score > 100.0f
				|| !score.toString().substring(i + 1, j).equals("0")) {
			addActionMessage("请输入0到100分的整数");
			return ERROR;
		}
		result = evaluateService.updateEvaluation(evaluation);
		System.out.println("test_3: " + result);
		if (result) {
			scorestring = "评价成功，你的评分是：" + score.toString().substring(0, i)
			+ "分";
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 教师课程评价
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
			addActionMessage("请输入0到100分的整数");
			return ERROR;
		}
		result = evaluateService.updateEvaluation(evaluation);
		System.out.println(evaluation.getEmail());
		System.out.println("test_4: " + result);

		if (result) {
			scorestring = "评价成功，你的评分是：" + score.toString().substring(0, i)
			+ "分";
			return SUCCESS;
		} else
			return ERROR;
	}

	public String eDetailEvaluate() {
		// evaluation = evaluateService.findById(1);
		evaluation = (Evaluation) super.getSession().get(EVALUATION);
		if (null == evaluation) {
			addActionError("您还未登录，请先登录！");
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
					scorestring = "您已经评价过，你上一次对该课程的评分是："
							+ score.toString().substring(0, i) + "分";
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
			addActionError("您还未登录，请先登录！");
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
					scorestring = "您已经评价过，你上一次对该课程的评分是："
							+ score.toString().substring(0, i) + "分";
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
			addActionError("您还未登录，请先登录！");
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
					scorestring = "您已经评价过，你上一次对该课程的评分是："
							+ score.toString().substring(0, i) + "分";
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
	 * 获得该课程评价列表（教师）
	 * 
	 * @return
	 */
	public String getEvaluationListByCourse() {
		evaluationList = evaluateService.findEvaluationByCourseId(super
				.getCourse().getId());
		return SUCCESS;
	}

	/**
	 * 获取课程评价结果（教师）
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
	 * 邀请新的专家进行评价（教师)
	 * 
	 * @return
	 */
	public String addEvaluation() {
		evaluation.setSort(0);
		if (evaluateService.addEvaluation(evaluation, super.getCourse()))
			return SUCCESS;
		else {
			addActionError("邀请专家时发生错误，请重新操作！");
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