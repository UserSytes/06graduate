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
	 * 查看该课程的教师队伍
	 * @param course
	 * @return
	 */
	public List getTeacherTeam(Course course);
	
	/**
	 * 添加课程教师队伍
	 * @param teacherTeam
	 * @param course
	 * @return
	 */
	public boolean addTeacher(TeacherTeam teacherTeam, Course course);
	
	/**
	 * 删除课程教师队伍
	 * @param teacherTeam
	 * @return
	 */
	public boolean deleteTeacher(TeacherTeam teacherTeam);
	
	/**
	 * 更新课程教师队伍
	 * @param teacherTeam
	 * @return
	 */
	public boolean updateTeacher(TeacherTeam teacherTeam);
}
