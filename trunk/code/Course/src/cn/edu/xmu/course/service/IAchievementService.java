package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * ��ѧ�ɹ�
 * @author Administrator
 *
 */
public interface IAchievementService {

	/**
	 * ����ID���ҽ�ѧ�ɹ�
	 * @param teacherCourse
	 * @return
	 */
	public Achievement getAchievementById(Integer id);
	
	
	//�޸ĵ�ʱ����Ҫ�Ѹ÷���ȥ��
	/**
	 * ���Ҹÿγ̵Ľ�ѧ�ɹ�
	 * @param teacherCourse
	 * @return
	 */
	public Achievement getAchievement(int courseId);
	
	/**
	 * ���Ҹÿγ����еĽ�ѧ�ɹ�
	 * @param teacherCourse
	 * @return
	 */
	public List getAllAchievements(Course course);
	
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
	public List findLastestSevenAchievements(Course course);
}
