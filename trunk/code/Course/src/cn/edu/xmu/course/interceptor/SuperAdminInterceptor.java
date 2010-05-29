package cn.edu.xmu.course.interceptor;

import java.util.Map;

import cn.edu.xmu.course.pojo.SuperAdmin;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * У����ԱȨ��������
 * @author ������
 *
 */
public class SuperAdminInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = -141859865926136618L;

	/**
     * ����Action��������ط���
     */
	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map session = invocation.getInvocationContext().getSession();
		SuperAdmin superAdmin = (SuperAdmin) session.get("superAdmin");
		if(null!=superAdmin) {         
            return invocation.invoke();
        } else {         
            return Action.LOGIN;
        }
	}

}
