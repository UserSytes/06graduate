package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.CollectionDAO;
import cn.edu.xmu.course.dao.CourseDAO;
import cn.edu.xmu.course.dao.StudentCourseDAO;
import cn.edu.xmu.course.dao.StudentDAO;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Collection;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.StudentCourse;
import cn.edu.xmu.course.service.IStudentCourseService;
/**
 * 
 * @author Sky
 *
 */
public class StudentCourseService implements IStudentCourseService {

	private StudentCourseDAO studentCourseDAO;
	private CollectionDAO collectionDAO;
	private StudentDAO studentDAO;
	
	public boolean deleteCollection(Student student, Course course){
		Collection c = (Collection) collectionDAO.findByStudentAndCourse(course, student).get(0);
		if(c != null){
			try{
				collectionDAO.delete(c);
				return true;
			}catch(Exception e){
				return false;
			}
		}else{
			return false;
		}
	}
	
	public List<Collection> findCollectionByStudent(Student student){
		return collectionDAO.findByProperty("student", student);
	}
	
	public List<StudentCourse> findByCourse(Course course) {
		// TODO Auto-generated method stub
		return studentCourseDAO.findByProperty("course", course);
	}
	
	public Student findStudentById(int id){
		return studentDAO.findById(id);
	}
	
	public Student findStudentByStudentNo(String studentNo){
		return (Student) studentDAO.findByStudentNo(studentNo).get(0);
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
	
	public boolean updateStudentCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		try{
			studentCourseDAO.merge(studentCourse);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public List<StudentCourse> findByStudent(Student student){
		return studentCourseDAO.findByProperty("student", student);
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

	public CollectionDAO getCollectionDAO() {
		return collectionDAO;
	}

	public void setCollectionDAO(CollectionDAO collectionDAO) {
		this.collectionDAO = collectionDAO;
	}

}
