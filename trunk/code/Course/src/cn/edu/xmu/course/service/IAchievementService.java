package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.*;

/**
 * 教学成果
 * @author Administrator
 *
 */
public interface IAchievementService {

	/**
	 * 查找该课程的教学成果
	 * @param teacherCourse
	 * @return
	 */
	public Achievement getAchievement(Course course);
	
	/**
	 * 添加教学成果
	 * @param teacherCourse
	 * @param achievement
	 * @return
	 */
	public boolean addAchievement(Course course, Achievement achievement);
	
	/**
	 * 删除教学成果
	 * @param teacherCourse
	 * @param achievement
	 * @return
	 */
	public boolean deleteAchievement(Achievement achievement);
	
	/**
	 * 更新教学成果
	 * @param achievement
	 * @return
	 */
	public boolean updateAchievement(Achievement achievement);
}
