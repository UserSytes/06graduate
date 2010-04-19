package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.*;

/**
 * 登录模块
 * @author 何申密 
 *
 */
public interface ILoginService {

	/**
	 * 老师登录方法
	 * @param userName
	 * @param password
	 * @return
	 */
	public Teacher teacherLogin(String userName, String password);
	
	/**
	 * 学生登录
	 * @param userName
	 * @param password
	 * @return
	 */
	public Student studentLogin(String userName, String password);
	
	/**
	 * 管理员登录
	 * @param userName
	 * @param password
	 * @return
	 */
	public Administrator adminLogin(String userName, String password);
	
	/**
	 * 超级管理员登录
	 * @param userName
	 * @param password
	 * @return
	 */
	public SuperAdmin superAdminLogin(String userName, String password);

	/**
	 * 专家登陆
	 * @param username
	 * @param password
	 * @param flag
	 * @return
	 */
	public Evaluation expertLogin(String username, String password ,int flag);
}
