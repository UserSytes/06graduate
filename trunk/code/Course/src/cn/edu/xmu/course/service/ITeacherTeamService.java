package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.TeacherTeam;

/**
 * 教师队伍
 * @author 何申密
 * @author 许子彦
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
	public List<TeacherTeam> getTeacherTeamList(int courseId);
	
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
