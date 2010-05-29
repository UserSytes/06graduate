package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Courseware;

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
	public List<Courseware> getAllCoursewares(Course course);
	
	/**
	 * 查找该目录下所有的习题
	 * @param chapter
	 * @return
	 */
	public List<Courseware> getCoursewaresByChapter(Chapter chapter);
	
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
	public boolean addCourseware(Courseware courseware, Chapter chapter, File upload);

	/**
	 * 添加习题
	 * @param courseware
	 * @param chapter
	 * @return
	 */
	public boolean updateCourseware(Courseware courseware, Chapter chapter, File upload);
	
	/**
	 * 删除习题
	 * @param courseware
	 * @return
	 */
	public boolean deleteCourseware(Courseware courseware);
}
