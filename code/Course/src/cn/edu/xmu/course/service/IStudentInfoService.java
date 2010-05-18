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
 * @author 郑冰凌
 *
 */
public interface IStudentInfoService {

	/**
	 * 添加学生
	 * @param student
	 * @param userInfo
	 * @return
	 */
	public boolean addStudent(Student student, UserInfo userInfo);
	
	/**
	 * 删除学生
	 * @param student
	 * @return
	 */
	public boolean deleteStudent(Student student);
	
	/**
	 * 批量删除学生
	 * @param grade
	 * @param department
	 * @return
	 */
	public int deleteMoreStudent(Grade grade, Department department );
	
	/**
	 * 根据学院查找学生
	 * @param school
	 * @return
	 */
	public List findBySchool(School school);
	
	/**
	 * 根据id查获学生
	 * @param id
	 * @return
	 */
	public Student findById(int id);
	
	/**
	 * 根据用户信息查找学生
	 * @param userInfo
	 * @return
	 */
	public Student findByUserInfo(UserInfo userInfo);
	
	/**
	 * 根据学号查找学生
	 * @param studentNo
	 * @return
	 */
	public Student findByStudentNo(String studentNo);
	
	/**
	 * 根据学号查找学生
	 * @param studentNo
	 * @param school
	 * @return
	 */
	public List findByStudentNoFuzzy(String studentNo , School school);
	
	/**
	 * DWR用到的根据学号查找学生信息
	 * @param studentNo
	 * @return
	 */
	public UserInfo findUserInfoByStudentNo(String studentNo);
	
	/**
	 * 更新学生信息
	 * @param student
	 * @param userInfo
	 * @return
	 */
	public boolean updateStudent(Student student, UserInfo userInfo);
	
	/**
	 * 修改密码
	 * @param student
	 * @return
	 */
	public boolean updatePassword(Student student);
	
	/**
	 * 根据年级查找学生
	 * @param grade
	 * @return
	 */
	public List<Student> findByGrade(Grade grade);
	
	/**
	 * 根据系查找学生
	 * @param department
	 * @return
	 */
	public List<Student> findByDepartment(Department department);
	
	/**
	 * 根据系、年级查找学生
	 * @param department
	 * @param grade
	 * @return
	 */
	public List<Student> findByDepartmentAndGrade(Department department, Grade grade);
	
	/**
	 * 批量添加学生
	 * @param grade
	 * @param department
	 * @param file
	 * @return
	 */
	public String addMoreStudent(Grade grade, Department department, File file) ;
	
	/**
	 * 修改学生头像
	 * @param userInfo
	 * @param photo
	 * @param oldPhoto
	 * @return
	 */
	public boolean addStudentPhoto(UserInfo userInfo, File photo,String oldPhoto);
	
	/**
	 * 根据系查找学生信息
	 * @param department
	 * @return
	 */
	public List getStuNameAndNumber(Department department);

}
