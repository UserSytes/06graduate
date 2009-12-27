package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.AchievementDAO;
import cn.edu.xmu.course.pojo.Achievement;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Student;
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

	@SuppressWarnings("unchecked")
	public Achievement getAchievement(int courseId) {
		List<Achievement> achievements = achievementDAO.findByCourse(courseId);;
		if(achievements.size()==0){
			return null;
		}else{
			return achievements.get(0);
		}
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
