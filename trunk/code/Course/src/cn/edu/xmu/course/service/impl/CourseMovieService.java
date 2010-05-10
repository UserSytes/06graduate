package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.CourseMovieDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseMovie;
import cn.edu.xmu.course.service.ICourseMovieService;

public class CourseMovieService implements ICourseMovieService {

	private CourseMovieDAO courseMovieDAO;

	public boolean addCourseMovie(CourseMovie courseMovie, Course course,
			File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + courseMovie.getFileLink();
		File file = new File(fileName);
		courseMovie.setCourse(course);
		try {			
			if (FileOperation.copy(upload, file)){
				courseMovieDAO.save(courseMovie);
				return true;
			}				
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteCourseMovie(CourseMovie courseMovie) {
		// TODO Auto-generated method stub
		try {
			courseMovieDAO.delete(courseMovie);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List getAllCourseMovies(Course course) {
		// TODO Auto-generated method stub
		return courseMovieDAO.findByCourse(course);
	}

	public CourseMovie getCourseMovieById(Integer id) {
		// TODO Auto-generated method stub
		return courseMovieDAO.findById(id);
	}

	public boolean updateCourseMovie(CourseMovie courseMovie, File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + courseMovie.getFileLink();
		File file = new File(fileName);
		try {			
			if (FileOperation.copy(upload, file)){
				courseMovieDAO.merge(courseMovie);
				return true;
			}			
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void setCourseMovieDAO(CourseMovieDAO courseMovieDAO) {
		this.courseMovieDAO = courseMovieDAO;
	}

	public CourseMovieDAO getCourseMovieDAO() {
		return courseMovieDAO;
	}

}
