package cn.edu.xmu.course.web.action;

import java.util.Date;
import java.util.Map;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.UserInfo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 所有Action的基类
 *
 */
@SuppressWarnings("unchecked")
public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String USERNAME = "username";
	public String IDENTITY = "identity";
	public String TEACHER = "teacher";
	public String ADMIN = "admin";
	public String STUDENT = "student";
	public String SUPERADMIN = "superAdmin";
	public String COURSE = "course";
	public String USERINFO = "userInfo";
	public String EVALUATION = "evaluation";
	private ActionContext ctx;	
	Map session;

	public BaseAction() {

	}

	public Evaluation getEvaluation() {
		return (Evaluation) this.getSession().get(EVALUATION);
	}

	public String getUserName() {
		return (String) this.getSession().get("username");
	}

	public Teacher getTeacher() {
		return (Teacher) this.getSession().get(TEACHER);
	}

	public Student getStudent() {
		return (Student) this.getSession().get(STUDENT);
	}

	public Administrator getAdmin() {
		return (Administrator) this.getSession().get(ADMIN);
	}

	public SuperAdmin getSuperAdmin() {
		return (SuperAdmin) this.getSession().get(SUPERADMIN);
	}

	public Course getCourse() {
		return (Course) this.getSession().get(COURSE);
	}

	public UserInfo getUserInfo() {
		return (UserInfo) this.getSession().get(USERINFO);
	}
	
	public Map getSession() {
		ctx = ActionContext.getContext();
		session = ctx.getSession();
		return session;
	}

	/**
	 * 获得教师文件夹名字
	 * @param cou
	 * @return
	 */
	public String getPreFileNameByTeacher(Course cou) {
		String preFileName = this.getTeacher().getTeacherNo()+this.getTeacher().getUserInfo().getName() + "/"
				+ cou.getName() + "/" + new Date().getTime() + "_";
		return preFileName;
	}
	
	/**
	 * 用户注销
	 * @return
	 */
	public String logout() {
		try {
			this.getSession().clear();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public ActionContext getCtx() {
		return ctx;
	}

	public void setCtx(ActionContext ctx) {
		this.ctx = ctx;
	}

	public void setSession(Map session) {
		this.session = session;
	}

}
