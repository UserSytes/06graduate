package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.StudentDAO;
import cn.edu.xmu.course.dao.TeacherDAO;
import cn.edu.xmu.course.dao.UserInfoDAO;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IStudentInfoService;

public class StudentInfoService implements IStudentInfoService {

	private StudentDAO studentDAO;
	private UserInfoDAO userInfoDAO;
	
	public boolean addStudent(Student student, UserInfo userInfo) {
		// TODO Auto-generated method stub
		try{
			studentDAO.save(student);
			userInfoDAO.save(userInfo);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	public boolean batchAddStudents(List<Student> studentList,
			List<UserInfo> userInfoList) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		try{		
			userInfoDAO.delete(student.getUserInfo());
			studentDAO.delete(student);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public List<Student> findByGrade(Grade grade) {
		// TODO Auto-generated method stub
		return studentDAO.findByProperty("grade", grade);
	}

	public Student findById(int id) {
		// TODO Auto-generated method stub
		return  studentDAO.findById(id);
	}

	public List findBySchool(School school) {
		// TODO Auto-generated method stub
		return studentDAO.findBySchool(school);
	}

	public Student findByStudentNo(String studentNo) {
		// TODO Auto-generated method stub
		List<Student> students = studentDAO.findByStudentNo(studentNo);
		if(students.size()==0){
			return null;
		}else{
			return students.get(0);
		}
	}

	public boolean updateStudent(Student student, UserInfo userInfo) {
		// TODO Auto-generated method stub
		try{
			userInfoDAO.merge(userInfo);
			studentDAO.merge(student);
			return true;
		}catch(Exception e){
			return false;
		}
	}
 
	public List<Student> findByDepartment(Department department){
		return studentDAO.findByDepartment(department);
	}
	
	public List<Student> findByDepartmentAndGrade(Department department, Grade grade){
		return studentDAO.findByDepartmentAndGrade(department, grade);
	}
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public UserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

}
