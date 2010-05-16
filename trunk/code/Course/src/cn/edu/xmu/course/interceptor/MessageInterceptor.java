package cn.edu.xmu.course.interceptor;

import java.util.Map;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.Teacher;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * ¡Ù—‘∞Â¿πΩÿ∆˜
 * 
 * @author ∫Œ…Í√‹
 * 
 */
public class MessageInterceptor extends AbstractInterceptor {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4836792862377454002L;

	/**
	 * ¿πΩÿAction¥¶¿Ìµƒ¿πΩÿ∑Ω∑®
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map session = invocation.getInvocationContext().getSession();
		Course course = (Course) session.get("course");
		if (null != course) {
			Student stu = (Student) session.get("student");
			Teacher tea = (Teacher) session.get("teacher");
			if (null != stu || null != tea)
				return invocation.invoke();
			else
				return Action.LOGIN;

		} else {
			return Action.LOGIN;

		}
	}
}
