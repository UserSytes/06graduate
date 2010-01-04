package cn.edu.xmu.course.web.action;

import cn.edu.xmu.course.service.ILoginService;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.pojo.Teacher;

public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3613304347937871262L;

	private ILoginService loginService;

	private String userName = "123456";
	private String password = "123456";
	private int flag;

	public String login() {
		userName = "123";
		password = "123456";
		Teacher teacher = loginService.teacherLogin(userName, password);
		System.out.println(teacher.getTeacherNo());
		if (null == teacher)
			return ERROR;
		else {
			System.out.println(teacher.getPassword());
			ActionSession.getSession().put(TEACHER, teacher);
			return SUCCESS;
		}
	}

	public String adminLogin() {
		userName = "123456";
		password = "123456";
		if (flag == 0) {
			Administrator admin = loginService.adminLogin(userName, password);
			if (null == admin)
				return ERROR;
			else {
				ActionSession.getSession().put(ADMIN, admin);
				return "admin";
			}
		} else if(flag == 1){
			SuperAdmin superAdmin = loginService.superAdminLogin(userName,
					password);
			if (null == superAdmin)
				return ERROR;
			else {
				ActionSession.getSession().put(SUPERADMIN, superAdmin);
				return "superAdmin";
			}
		}else
			return ERROR;
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

}
