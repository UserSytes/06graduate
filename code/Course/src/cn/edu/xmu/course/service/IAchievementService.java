package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * ��ѧ�ɹ�
 * @author ������
 * @author ������
 *
 */
public interface IAchievementService {

	/**
	 * ����ID���ҽ�ѧ�ɹ�
	 * @param teacherCourse
	 * @return
	 */
	public Achievement getAchievementById(Integer id);
	
	
	/**
	 * ���Ҹÿγ����еĽ�ѧ�ɹ�
	 * @param teacherCourse
	 * @return
	 */
	public List<Achievement> getAllAchievements(Course course);
	
	/**
	 * ��ӽ�ѧ�ɹ�
	 * @param course
	 * @param achievement
	 * @return
	 */
	public boolean addAchievement(Course course, Achievement achievement,File upload);
	
	/**
	 * ɾ����ѧ�ɹ�
	 * @param achievement
	 * @return
	 */
	public boolean deleteAchievement(Achievement achievement);
	
	/**
	 * ���½�ѧ�ɹ�
	 * @param achievement
	 * @return
	 */
	public boolean updateAchievement(Achievement achievement,File upload);
	
	/**
	 * �������½�ѧ�ɹ�
	 * @param course
	 * @return
	 */
	public List<Achievement> findLastestSevenAchievements(Course course);
}
