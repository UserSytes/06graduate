package cn.edu.xmu.course.service.impl;

import cn.edu.xmu.course.dao.AchievementDAO;
import cn.edu.xmu.course.pojo.Achievement;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.service.IAchievementService;

public class AchievementService implements IAchievementService {
	private AchievementDAO achievementDAO;
	public boolean addAchievement(Course course, Achievement achievement) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteAchievement(Achievement achievement) {
		// TODO Auto-generated method stub
		return false;
	}

	public Achievement getAchievement(int courseId) {
		return achievementDAO.findByCourse(courseId);
	}

	public boolean updateAchievement(Achievement achievement) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setAchievementDAO(AchievementDAO achievementDAO) {
		this.achievementDAO = achievementDAO;
	}

	public AchievementDAO getAchievementDAO() {
		return achievementDAO;
	}



}
