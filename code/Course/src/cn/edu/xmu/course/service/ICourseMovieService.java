package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * �γ�¼��
 * @author Administrator
 *
 */
public interface ICourseMovieService {

	/**
	 * �������пγ�¼��
	 * @param teacherCourse
	 * @return
	 */
	public List getAllCourseMovies(TeacherCourse teacherCourse);
	
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
	public boolean addCourseMovie(CourseMovie courseMovie, TeacherCourse teacherCourse);
	
	/**
	 * ���¿γ�¼��
	 * @param courseMovie
	 * @return
	 */
	public boolean updateCourseMovie(CourseMovie courseMovie);
	
	/**
	 * ɾ���γ�¼��
	 * @param courseMovie
	 * @return
	 */
	public boolean deleteCourseMovie(CourseMovie courseMovie);
}
