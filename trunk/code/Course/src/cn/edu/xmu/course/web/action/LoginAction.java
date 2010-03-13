package cn.edu.xmu.course.web.action;

import cn.edu.xmu.course.service.ILoginService;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.pojo.Teacher;
/**
 * 
 * @author Sky
 *
 */
public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3613304347937871262L;

	private ILoginService loginService;

	private String userName = "123456";
	private String password = "123456";
	private int flag;

	/**
	 * 教师登录
	 * @return
	 */
	public String login() {
		userName = "123";
		password = "123456";
		Teacher teacher = loginService.teacherLogin(userName, password);
		System.out.println(teacher.getTeacherNo());
		if (null == teacher)
			return ERROR;
		else {
			System.out.println(teacher.getPassword());
			super.getSession().put(TEACHER, teacher);
			return SUCCESS;
		}
	}

	/**
	 * 管理员登录
	 * @return
	 */
	public String adminLogin() {
		userName = "123456";
		password = "123456";
		System.out.println(flag);
		if (flag == 0) {
			Administrator admin = loginService.adminLogin(userName, password);
			if (null == admin)
				return ERROR;
			else {
				super.getSession().put(ADMIN, admin);
				return "admin";
			}
		} else if(flag == 1){
			System.out.println(userName);
			SuperAdmin superAdmin = loginService.superAdminLogin(userName,
					password);
			if (null == superAdmin)
				return ERROR;
			else {
				super.getSession().put(SUPERADMIN, superAdmin);
				return "superAdmin";
			}
		}
	
		else
			return ERROR;
	}

	/**
	 * 学院管理员退出
	 * @return
	 */
	public String adminLogout(){
		super.getSession().remove(ADMIN);
		return SUCCESS;
	}
	
	/**
	 * 校管理员登录
	 * @return
	 */
	public String superAdminLogout(){
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

}
