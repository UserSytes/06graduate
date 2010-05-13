package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.CourseMovieDAO;
import cn.edu.xmu.course.dao.NoticeDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseMovie;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.service.ICourseMovieService;

public class CourseMovieService implements ICourseMovieService {

	private CourseMovieDAO courseMovieDAO;
	private NoticeDAO noticeDAO;

	public boolean addCourseMovie(CourseMovie courseMovie, Course course,
			File upload) {
		// TODO Auto-generated method stub
		courseMovie.setCourse(course);
		String title = "��ӽ�ѧ¼��" + courseMovie.getTitle() + "��";
		String content = "<p>������½�ѧ¼��" + courseMovie.getTitle()
				+ "������ͬѧ��ע����ġ�</p>";
		Notice notice = new Notice(course, title, content, new Date(), 1);
		try {
			if (upload != null) {
				String path = ServletActionContext.getServletContext()
						.getRealPath("/upload");
				String fileName = path + "/" + courseMovie.getFileLink();
				File file = new File(fileName);
				courseMovie.setSrc("");
				if (!FileOperation.copy(upload, file))
					return false;
			} else {
				courseMovie.setFileLink("");
				courseMovie.setFilename("");
			}
			courseMovieDAO.save(courseMovie);
			noticeDAO.save(notice);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteCourseMovie(CourseMovie courseMovie) {
		// TODO Auto-generated method stub
		try {
			courseMovieDAO.delete(courseMovie);
			String path = ServletActionContext.getServletContext()
			.getRealPath("/upload");
			String fileName = path + "/" + courseMovie.getFileLink();
			File file = new File(fileName);
			FileOperation.delete(file);
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

		String title = "�޸Ľ�ѧ¼��" + courseMovie.getTitle() + "��";
		String content = "<p>�޸ļ��н�ѧ¼��" + courseMovie.getTitle()
				+ "������ͬѧ��ע����ġ�</p>";
		Notice notice = new Notice(courseMovie.getCourse(), title, content,
				new Date(), 1);
		try {
			if (upload != null) {
				String path = ServletActionContext.getServletContext()
						.getRealPath("/upload");
				String fileName = path + "/" + courseMovie.getFileLink();
				File file = new File(fileName);				
				courseMovie.setSrc("");
				if (!FileOperation.copy(upload, file))
					return false;
			} else {
				courseMovie.setFileLink("");
				courseMovie.setFilename("");
			}
			courseMovieDAO.merge(courseMovie);
			noticeDAO.save(notice);
			return true;
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

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

}
