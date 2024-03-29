package cn.edu.xmu.course.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.CourseDAO;
import cn.edu.xmu.course.dao.PopedomDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Popedom;
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
	private PopedomDAO popedomDAO;

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
		Popedom popedom = new Popedom(0,0,0,0,0,0,0,null);
		course.setPopedom(popedom);
		try {
			getCourseDAO().save(course);
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
	public List<Course> findCoursesByTeacher(Integer teacherId, int type) {
		// TODO Auto-generated method stub
		if (type == 3)
			return getCourseDAO().findByTeacherId(teacherId);
		else
			return getCourseDAO().findByTeacherAndType(teacherId, type);
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
		String fileName = path + "/" + course.getTeacher().getTeacherNo()
				+ course.getTeacher().getUserInfo().getName() + "/"
				+ course.getName();
		try {
			if (!FileOperation.delFolder(fileName)) {
				return false;
			}
			getCourseDAO().delete(course);
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
	public List<Course> findCourseListLevel(String level) {
		List<Course> courses = getCourseDAO().findByLevel(level);
		return courses;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseService#findCourseListByLevel(java.lang
	 * .String)
	 */
	public List<Course> findCourseListByLevel(String level) {
		List<Course> courses = getCourseDAO().findByLevel(level);
		return courses;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseService#getCourseById(java.lang.Integer)
	 */
	public Course getCourseById(Integer courseId) {
		// TODO Auto-generated method stub
		return getCourseDAO().findById(courseId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseService#findApplicationCourse(cn.edu
	 * .xmu.course.pojo.School)
	 */
	public List<Course> findApplicationCourse(School school) {
		return getCourseDAO().findApplicationBySchool(school);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseService#findNoPassCourse(cn.edu.xmu.
	 * course.pojo.School)
	 */
	public List<Course> findNoPassCourse(School school) {
		return getCourseDAO().findNotPassBySchool(school);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ICourseService#findBySchool(cn.edu.xmu.course
	 * .pojo.School)
	 */
	public List<Course> findBySchool(School school) {
		return getCourseDAO().findBySchool(school);
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
			getCourseDAO().merge(course);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean updatePopedom(Popedom popedom){
		try {
			popedomDAO.merge(popedom);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setPopedomDAO(PopedomDAO popedomDAO) {
		this.popedomDAO = popedomDAO;
	}

	public PopedomDAO getPopedomDAO() {
		return popedomDAO;
	}

}
