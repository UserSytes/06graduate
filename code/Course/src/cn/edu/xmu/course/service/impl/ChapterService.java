package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.ChapterDAO;
import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.service.IChapterService;

public class ChapterService implements IChapterService {

	private ChapterDAO chapterDAO;

	public boolean addChapter(Course course, Chapter chapter) {
		// TODO Auto-generated method stub
		chapter.setCourse(course);
		try {
			chapterDAO.save(chapter);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteChapter(Chapter chapter) {
		// TODO Auto-generated method stub
		try {
			chapterDAO.delete(chapter);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List getAllChapter(Course course) {
		// TODO Auto-generated method stub
		return chapterDAO.findByCourse(course);
	}

	public boolean updateChapter(Chapter chapter) {
		// TODO Auto-generated method stub
		try {
			chapterDAO.merge(chapter);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setChapterDAO(ChapterDAO chapterDAO) {
		this.chapterDAO = chapterDAO;
	}

	public ChapterDAO getChapterDAO() {
		return chapterDAO;
	}

}
