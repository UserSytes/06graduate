package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * ��ʦ��Ϣ����
 * @author ������
 * @author ֣����
 */
public interface ITeacherInfoService {

	
	public Teacher getTeacher(String userName);
	
	public boolean updateTeacher(Teacher teacher, UserInfo userInfo);
	
	public boolean changePassword(Teacher teacher);
	
	public boolean addTeacher(Teacher teacher, UserInfo userInfo);
	
	public Teacher findTeacherById(int id);
	
	public boolean deleteTeacher(Teacher teacher);
	
	public List findTeachersBySchool(School school);
	
	public Teacher findTeacherByTeacherNo(String teacherNo);
	
	public Teacher findTeacherByUserInfo(UserInfo userInfo);
	
	public List getTeaNameAndNumber(School school);
}
