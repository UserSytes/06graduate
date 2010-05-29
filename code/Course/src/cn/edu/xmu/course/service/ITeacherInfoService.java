package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.UserInfo;

/**
 * ��ʦ��Ϣ����
 * @author ������
 * @author ֣����
 */
public interface ITeacherInfoService {

	/**
	 * �����ʺŲ��ҽ�ʦ
	 * @param userName
	 * @return
	 */
	public Teacher getTeacher(String userName);
	
	/**
	 * ���½�ʦ��Ϣ
	 * @param teacher
	 * @param userInfo
	 * @return
	 */
	public boolean updateTeacher(Teacher teacher, UserInfo userInfo);
	
	/**
	 * �޸�����
	 * @param teacher
	 * @return
	 */
	public boolean updatePassword(Teacher teacher);
	
	/**
	 * ��ӽ�ʦ
	 * @param teacher
	 * @param userInfo
	 * @return
	 */
	public boolean addTeacher(Teacher teacher, UserInfo userInfo);
	
	/**
	 * ����id���ҽ�ʦ
	 * @param id
	 * @return
	 */
	public Teacher findTeacherById(int id);
	
	/**
	 * ɾ����ʦ
	 * @param teacher
	 * @return
	 */
	public boolean deleteTeacher(Teacher teacher);
	
	/**
	 * ����ѧԺ���ҽ�ʦ
	 * @param school
	 * @return
	 */
	public List findTeachersBySchool(School school);
	
	/**
	 * �����ʺŲ��ҽ�ʦ
	 * @param teacherNo
	 * @return
	 */
	public Teacher findTeacherByTeacherNo(String teacherNo);
	
	/**
	 * �����û���Ϣ���ҽ�ʦ
	 * @param userInfo
	 * @return
	 */
	public Teacher findTeacherByUserInfo(UserInfo userInfo);
	
	/**
	 * ����ѧԺ���ҽ�ʦ��Ϣ
	 * @param school
	 * @return
	 */
	public List getTeaNameAndNumber(School school);
	
	/**
	 * �޸�ͷ��
	 * @param userInfo
	 * @param photo
	 * @param fileLink
	 * @return
	 */
	public boolean addTeacherPhoto(UserInfo userInfo, File photo,String fileLink);
	
}
