package cn.edu.xmu.course.service.impl;

import java.util.Calendar;
import java.util.List;

import cn.edu.xmu.course.dao.CourseInfoDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseInfo;
import cn.edu.xmu.course.service.ICourseInfoService;

public class CourseInfoService implements ICourseInfoService {
	private CourseInfoDAO courseInfoDAO;

	public boolean addCoureseInfo(CourseInfo courseInfo, Course course) {
		// TODO Auto-generated method stub
		courseInfo.setCourse(course);
		courseInfo.setTime(Calendar.getInstance().getTime());
		try {
			courseInfoDAO.save(courseInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteCourseInfo(CourseInfo courseInfo) {
		// TODO Auto-generated method stub
		try {
			courseInfoDAO.delete(courseInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public CourseInfo getCourseInfoById(Integer courseInfoId) {
		// TODO Auto-generated method stub
		return courseInfoDAO.findById(courseInfoId);
	}

	public List getCourseInfosByCourse(Course course) {
		// TODO Auto-generated method stub
		return courseInfoDAO.findByCourse(course);
	}

	public boolean updateCourseInfo(CourseInfo courseInfo) {
		// TODO Auto-generated method stub
		try {
			courseInfoDAO.merge(courseInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public CourseInfo getCourseInfo(int courseId, int sort) {
		List<CourseInfo> courseInfos = getCourseInfoDAO().findByCourse(
				courseId, sort);
		if (courseInfos.size() == 0)
			return null;
		else
			return courseInfos.get(0);
	}

	public void setCourseInfoDAO(CourseInfoDAO courseInfoDAO) {
		this.courseInfoDAO = courseInfoDAO;
	}

	public CourseInfoDAO getCourseInfoDAO() {
		return courseInfoDAO;
	}

}
