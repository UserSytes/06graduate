package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Department;
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
	
	public String addMoreStudent(Student student,Grade grade, Department department, File file);
	
	public boolean deleteStudent(Student student);
	
	public List findBySchool(School school);
	
	public Student findById(int id);
	
	public boolean batchAddStudents(List<Student> studentList, List<UserInfo> userInfoList);
	
	public Student findByStudentNo(String studentNo);
	
	/**
	 * DWR用到的查找
	 * @param studentNo
	 * @return
	 */
	public UserInfo findUserInfoByStudentNo(String studentNo);
	
	public boolean updateStudent(Student student, UserInfo userInfo);
	
	public List<Student> findByGrade(Grade grade);
	
	public List<Student> findByDepartment(Department department);
	
	public List<Student> findByDepartmentAndGrade(Department department, Grade grade);
	
}
