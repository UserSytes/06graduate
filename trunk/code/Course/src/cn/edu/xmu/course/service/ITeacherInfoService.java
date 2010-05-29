package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.UserInfo;

/**
 * 教师信息管理
 * @author 何申密
 * @author 郑冰凌
 */
public interface ITeacherInfoService {

	/**
	 * 根据帐号查找教师
	 * @param userName
	 * @return
	 */
	public Teacher getTeacher(String userName);
	
	/**
	 * 更新教师信息
	 * @param teacher
	 * @param userInfo
	 * @return
	 */
	public boolean updateTeacher(Teacher teacher, UserInfo userInfo);
	
	/**
	 * 修改密码
	 * @param teacher
	 * @return
	 */
	public boolean updatePassword(Teacher teacher);
	
	/**
	 * 添加教师
	 * @param teacher
	 * @param userInfo
	 * @return
	 */
	public boolean addTeacher(Teacher teacher, UserInfo userInfo);
	
	/**
	 * 根据id查找教师
	 * @param id
	 * @return
	 */
	public Teacher findTeacherById(int id);
	
	/**
	 * 删除教师
	 * @param teacher
	 * @return
	 */
	public boolean deleteTeacher(Teacher teacher);
	
	/**
	 * 根据学院查找教师
	 * @param school
	 * @return
	 */
	public List findTeachersBySchool(School school);
	
	/**
	 * 根据帐号查找教师
	 * @param teacherNo
	 * @return
	 */
	public Teacher findTeacherByTeacherNo(String teacherNo);
	
	/**
	 * 根据用户信息查找教师
	 * @param userInfo
	 * @return
	 */
	public Teacher findTeacherByUserInfo(UserInfo userInfo);
	
	/**
	 * 根据学院查找教师信息
	 * @param school
	 * @return
	 */
	public List getTeaNameAndNumber(School school);
	
	/**
	 * 修改头像
	 * @param userInfo
	 * @param photo
	 * @param fileLink
	 * @return
	 */
	public boolean addTeacherPhoto(UserInfo userInfo, File photo,String fileLink);
	
}
