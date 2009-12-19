package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * ��ʦ����
 * @author Administrator
 *
 */
public interface ITeacherTeamService {

	/**
	 * �鿴�ÿγ̵Ľ�ʦ����
	 * @param course
	 * @return
	 */
	public List getTeacherTeam(Course course);
	
	/**
	 * ��ӿγ̽�ʦ����
	 * @param teacherTeam
	 * @param course
	 * @return
	 */
	public boolean addTeacher(TeacherTeam teacherTeam, Course course);
	
	/**
	 * ɾ���γ̽�ʦ����
	 * @param teacherTeam
	 * @return
	 */
	public boolean deleteTeacher(TeacherTeam teacherTeam);
	
	/**
	 * ���¿γ̽�ʦ����
	 * @param teacherTeam
	 * @return
	 */
	public boolean updateTeacher(TeacherTeam teacherTeam);
}
