package cn.edu.xmu.course.web.action;


import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String USERNAME = "username";
	public String IDENTITY = "identity";

	public BaseAction() {
	}

	public String getUserName() {
		return (String) ActionSession.getSession().get("username");
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
