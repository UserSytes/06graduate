package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * 教学成果
 * @author Administrator
 *
 */
public interface IAchievementService {

	/**
	 * 根据ID查找教学成果
	 * @param teacherCourse
	 * @return
	 */
	public Achievement getAchievementById(Integer id);
	
	
	//修改的时候需要把该方法去掉
	/**
	 * 查找该课程的教学成果
	 * @param teacherCourse
	 * @return
	 */
	public Achievement getAchievement(int courseId);
	
	/**
	 * 查找该课程所有的教学成果
	 * @param teacherCourse
	 * @return
	 */
	public List getAllAchievements(Course course);
	
	/**
	 * 添加教学成果
	 * @param course
	 * @param achievement
	 * @return
	 */
	public boolean addAchievement(Course course, Achievement achievement,File upload);
	
	/**
	 * 删除教学成果
	 * @param achievement
	 * @return
	 */
	public boolean deleteAchievement(Achievement achievement);
	
	/**
	 * 更新教学成果
	 * @param achievement
	 * @return
	 */
	public boolean updateAchievement(Achievement achievement,File upload);
	
	/**
	 * 查找最新教学成果
	 * @param course
	 * @return
	 */
	public List findLastestSevenAchievements(Course course);
}
