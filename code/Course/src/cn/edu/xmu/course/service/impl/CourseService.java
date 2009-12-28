package cn.edu.xmu.course.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.components.Set;

import cn.edu.xmu.course.dao.CourseDAO;
import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.ICourseService;

public class CourseService implements ICourseService {

	private CourseDAO courseDAO;
	private List<Course> courses;
	private List<Course> tempList;
	private ApplicationForm applicationForm;

	public boolean addCourse(Course course, Department department,
			Teacher teacher) {
		// TODO Auto-generated method stub
		course.setDepartment(department);
		course.setStatus(0);
		course.setTeacher(teacher);
		try {
			courseDAO.save(course);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List findCoursesByTeacher(Integer teacherId, int type) {
		// TODO Auto-generated method stub
		if (type == 2)
			return courseDAO.findByTeacherId(teacherId);
		else
			return courseDAO.findByTeacherAndType(teacherId, type);
	}

	public boolean deleteCourse(Course course) {
		// TODO Auto-generated method stub
		try {
			courseDAO.delete(course);
			return true;
		} catch (Exception e) {
			return false;
		}

	}


	public List findCourseListByTimeAndLevel(String time, String level) {
		courses = courseDAO.findAll();
		tempList = null;
		for (int i = 0; i < courses.size(); i++)
		{
			Course course = courses.get(i);
			if (course.getLevel().equals(level)) {
				tempList.add(course);
			}
		}
		for (int i = 0; i <tempList.size(); i++) {
			applicationForm=(ApplicationForm)tempList.get(i)
			.getApplicationForms().iterator().next();
			if (!applicationForm.getTime().toString().substring(0, 3)
					.equals(time))
				tempList.remove(i);
		}
		return tempList;
	}

	private List<Course> getCourses() {
		return courses;
	}

	private void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	private List<Course> getTempList() {
		return tempList;
	}

	private void setTempList(List<Course> tempList) {
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

	public List<Course> findApplicationCourse(School school) {
		return courseDAO.findApplicationBySchool(school);
	}

	public List<Course> findNoPassCourse(School school) {
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

	/**
	 * 
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
