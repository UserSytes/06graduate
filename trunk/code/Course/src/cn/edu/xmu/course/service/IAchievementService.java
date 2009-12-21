package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.*;

/**
 * ��ѧ�ɹ�
 * @author Administrator
 *
 */
public interface IAchievementService {

	/**
	 * ���Ҹÿγ̵Ľ�ѧ�ɹ�
	 * @param teacherCourse
	 * @return
	 */
	public Achievement getAchievement(Course course);
	
	/**
	 * ��ӽ�ѧ�ɹ�
	 * @param teacherCourse
	 * @param achievement
	 * @return
	 */
	public boolean addAchievement(Course course, Achievement achievement);
	
	/**
	 * ɾ����ѧ�ɹ�
	 * @param teacherCourse
	 * @param achievement
	 * @return
	 */
	public boolean deleteAchievement(Achievement achievement);
	
	/**
	 * ���½�ѧ�ɹ�
	 * @param achievement
	 * @return
	 */
	public boolean updateAchievement(Achievement achievement);
}
