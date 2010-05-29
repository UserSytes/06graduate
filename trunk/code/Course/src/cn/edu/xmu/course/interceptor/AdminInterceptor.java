package cn.edu.xmu.course.interceptor;

import java.util.Map;

import cn.edu.xmu.course.pojo.Administrator;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 学院管理员权限拦截器
 * 
 * @author 何申密
 * 
 */
public class AdminInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 8775774337863497737L;

	/**
	 * 拦截Action处理的拦截方法
	 */
	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map session = invocation.getInvocationContext().getSession();
		Administrator admin = (Administrator) session.get("admin");
		if (null != admin) {
			return invocation.invoke();
		} else {
			return Action.LOGIN;
		}
	}

}
