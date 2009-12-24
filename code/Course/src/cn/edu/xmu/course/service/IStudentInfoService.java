package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.UserInfo;

/**
 * 学生信息管理
 * @author 
 *
 */
public interface IStudentInfoService {

	public boolean addStudent(Student student, UserInfo userInfo);
	
	public boolean deleteStudent(Student student);
	
	public List findBySchool(School school);
	
	public Student findById(int id);
	
	public boolean batchAddStudents(List<Student> studentList, List<UserInfo> userInfoList);
	
	public Student findByStudentNo(String studentNo);
	
	public boolean updateStudent(Student student);
	
	public List<Student> findByGrade(Grade grade);
}
