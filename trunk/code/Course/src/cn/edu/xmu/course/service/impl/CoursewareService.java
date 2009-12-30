package cn.edu.xmu.course.service.impl;

import java.util.Calendar;
import java.util.List;

import cn.edu.xmu.course.dao.CoursewareDAO;
import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Courseware;
import cn.edu.xmu.course.service.ICoursewareService;

public class CoursewareService implements ICoursewareService {

	private CoursewareDAO coursewareDAO;

	public boolean addCourseware(Courseware courseware, Chapter chapter) {
		// TODO Auto-generated method stub
		courseware.setChapter(chapter);
		courseware.setTime(Calendar.getInstance().getTime());
		try {
			coursewareDAO.save(courseware);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteCourseware(Courseware courseware) {
		// TODO Auto-generated method stub
		try {
			coursewareDAO.delete(courseware);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List getAllCoursewares(Course course) {
		// TODO Auto-generated method stub
		return coursewareDAO.findByCourse(course.getId());
	}

	public Courseware getCoursewareById(Integer id) {
		// TODO Auto-generated method stub
		return coursewareDAO.findById(id);
	}

	public List getCoursewaresByChapter(Chapter chapter) {
		// TODO Auto-generated method stub
		return coursewareDAO.findByChapter(chapter);
	}

	public boolean updateCourseware(Courseware courseware, Chapter chapter) {
		// TODO Auto-generated method stub
		courseware.setChapter(chapter);
		try {
			coursewareDAO.merge(courseware);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setCoursewareDAO(CoursewareDAO coursewareDAO) {
		this.coursewareDAO = coursewareDAO;
	}

	public CoursewareDAO getCoursewareDAO() {
		return coursewareDAO;
	}

}
