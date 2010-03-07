package cn.edu.xmu.course.web.action;

import java.util.Date;

import cn.edu.xmu.course.pojo.*;

import com.opensymphony.xwork2.ActionSupport;

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
	public String USERINFO= "userInfo";
	public BaseAction() {
	}

	public String getUserName() {
		return (String) ActionSession.getSession().get("username");
	}

	public Teacher getTeacher() {
		return (Teacher) ActionSession.getSession().get(TEACHER);
	}

	public Student getStudent() {
		return (Student) ActionSession.getSession().get(STUDENT);
	}

	public Administrator getAdmin() {
		return (Administrator) ActionSession.getSession().get(ADMIN);
	}

	public SuperAdmin getSuperAdmin() {
		return (SuperAdmin) ActionSession.getSession().get(SUPERADMIN);
	}

	public Course getCourse() {
		return (Course) ActionSession.getSession().get(COURSE);
	}
	public UserInfo getUserInfo(){
		return (UserInfo) ActionSession.getSession().get(USERINFO);
	}
	public String getPreFileNameByTeacher(){
		String preFileName = this.getTeacher().getUserInfo().getName() + "/"
		+ new Date().getTime()+"_"+this.getCourse().getName() + "_";
		return preFileName;
	}

	public String logout() {
		try {
			ActionSession.getSession().clear();
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

}
