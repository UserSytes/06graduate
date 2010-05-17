package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.AchievementDAO;
import cn.edu.xmu.course.dao.NoticeDAO;
import cn.edu.xmu.course.pojo.Achievement;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.service.IAchievementService;

public class AchievementService implements IAchievementService {
	private AchievementDAO achievementDAO;
	private NoticeDAO noticeDAO;

	public boolean addAchievement(Course course, Achievement achievement,
			File upload) {
		// TODO Auto-generated method stub
		achievement.setCourse(course);
		String title = "��ӳɹ���" + achievement.getTitle() + "��";
		String content = "<p>������³ɹ���" + achievement.getTitle()
				+ "������ͬѧ��ע����ġ�</p>";
		Notice notice = new Notice(course, title, content, new Date(), 1);
		try {
			if (upload != null) {
				String path = ServletActionContext.getServletContext()
						.getRealPath("/upload");
				String fileName = path + "/" + achievement.getFileLink();
				File file = new File(fileName);
				if (!FileOperation.copy(upload, file))
					return false;
			} else {
				achievement.setFileLink("");
				achievement.setFileName("");
			}
			achievementDAO.save(achievement);
			noticeDAO.save(notice);
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
		String title = "�޸ĳɹ���" + achievement.getTitle() + "��";
		String content = "<p>�޸����гɹ���" + achievement.getTitle()
				+ "������ͬѧ��ע����ġ�</p>";
		Notice notice = new Notice(achievement.getCourse(), title, content,
				new Date(), 1);
		try {
			if (upload != null) {
				String path = ServletActionContext.getServletContext()
						.getRealPath("/upload");
				String fileName = path + "/" + achievement.getFileLink();
				File file = new File(fileName);
				if (!FileOperation.copy(upload, file))
					return false;
			} else {
				achievement.setFileLink("");
				achievement.setFileName("");
			}
			achievementDAO.merge(achievement);
			noticeDAO.save(notice);
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

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

	/*
	 * ���� ���½�ѧ�ɹ�(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IAchievementService#findLastestSevenAchievements
	 * (cn.edu.xmu.course.pojo.Course)
	 */
	public List findLastestSevenAchievements(Course course) {
		// TODO Auto-generated method stub
		return achievementDAO.findLastestSevenAchievements(course);
	}

}
