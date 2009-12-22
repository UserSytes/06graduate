package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.CourseDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.ICourseService;

public class CourseService implements ICourseService {

	private CourseDAO courseDAO;

	public boolean addCourse(Course course, Department department,Teacher teacher) {
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
	

	public List findCoursesByTeacher(Integer teacherId,int type) {
		// TODO Auto-generated method stub
		if(type == 2)
			return courseDAO.findByTeacherId(teacherId);
		else
			return courseDAO.findByTeacherAndType(teacherId, type);
	}


	public boolean deleteCourse(Course course) {
		// TODO Auto-generated method stub
		try{
			courseDAO.delete(course);
			return true;
		}catch(Exception e){
			return false;
		}

	}

	
	public Course getCourseById(Integer courseId) {
		// TODO Auto-generated method stub
		return courseDAO.findById(courseId);
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}


}
