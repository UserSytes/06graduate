package cn.edu.xmu.course.web.action;

import cn.edu.xmu.course.service.ILoginService;
import cn.edu.xmu.course.pojo.Teacher;
public class LoginAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3613304347937871262L;
	
	private ILoginService loginService;

	private String userName;
	private String password;
	
	public String login(){
		Teacher teacher = loginService.teacherLogin(userName, password);
		System.out.println(userName);
		if(null == teacher)
			return ERROR;
		else 
			System.out.println(teacher.getPassword());
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
	
	

}
