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
	 * 获得该课程所有目录
	 * @param teacherCourse
	 * @return
	 */
	public List getAllChapter(TeacherCourse teacherCourse);
	
	/**
	 * 添加课程目录
	 * @param teacherCourse
	 * @param chapter
	 * @return
	 */
	public boolean addChapter(TeacherCourse teacherCourse, Chapter chapter);

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
	public boolean addChapter(Chapter chapter);
	
	
}
