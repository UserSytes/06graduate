package cn.edu.xmu.course.web.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;



public class ActionSession {
	@SuppressWarnings("unchecked")
	private static Map session;
	
	private ActionSession(){}
	
	@SuppressWarnings("unchecked")
	public static Map getSession(){
		if(session == null)
			session = ActionContext.getContext().getSession();
		
		return session;
	}
}
