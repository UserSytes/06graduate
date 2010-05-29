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
 * 负责评价的类
 * 
 * @author 赵海虹
 * @author 何申密
 * @author 许子彦
 * 
 */
public class EvaluationAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4926852401033424156L;
	private IEvaluateService evaluateService;// 评价管理方法的接口
	private ICourseService courseService;// 课程管理方法的接口
	private StudentCourse studentCourse;// 学生管理方法的接口
	private Float score;// 评价分数
	private Object viewScore;// 评价分数
	private String scorestring;// 评价结果
	private Student student;// 学生
	private Evaluation evaluation;// 评价
	private String content;// 评价内容
	private Course course;// 课程
	private int courseId;// 课程ID
	private int evaluationId;// 评价ID
	private Object stuAvgScore = 0;// 学生评价平均分数
	private Object expertAvgScore = 0;// 专家评价平均分数
	private Object stuCount;// 学生数目
	private Object expertCount;// 专家数目
	private Object teaAvgScore = 0;// 教师评价分数
	private Object teaCount;// 教师数目
	private List<Evaluation> evaluationList;// 评价列表
	private Teacher teacher;// 教师
	private UserInfo userInfo;// 用户信息
	private int flag;// 标志
	private ILoginService loginService;// 登陆管理方法的接口
	private String userName, password;// 用户名，密码
	private boolean result;// 结果

	private List<Course> courseList;// 课程列表
	private List<String> courseIds;// 课程ID
	private List<CourseEvaluate> courseEvaluateList = new ArrayList<CourseEvaluate>();// 课程评价列表

	/**
	 * 从评价页面登陆
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
				addActionError("用户名或密码错误！请返回重试！");
				return ERROR;
			} else if (!evaluation.getCourse().getId().equals(course.getId())) {
				addActionError("对不起，该专家帐号不适用于该课程！请返回重试！");
				return ERROR;
			} else {
				super.getSession().remove(EVALUATION);
				super.getSession().put(EVALUATION, evaluation);
				getExpertAverage(evaluation.getCourse().getId());
				score = evaluation.getScore();
				if (score == null) {
					return "expert";
				} else {
					scorestring = "您已经评价过，你上一次对该课程的评分是：" + score.intValue()
							+ "分";
					return "exsuccess";
				}
			}
		} else if (getFlag() == 1) {
			evaluation = getLoginService().expertLogin(userName, getPassword(),
					1);
			if (null == evaluation) {
				addActionError("用户名或密码错误！请返回重试！");
				return ERROR;
			} else if (!evaluation.getCourse().getId().equals(course.getId())) {
				addActionError("对不起，该同行帐号不适用于该课程！请返回重试！");
				return ERROR;
			} else {
				super.getSession().remove(EVALUATION);
				super.getSession().put(EVALUATION, evaluation);
				getTeaAverage(evaluation.getCourse().getId());
				score = evaluation.getScore();
				if (score == null) {
					return "teacher";
				} else {
					scorestring = "您已经评价过，你上一次对该课程的评分是：" + score.intValue()
							+ "分";
					return "tesuccess";
				}
			}
		} else {
			student = getLoginService().studentLogin(userName, getPassword());
			if (null == student) {
				addActionError("用户名或密码错误！请返回重试！");
				return ERROR;
			} else {
				List<StudentCourse> scList = evaluateService
						.findByStudentAndCourse(course, student);
				if (scList.size() == 0) {
					addActionError("你所登录的帐号不是该课程的学生，无法进行评价！");
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
					scorestring = "您已经评价过，你上一次对该课程的评分是：" + score.intValue()
							+ "分";
					return SUCCESS;
				}
			}
		}
	}

	/**
	 * 专家课程评价结果
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
	 * 同行教师课程评价结果
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
	 * 专家课程评价内容
	 * 
	 * @return
	 */
	public String enterEvaluation() {
		course = super.getCourse();
		evaluation = evaluateService.findById(evaluationId);
		return SUCCESS;
	}

	/**
	 * 同行教师课程评价内容
	 * 
	 * @return
	 */
	public String enterTeaEvaluation() {
		course = super.getCourse();
		evaluation = evaluateService.findById(evaluationId);
		return SUCCESS;
	}

	/**
	 * 学生课程评价
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
			scorestring = "评价成功，你的评分是：" + score.intValue() + "分";
			getStuAverage(course.getId());
			return SUCCESS;
		} else {
			addActionError("评价失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 专家课程评价
	 * 
	 * @return
	 */
	public String expertEvaluate() {
		course = super.getCourse();
		score = evaluation.getScore();
		evaluation.setStatus(1);
		result = evaluateService.updateEvaluation(evaluation);
		if (result) {
			scorestring = "评价成功，你的评分是：" + score.intValue() + "分";
			getExpertAverage(course.getId());
			return SUCCESS;
		} else {
			addActionError("评价失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 教师课程评价
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
			scorestring = "评价成功，你的评分是：" + score.intValue() + "分";
			getTeaAverage(course.getId());
			return SUCCESS;
		} else {
			addActionError("评价失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 专家课程评价（草稿）
	 * 
	 * @return
	 */
	public String expertEvaluateDraft() {
		course = super.getCourse();
		score = evaluation.getScore();
		evaluation.setStatus(0);
		result = evaluateService.updateEvaluation(evaluation);
		if (result) {
			scorestring = "保存草稿成功！";
			return SUCCESS;
		} else {
			addActionError("保存草稿失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 教师课程评价（草稿）
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
			scorestring = "保存草稿成功！";
			return SUCCESS;
		} else {
			addActionError("保存草稿失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 专家评价结果
	 * 
	 * @return
	 */
	public String reExpertEvaluation() {
		evaluation = evaluateService.findById(evaluationId);
		getExpertAverage(evaluation.getCourse().getId());
		return SUCCESS;
	}

	/**
	 * 教师评价结果
	 * 
	 * @return
	 */
	public String reTeaEvaluation() {
		evaluation = evaluateService.findById(evaluationId);
		getTeaAverage(evaluation.getCourse().getId());
		return SUCCESS;
	}

	/**
	 * 学生评价结果
	 * 
	 * @return
	 */
	public String reStuEvaluation() {
		getStuAverage(super.getCourse().getId());
		return SUCCESS;
	}

	/**
	 * 专家进入评价
	 * 
	 * @return
	 */
	public String eDetailEvaluate() {
		course = super.getCourse();
		evaluation = (Evaluation) super.getSession().get(EVALUATION);
		if (null == evaluation || evaluation.getSort() == 1) {
			return "evalogin";
		} else if (!evaluation.getCourse().getId().equals(course.getId())) {
			addActionError("对不起，该专家帐号不适用于该课程！请返回重试！");
			return ERROR;
		} else {
			getExpertAverage(course.getId());
			score = evaluation.getScore();
			if (score == null) {
				return "evluate";
			} else {
				if (evaluation.getStatus() == 1)
					scorestring = "您已经评价过，你上一次对该课程的评分是：" + score.intValue()
							+ "分";
				else
					scorestring = "您保存过草稿，你上一次对该课程的评分是：" + score.intValue()
							+ "分";
				return SUCCESS;
			}
		}
	}

	/**
	 * 教师进入评价
	 * 
	 * @return
	 */
	public String tDetailEvaluate() {
		course = super.getCourse();
		evaluation = (Evaluation) super.getSession().get(EVALUATION);
		if (null == evaluation || evaluation.getSort() == 0) {
			return "evalogin";
		} else if (!evaluation.getCourse().getId().equals(course.getId())) {
			addActionError("对不起，该同行帐号不适用于该课程！请返回重试！");
			return ERROR;
		} else {
			getTeaAverage(course.getId());
			score = evaluation.getScore();
			if (score == null) {
				return "evluate";
			} else {
				if (evaluation.getStatus() == 1)
					scorestring = "您已经评价过，你上一次对该课程的评分是：" + score.intValue()
							+ "分";
				else
					scorestring = "您保存过草稿，你上一次对该课程的评分是：" + score.intValue()
							+ "分";
				return SUCCESS;
			}
		}
	}

	/**
	 * 学生进入评价
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
				addActionError("你所登录的帐号不是该课程的学生，无法进行评价！");
				return ERROR;
			}
			getStuAverage(course.getId());
			score = scList.get(0).getScore();
			if (score == null) {
				return "evluate";
			} else {
				scorestring = "您已经评价过，你上一次对该课程的评分是：" + score.intValue() + "分";
				return SUCCESS;
			}
		}
	}

	/**
	 * 获得该课程专家评价列表（教师）
	 * 
	 * @return
	 */
	public String getEvaluationListByCourse() {
		evaluationList = evaluateService.findByCourseAndSort(super.getCourse(),
				0);
		return SUCCESS;
	}

	/**
	 * 获得该课程同行评价列表（教师）
	 * 
	 * @return
	 */
	public String getEvaTeacherListByCourse() {
		evaluationList = evaluateService.findByCourseAndSort(super.getCourse(),
				1);
		return SUCCESS;
	}

	/**
	 * 获取课程评价结果（教师）
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
	 * 获得专家评价平均分数
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
	 * 获得教师评价平均分数
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
	 * 获得学生评价平均分数
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

	/**
	 * 邀请新的同行进行评价（教师)
	 * 
	 * @return
	 */
	public String addEvaTeacher() {
		evaluation.setSort(1);
		if (evaluateService.addEvaluation(evaluation, super.getCourse()))
			return SUCCESS;
		else {
			addActionError("邀请专家时发生错误，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 获取学院课程列表
	 * 
	 * @return
	 */
	public String findCourse() {
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		School school = admin.getSchool();
		courseList = courseService.findBySchool(school);
		if (courseList.size() == 0) {
			addActionError("暂无课程！");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * 获取选择的课程
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
			addActionError("您未选择任何课程！");
			return ERROR;
		} else {
			courseEvaluateList = evaluateService
					.getEvaluateByCourseList(courseList);
			super.getSession().put("data", courseEvaluateList);
			return SUCCESS;
		}
	}

	/**
	 * 生成课程柱形图
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String genrEvaluateChart() {
		try {
			Administrator admin = (Administrator) super.getSession().get(ADMIN);
			School school = admin.getSchool();
			Date currentDate = new Date();
			super.getSession().put("title", school.getName() + "课程评价对比柱形图");
			super.getSession().put("abscissa", "课程");
			super.getSession().put("ordinate", "平均分");

			return SUCCESS;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 删除课程评价
	 * 
	 * @return
	 */
	public String deleteEvaluation() {
		Evaluation eva = evaluateService.findById(evaluationId);
		if (evaluateService.deleteEvaluation(eva))
			return SUCCESS;
		else {
			addActionError("删除课程评价失败，请重新操作！");
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