package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.StudentCourseDAO;
import cn.edu.xmu.course.dao.StudentDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.service.IStudentCourseService;

public class StudentCourseService implements IStudentCourseService {

	private StudentCourseDAO studentCourseDAO;
	private StudentDAO studentDAO;

	public List<StudentCourse> findByCourse(Course course) {
		// TODO Auto-generated method stub
		return studentCourseDAO.findByProperty("course", course);
	}
	
	public Student findStudentById(int id){
		return studentDAO.findById(id);
	}
	
	public boolean delete(Course course, Student student){
		StudentCourse sc = (StudentCourse) studentCourseDAO.findByStudentAndCourse(course, student).get(0);
		if(sc != null){
			try{
				studentCourseDAO.delete(sc);
				return true;
			}catch(Exception e){
				return false;
			}
		}else{
			return false;
		}
	}

	public boolean addStudentCourse(StudentCourse studentCourse){
		try{
			studentCourseDAO.save(studentCourse);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public StudentCourseDAO getStudentCourseDAO() {
		return studentCourseDAO;
	}

	public void setStudentCourseDAO(StudentCourseDAO studentCourseDAO) {
		this.studentCourseDAO = studentCourseDAO;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	
}
