package cn.edu.xmu.course.web.action;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.ILoginService;

/**
 * 此类负责 用户的登录、退出、及权限分配
 * 
 * @author 郑冰凌
 * 
 */
public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3613304347937871262L;

	private ILoginService loginService; // 管理用户登录的借口

	private String userName; // 用户帐号
	private String password; // 用户密码
	private int flag; // 用户角色
	private Student student; // 学生
	private Teacher teacher; // 教师
	private UserInfo userInfo; // 用户信息

	/**
	 * 教师登录
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String login() {
		Teacher teacher = loginService.teacherLogin(userName, password);
		if (null == teacher)
			return ERROR;
		else {
			super.getSession().put(TEACHER, teacher);
			return SUCCESS;
		}
	}

	/**
	 * 管理员登录
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String adminLogin() {
		if (flag == 0) {
			Administrator admin = loginService.adminLogin(userName, password);
			if (null == admin) {
				addActionError("帐号或者密码错误，请重新登录！");
				return ERROR;
			} else {
				super.getSession().put(ADMIN, admin);
				return "admin";
			}
		} else if (flag == 1) {
			SuperAdmin superAdmin = loginService.superAdminLogin(userName,
					password);
			if (null == superAdmin) {
				addActionError("帐号或者密码错误，请重新登录！");
				return ERROR;
			} else {
				super.getSession().put(SUPERADMIN, superAdmin);
				return "superAdmin";
			}
		} else
			return ERROR;
	}

	@SuppressWarnings("unchecked")
	public String evaluationLogin() {
		Evaluation evaluation = getLoginService().expertLogin(userName,
				getPassword(), flag);
		if (null == evaluation) {
			addActionError("帐号或者密码错误，请重新登录！");
			return ERROR;
		} else {
			Course course = evaluation.getCourse();
			super.getSession().put(EVALUATION, evaluation);
			super.getSession().put(COURSE, course);
			super.getSession().put("style", course.getStyle());
			super.getSession().put("header", course.getHeader());
			if (course.getHeader().equals("header_sand.jsp")) {
				super.getSession().put("sort", "sorttype");
				super.getSession().put("filtercon", "allcon");
			}
			return SUCCESS;
		}
	}

	/**
	 * 跳转的个人主页（教师和学生）
	 * 
	 * @return
	 */
	public String myPage() {
		student = (Student) super.getSession().get(STUDENT);
		teacher = (Teacher) super.getSession().get(TEACHER);
		if (student == null && teacher == null) {
			addActionMessage("您还未登录，请先登录！");
			return ERROR;
		} else if (student != null) {
			userInfo = student.getUserInfo();
			return "student";
		} else if (teacher != null) {
			userInfo = teacher.getUserInfo();
			return "teacher";
		} else {
			addActionMessage("您还未登录，请先登录！");
			return ERROR;
		}

	}

	@SuppressWarnings("unchecked")
	public String studentLoginForCol() {
		student = loginService.studentLogin(userName, password);
		if (student == null) {
			addActionError("用户名或密码错误，请重新操作！");
			return ERROR;
		} else {
			super.getSession().put(STUDENT, student);
			super.getSession().put("user",
					student.getUserInfo().getName() + "同学");
			super.getSession().put(USERINFO, student.getUserInfo());
			return SUCCESS;
		}

	}

	/**
	 * 教师、学生退出系统
	 */
	public String logout() {
		super.getSession().remove(STUDENT);
		super.getSession().remove(USERINFO);
		super.getSession().remove(TEACHER);
		super.getSession().remove("user");
		return SUCCESS;
	}

	/**
	 * 学院管理员退出系统
	 * 
	 * @return
	 */
	public String adminLogout() {
		super.getSession().remove(ADMIN);
		return SUCCESS;
	}

	/**
	 * 校管理员退出系统
	 * 
	 * @return
	 */
	public String superAdminLogout() {
		super.getSession().remove(SUPERADMIN);
		return SUCCESS;
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

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

}
