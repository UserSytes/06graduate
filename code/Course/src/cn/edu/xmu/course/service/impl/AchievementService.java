package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.AchievementDAO;
import cn.edu.xmu.course.pojo.Achievement;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.service.IAchievementService;

public class AchievementService implements IAchievementService {
	private AchievementDAO achievementDAO;

	public boolean addAchievement(Course course, Achievement achievement,
			File upload) {
		// TODO Auto-generated method stub
		achievement.setCourse(course);
		try {
			achievementDAO.save(achievement);
			if (upload != null) {
				String path = ServletActionContext.getServletContext()
						.getRealPath("/upload");
				String fileName = path + "/" + achievement.getFileLink();
				File file = new File(fileName);
				if (FileOperation.copy(upload, file))
					return true;
				else
					return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteAchievement(Achievement achievement) {
		// TODO Auto-generated method stub
		try {
			achievementDAO.delete(achievement);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public Achievement getAchievement(int courseId) {
		List<Achievement> achievements = achievementDAO.findByCourse(courseId);
		;
		if (achievements.size() == 0) {
			return null;
		} else {
			return achievements.get(0);
		}
	}

	public List getAllAchievements(Course course) {
		// TODO Auto-generated method stub
		return achievementDAO.findByCourse(course);
	}

	public Achievement getAchievementById(Integer id) {
		// TODO Auto-generated method stub
		return achievementDAO.findById(id);
	}

	public boolean updateAchievement(Achievement achievement, File upload) {
		// TODO Auto-generated method stub

		try {
			achievementDAO.merge(achievement);
			if (upload != null) {
				String path = ServletActionContext.getServletContext()
						.getRealPath("/upload");
				String fileName = path + "/" + achievement.getFileLink();
				File file = new File(fileName);
				if (FileOperation.copy(upload, file))
					return true;
				else
					return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setAchievementDAO(AchievementDAO achievementDAO) {
		this.achievementDAO = achievementDAO;
	}

	public AchievementDAO getAchievementDAO() {
		return achievementDAO;
	}

}
