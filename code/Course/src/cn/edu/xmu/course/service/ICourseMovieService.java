package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * 课程录像
 * @author Administrator
 *
 */
public interface ICourseMovieService {

	/**
	 * 查找所有课程录像
	 * @param teacherCourse
	 * @return
	 */
	public List getAllCourseMovies(TeacherCourse teacherCourse);
	
	/**
	 * 查找课程录像
	 * @param id
	 * @return
	 */
	public CourseMovie getCourseMovieById(Integer id);
	
	/**
	 * 添加课程录像
	 * @param courseMovie
	 * @param teacherCourse
	 * @return
	 */
	public boolean addCourseMovie(CourseMovie courseMovie, TeacherCourse teacherCourse);
	
	/**
	 * 更新课程录像
	 * @param courseMovie
	 * @return
	 */
	public boolean updateCourseMovie(CourseMovie courseMovie);
	
	/**
	 * 删除课程录像
	 * @param courseMovie
	 * @return
	 */
	public boolean deleteCourseMovie(CourseMovie courseMovie);
}
