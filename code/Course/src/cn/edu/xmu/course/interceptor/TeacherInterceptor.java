package cn.edu.xmu.course.interceptor;

import java.util.Map;

import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.UserInfo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 学生权限拦截器
 * 
 * @author 何申密
 * 
 */
public class TeacherInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 8283598601836929653L;

	/**
	 * 拦截Action处理的拦截方法
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map session = invocation.getInvocationContext().getSession();
		Teacher teacher = (Teacher) session.get("teacher");
		UserInfo userInfo = (UserInfo) session.get("userInfo");
		if(null!=teacher && null!= userInfo && userInfo.getId().equals(teacher.getUserInfo().getId())) {         
            return invocation.invoke();
        } else {
            return Action.LOGIN;
        }
	}
}
