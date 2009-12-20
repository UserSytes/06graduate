package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.*;

/**
 * ��ʦ��Ϣ����
 * @author Administrator
 *
 */
public interface ITeacherInfoService {

	
	public Teacher getTeacher(String userName);
	
	public boolean updateTeacher(Teacher teacher, UserInfo userInfo);
	
	public boolean changePassword(Teacher teacher);
	
	
	public boolean addTeacher(Teacher teacher);
}
