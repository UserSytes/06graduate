package cn.edu.xmu.course.interceptor;

import java.util.Map;

import cn.edu.xmu.course.pojo.Student;
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
public class StudentInterceptor extends AbstractInterceptor{


	/**
	 * 
	 */
	private static final long serialVersionUID = 5691441028616626323L;

	/**
	 * 拦截Action处理的拦截方法
	 */
	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map session = invocation.getInvocationContext().getSession();
		Student student = (Student) session.get("student");
		UserInfo userInfo = (UserInfo) session.get("userInfo");
		if(null!=student && null!= userInfo && userInfo.getId().equals(student.getUserInfo().getId())) {         
            return invocation.invoke();
        } else {
            return Action.LOGIN;
        }
	}
}
