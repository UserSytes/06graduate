package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.*;

/**
 * ��¼ģ��
 * @author ������ 
 *
 */
public interface ILoginService {

	/**
	 * ��ʦ��¼����
	 * @param userName
	 * @param password
	 * @return
	 */
	public Teacher teacherLogin(String userName, String password);
	
	/**
	 * ѧ����¼
	 * @param userName
	 * @param password
	 * @return
	 */
	public Student studentLogin(String userName, String password);
	
	/**
	 * ����Ա��¼
	 * @param userName
	 * @param password
	 * @return
	 */
	public Administrator adminLogin(String userName, String password);
	
	/**
	 * ��������Ա��¼
	 * @param userName
	 * @param password
	 * @return
	 */
	public SuperAdmin superAdminLogin(String userName, String password);

	/**
	 * ר�ҵ�½
	 * @param username
	 * @param password
	 * @param flag
	 * @return
	 */
	public Evaluation expertLogin(String username, String password ,int flag);
}
