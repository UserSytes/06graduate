package cn.edu.xmu.course.service.impl;

import cn.edu.xmu.course.dao.CourseInfoDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseInfo;
import cn.edu.xmu.course.service.ICourseInfoService;

public class CourseInfoService implements ICourseInfoService {
	private CourseInfoDAO courseInfoDAO;
	public boolean addCoureseInfo(CourseInfo courseInfo, int sort) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteCourseInfo(CourseInfo courseInfo, int sort) {
		// TODO Auto-generated method stub
		return false;
	}

	public CourseInfo getCourseInfo(Course course, int sort) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateCourseInfo(CourseInfo courseInfo, int sort) {
		// TODO Auto-generated method stub
		return false;
	}

	public CourseInfo getCourseInfo(int courseId, int sort) {
		System.out.println("\n&&&&&&&&&&&"+courseId+"&&&&&&&&"+sort);
		return (CourseInfo)getCourseInfoDAO().findByCourse(courseId,sort).get(0);
	}

	public void setCourseInfoDAO(CourseInfoDAO courseInfoDAO) {
		this.courseInfoDAO = courseInfoDAO;
	}

	public CourseInfoDAO getCourseInfoDAO() {
		return courseInfoDAO;
	}

}
