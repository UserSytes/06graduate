package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.ChapterDAO;
import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.service.IChapterService;

/**
 * 教学目录编辑
 * 
 * @author 何申密
 * 
 */
public class ChapterService implements IChapterService {
	private ChapterDAO chapterDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.IChapterService#getChapterById(int)
	 */
	public Chapter getChapterById(int chapterId) {
		// TODO Auto-generated method stub
		return chapterDAO.findById(chapterId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IChapterService#addChapter(cn.edu.xmu.course
	 * .pojo.Course, cn.edu.xmu.course.pojo.Chapter)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IChapterService#deleteChapter(cn.edu.xmu.course
	 * .pojo.Chapter)
	 */
	public boolean deleteChapter(Chapter chapter) {
		// TODO Auto-generated method stub
		try {
			chapterDAO.delete(chapter);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IChapterService#getAllChapter(cn.edu.xmu.course
	 * .pojo.Course)
	 */
	public List<Chapter> getAllChapter(Course course) {
		// TODO Auto-generated method stub
		return chapterDAO.findByCourse(course);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IChapterService#updateChapter(cn.edu.xmu.course
	 * .pojo.Chapter)
	 */
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
