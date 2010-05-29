package cn.edu.xmu.course.interceptor;

import java.util.Map;

import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.UserInfo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * ѧ��Ȩ��������
 * 
 * @author ������
 * 
 */
public class StudentInterceptor extends AbstractInterceptor{


	/**
	 * 
	 */
	private static final long serialVersionUID = 5691441028616626323L;

	/**
	 * ����Action��������ط���
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
