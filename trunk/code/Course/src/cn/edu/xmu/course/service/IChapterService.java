package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * 教学目录编辑
 * @author Administrator
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
	public List getAllChapter(Course course);
	
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
	/**
	 * 通过课程查找
	 * @param courseId
	 * @return
	 */
	public List getAllChapter(int courseId);
	
	public Chapter getChapter(int chapterId);
	
}
