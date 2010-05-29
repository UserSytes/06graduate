package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseMovie;

/**
 * �γ�¼��
 * @author ������
 * @author ������
 *
 */
public interface ICourseMovieService {

	/**
	 * �������пγ�¼��
	 * @param teacherCourse
	 * @return
	 */
	public List<CourseMovie> getAllCourseMovies(Course course);
	
	/**
	 * ���ҿγ�¼��
	 * @param id
	 * @return
	 */
	public CourseMovie getCourseMovieById(Integer id);
	
	/**
	 * ��ӿγ�¼��
	 * @param courseMovie
	 * @param teacherCourse
	 * @return
	 */
	public boolean addCourseMovie(CourseMovie courseMovie, Course course, File upload);
	
	/**
	 * ���¿γ�¼��
	 * @param courseMovie
	 * @return
	 */
	public boolean updateCourseMovie(CourseMovie courseMovie, File upload);
	
	/**
	 * ɾ���γ�¼��
	 * @param courseMovie
	 * @return
	 */
	public boolean deleteCourseMovie(CourseMovie courseMovie);
}
