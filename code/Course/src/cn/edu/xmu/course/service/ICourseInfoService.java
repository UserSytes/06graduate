package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.*;

/**
 * 编辑课程信息，包括教学大纲，课程简介等
 * @author Administrator
 *
 */
public interface ICourseInfoService {
	
	/**
	 * 获取该门课程的信息
	 * @param course
	 * @param sort 类型（大纲或者简介）
	 * @return
	 */
	public CourseInfo getCourseInfo(Course course, int sort);
	
	/**
	 * 添加课程信息
	 * @param courseInfo
	 * @param sort
	 * @return
	 */
	public boolean addCoureseInfo(CourseInfo courseInfo, int sort);

	/**
	 * 更新课程信息
	 * @param courseInfo
	 * @param sort
	 * @return
	 */
	public boolean updateCourseInfo(CourseInfo courseInfo, int sort);
	
	/**
	 * 删除课程信息
	 * @param courseInfo
	 * @param sort
	 * @return
	 */
	public boolean deleteCourseInfo(CourseInfo courseInfo, int sort);
	/**
	 * 通过课程Id查找课程简介/大纲
	 * @param courseId
	 * @param sort
	 * @return
	 */
	public CourseInfo getCourseInfo(int courseId,int sort);
}
