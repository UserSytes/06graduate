package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * 教师队伍
 * @author Administrator
 *
 */
public interface ITeacherTeamService {

	/**
	 * 根据ID查找教师队伍
	 * @param teacherTeamId
	 * @return
	 */
	public TeacherTeam getTeacherTeam(int teacherTeamId);
	/**
	 * 查看该课程的教师队伍
	 * @param course
	 * @return
	 */
	public List getTeacherTeamList(int courseId);
	
	/**
	 * 添加课程教师队伍
	 * @param teacherTeam
	 * @param course
	 * @return
	 */
	public boolean addTeacherTeam(TeacherTeam teacherTeam, Course course);
	
	/**
	 * 删除课程教师队伍
	 * @param teacherTeam
	 * @return
	 */
	public boolean deleteTeacherTeam(TeacherTeam teacherTeam);
	
	/**
	 * 更新课程教师队伍
	 * @param teacherTeam
	 * @return
	 */
	public boolean updateTeacherTeam(TeacherTeam teacherTeam);
}
