package cn.edu.xmu.course.service.impl;

import cn.edu.xmu.course.dao.CourseDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.ICourseService;

public class CourseService implements ICourseService {

	private CourseDAO courseDAO;
	
	
	public boolean addCourse(Course course, Department department) {
		// TODO Auto-generated method stub
		course.setDepartment(department);
		try {
			courseDAO.save(course);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean applyCourse(Teacher teacher, Course course
			) {
				return false;
		// TODO Auto-generated method stub
//		teacherCourse.setCourse(course);
//		teacherCourse.setTeacher(teacher);
//		teacherCourse.setStatus(0);
//		try {
//			teacherCourseDAO.save(teacherCourse);
//			return true;
//		}catch(Exception e){
//			return false;
//		}
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
