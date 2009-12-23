package cn.edu.xmu.course.web.action;


import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.pojo.Teacher;

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

	public BaseAction() {
	}

	public String getUserName() {
		return (String) ActionSession.getSession().get("username");
	}

	public Teacher getTeacher(){
		return (Teacher) ActionSession.getSession().get(TEACHER);
	}
	
	public Student getStudent(){
		return (Student) ActionSession.getSession().get(STUDENT);
	}
	
	public Administrator getAdmin(){
		return (Administrator) ActionSession.getSession().get(ADMIN);
	}
	
	public SuperAdmin getSuperAdmin(){
		return (SuperAdmin) ActionSession.getSession().get(SUPERADMIN);
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
