package cn.edu.xmu.course.web.action;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.edu.xmu.course.pojo.*;

import com.opensymphony.xwork2.ActionContext;
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
	
	private ActionContext ctx ;
	Map session ;
	
	public BaseAction() {
		
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
	public UserInfo getUserInfo(){
		return (UserInfo) this.getSession().get(USERINFO);
	}
	
	public Map getSession() {
		ctx = ActionContext.getContext();
		session = ctx.getSession(); 
		return session;
	}
	
	public String getPreFileNameByTeacher(){
		String preFileName = this.getTeacher().getUserInfo().getName() + "/"
		+ new Date().getTime()+"_"+this.getCourse().getName() + "_";
		return preFileName;
	}

	public String logout() {
		try {
			session.clear();
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
