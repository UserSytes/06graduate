package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;

/**
 * 教学目录编辑
 * @author 何申密
 *
 */
public interface IChapterService {

	/**
	 * 根据id查找目录
	 * @param chapterId
	 * @return
	 */
	public Chapter getChapterById(int chapterId);
	
	/**
	 * 获得该课程所有目录
	 * @param teacherCourse
	 * @return
	 */
	public List<Chapter> getAllChapter(Course course);
	
	/**
	 * 添加课程目录
	 * @param teacherCourse
	 * @param chapter
	 * @return
	 */
	public boolean addChapter(Course course, Chapter chapter);

	/**
	 * 更新课程目录
	 * @param teacherCourse
	 * @param chapter
	 * @return
	 */
	public boolean updateChapter(Chapter chapter);
	
	/**
	 * 删除课程目录
	 * @param chapter
	 * @return
	 */
	public boolean deleteChapter(Chapter chapter);

	
}
