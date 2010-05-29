package cn.edu.xmu.course.service.impl;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.dao.CourseInfoDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseInfo;
import cn.edu.xmu.course.service.ICourseInfoService;

/**
 * 编辑课程信息，包括教学大纲，课程简介等
 * 
 * @author 何申密
 * @author 许子彦
 * 
 */
public class CourseInfoService implements ICourseInfoService {

	private CourseInfoDAO courseInfoDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseInfoService#addCoureseInfo(cn.edu.xmu
	 * .course.pojo.CourseInfo, cn.edu.xmu.course.pojo.Course)
	 */
	public boolean addCoureseInfo(CourseInfo courseInfo, Course course) {
		// TODO Auto-generated method stub
		courseInfo.setCourse(course);
		courseInfo.setTime(new Date());
		try {
			courseInfoDAO.save(courseInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseInfoService#deleteCourseInfo(cn.edu.
	 * xmu.course.pojo.CourseInfo)
	 */
	public boolean deleteCourseInfo(CourseInfo courseInfo) {
		// TODO Auto-generated method stub
		try {
			courseInfoDAO.delete(courseInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseInfoService#getCourseInfoById(java.lang
	 * .Integer)
	 */
	public CourseInfo getCourseInfoById(Integer courseInfoId) {
		// TODO Auto-generated method stub
		return courseInfoDAO.findById(courseInfoId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseInfoService#getCourseInfosByCourse(cn
	 * .edu.xmu.course.pojo.Course)
	 */
	public List<CourseInfo> getCourseInfosByCourse(Course course) {
		// TODO Auto-generated method stub
		return courseInfoDAO.findByCourse(course);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseInfoService#updateCourseInfo(cn.edu.
	 * xmu.course.pojo.CourseInfo)
	 */
	public boolean updateCourseInfo(CourseInfo courseInfo) {
		// TODO Auto-generated method stub
		courseInfo.setTime(new Date());
		try {
			courseInfoDAO.merge(courseInfo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.ICourseInfoService#getCourseInfo(int, int)
	 */
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
