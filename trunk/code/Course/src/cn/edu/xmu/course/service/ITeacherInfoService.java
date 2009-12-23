package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * 教师信息管理
 * @author 何申密
 * @author 郑冰凌
 */
public interface ITeacherInfoService {

	
	public Teacher getTeacher(String userName);
	
	public boolean updateTeacher(Teacher teacher, UserInfo userInfo);
	
	public boolean changePassword(Teacher teacher);
	
	public boolean addTeacher(Teacher teacher);
	
	public Teacher findTeacherById(int id);
	
	public boolean deleteTeacher(Teacher teacher);
	
	public List findTeacherBySchool(School school);
	
	
}
