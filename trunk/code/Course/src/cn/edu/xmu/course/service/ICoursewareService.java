package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * 课程教案
 * @author Administrator
 *
 */
public interface ICoursewareService {

	/**
	 * 查找该课程所有的实验
	 * @param teacherCoures
	 * @return
	 */
	public List getAllCoursewares(TeacherCourse teacherCoures);
	
	/**
	 * 查找该目录下所有的习题
	 * @param chapter
	 * @return
	 */
	public List getCoursewaresByChapter(Chapter chapter);
	
	/**
	 * 获得该习题
	 * @param id
	 * @return
	 */
	public Courseware getCoursewareById(Integer id);
	
	/**
	 * 添加新的习题
	 * @param Courseware
	 * @param chapter
	 * @return
	 */
	public boolean addCourseware(Courseware courseware, Chapter chapter);

	/**
	 * 添加习题
	 * @param courseware
	 * @param chapter
	 * @return
	 */
	public boolean updateCourseware(Courseware courseware, Chapter chapter);
	
	/**
	 * 删除习题
	 * @param courseware
	 * @return
	 */
	public boolean deleteCourseware(Courseware courseware);
}
