package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.*;

/**
 * 教师信息管理
 * @author Administrator
 *
 */
public interface ITeacherInfoService {

	
	public Teacher getTeacher(String userName);
	
	public boolean updateTeacher(Teacher teacher, UserInfo userInfo);
	
	public boolean changePassword(Teacher teacher);
	
	
	public boolean addTeacher(Teacher teacher);
}
