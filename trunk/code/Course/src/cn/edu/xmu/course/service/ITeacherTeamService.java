package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.TeacherTeam;

/**
 * ��ʦ����
 * @author ������
 * @author ������
 *
 */
public interface ITeacherTeamService {

	/**
	 * ����ID���ҽ�ʦ����
	 * @param teacherTeamId
	 * @return
	 */
	public TeacherTeam getTeacherTeam(int teacherTeamId);
	/**
	 * �鿴�ÿγ̵Ľ�ʦ����
	 * @param course
	 * @return
	 */
	public List<TeacherTeam> getTeacherTeamList(int courseId);
	
	/**
	 * ��ӿγ̽�ʦ����
	 * @param teacherTeam
	 * @param course
	 * @return
	 */
	public boolean addTeacherTeam(TeacherTeam teacherTeam, Course course);
	
	/**
	 * ɾ���γ̽�ʦ����
	 * @param teacherTeam
	 * @return
	 */
	public boolean deleteTeacherTeam(TeacherTeam teacherTeam);
	
	/**
	 * ���¿γ̽�ʦ����
	 * @param teacherTeam
	 * @return
	 */
	public boolean updateTeacherTeam(TeacherTeam teacherTeam);
}
