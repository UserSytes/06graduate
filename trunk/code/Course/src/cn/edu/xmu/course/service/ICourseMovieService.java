package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseMovie;

/**
 * 课程录像
 * @author 何申密
 * @author 许子彦
 *
 */
public interface ICourseMovieService {

	/**
	 * 查找所有课程录像
	 * @param teacherCourse
	 * @return
	 */
	public List<CourseMovie> getAllCourseMovies(Course course);
	
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
	public boolean addCourseMovie(CourseMovie courseMovie, Course course, File upload);
	
	/**
	 * 更新课程录像
	 * @param courseMovie
	 * @return
	 */
	public boolean updateCourseMovie(CourseMovie courseMovie, File upload);
	
	/**
	 * 删除课程录像
	 * @param courseMovie
	 * @return
	 */
	public boolean deleteCourseMovie(CourseMovie courseMovie);
}
