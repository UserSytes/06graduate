package cn.edu.xmu.course.interceptor;

import java.util.Map;

import cn.edu.xmu.course.pojo.Course;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 课程拦截器
 * 
 * @author 何申密
 * 
 */
public class CourseInterceptor extends AbstractInterceptor{
	

	private static final long serialVersionUID = -7319412027229496950L;

	/**
	 * 拦截Action处理的拦截方法
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map session = invocation.getInvocationContext().getSession();
		Course course = (Course) session.get("course");
		System.out.println("here");
		if(null!=course) {         
            return invocation.invoke();
        } else {         
            return Action.LOGIN;
        }
	}
}
