package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * 编辑课程信息，包括教学大纲，课程简介等
 * @author Administrator
 *
 */
public interface ICourseInfoService {
	
	/**
	 * 查找当前课程信息
	 * @param course
	 * @return
	 */
	public List getCourseInfosByCourse(Course course);
	
	/**
	 * 根据课程信息Id查找该课程信息
	 * @param courseInfoId
	 * @return
	 */
	public CourseInfo getCourseInfoById(Integer courseInfoId);
	
	/**
	 * 添加课程信息
	 * @param courseInfo
	 * @param sort
	 * @return
	 */
	public boolean addCoureseInfo(CourseInfo courseInfo,Course course);

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
	public boolean deleteCourseInfo(CourseInfo courseInfo);
	/**
	 * 通过课程Id查找课程简介/大纲
	 * @param courseId
	 * @param sort
	 * @return
	 */
	public CourseInfo getCourseInfo(int courseId,int sort);
}
