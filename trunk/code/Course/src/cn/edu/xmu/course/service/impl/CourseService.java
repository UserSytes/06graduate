package cn.edu.xmu.course.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.CourseDAO;
import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.ICourseService;

/**
 * 管理课程信息的类
 * 
 * @author 郑冰凌
 * @author 何申密
 * 
 */
public class CourseService implements ICourseService {

	private CourseDAO courseDAO;
	private List courses;
	private List tempList;
	private ApplicationForm applicationForm;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseService#addCourse(cn.edu.xmu.course.
	 * pojo.Course, cn.edu.xmu.course.pojo.Department,
	 * cn.edu.xmu.course.pojo.Teacher)
	 */
	public boolean addCourse(Course course, Department department,
			Teacher teacher) {
		// TODO Auto-generated method stub
		course.setDepartment(department);
		course.setStatus(0);
		course.setTeacher(teacher);
		course.setVisible(1);
		course.setCount(0);
		course.setStyle("blue");
		course.setHeader("header.jsp");
		course.setTime(new Date());
		try {
			courseDAO.save(course);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseService#findCoursesByTeacher(java.lang
	 * .Integer, int)
	 */
	public List findCoursesByTeacher(Integer teacherId, int type) {
		// TODO Auto-generated method stub
		if (type == 3)
			return courseDAO.findByTeacherId(teacherId);
		else
			return courseDAO.findByTeacherAndType(teacherId, type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseService#deleteCourse(cn.edu.xmu.course
	 * .pojo.Course)
	 */
	public boolean deleteCourse(Course course) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/"
				+ course.getTeacher().getTeacherNo()+course.getTeacher().getUserInfo().getName() + "/"
				+ course.getName();
		try {
			if (!FileOperation.delFolder(fileName)) {
				return false;
			}
			courseDAO.delete(course);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseService#findCourseListLevel(java.lang
	 * .String)
	 */
	public List findCourseListLevel(String level) {
		courses = courseDAO.findByLevel(level);
		return courses;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseService#findCourseListByLevel(java.lang
	 * .String)
	 */
	public List findCourseListByLevel(String level) {
		courses = courseDAO.findByLevel(level);
		return courses;
	}

	private List getCourses() {
		return courses;
	}

	private void setCourses(List courses) {
		this.courses = courses;
	}

	private List getTempList() {
		return tempList;
	}

	private void setTempList(List tempList) {
		this.tempList = tempList;
	}

	private ApplicationForm getApplicationForm() {
		return applicationForm;
	}

	private void setApplicationForm(ApplicationForm applicationForm) {
		this.applicationForm = applicationForm;
	}

	public Course getCourseById(Integer courseId) {
		// TODO Auto-generated method stub
		return courseDAO.findById(courseId);
	}

	public List findApplicationCourse(School school) {
		return courseDAO.findApplicationBySchool(school);
	}

	public List findNoPassCourse(School school) {
		return courseDAO.findNotPassBySchool(school);
	}

	public List<Course> findBySchool(School school) {
		return courseDAO.findBySchool(school);
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseService#updateCourse(cn.edu.xmu.course
	 * .pojo.Course)
	 */
	public boolean updateCourse(Course course) {
		// TODO Auto-generated method stub
		try {
			courseDAO.merge(course);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
