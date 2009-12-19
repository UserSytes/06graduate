package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.*;

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
}
