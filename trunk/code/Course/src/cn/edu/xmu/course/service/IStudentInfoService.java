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
 * ѧ����Ϣ����
 * @author ֣����
 *
 */
public interface IStudentInfoService {

	/**
	 * ���ѧ��
	 * @param student
	 * @param userInfo
	 * @return
	 */
	public boolean addStudent(Student student, UserInfo userInfo);
	
	/**
	 * ɾ��ѧ��
	 * @param student
	 * @return
	 */
	public boolean deleteStudent(Student student);
	
	/**
	 * ����ɾ��ѧ��
	 * @param grade
	 * @param department
	 * @return
	 */
	public int deleteMoreStudent(Grade grade, Department department );
	
	/**
	 * ����ѧԺ����ѧ��
	 * @param school
	 * @return
	 */
	public List findBySchool(School school);
	
	/**
	 * ����id���ѧ��
	 * @param id
	 * @return
	 */
	public Student findById(int id);
	
	/**
	 * �����û���Ϣ����ѧ��
	 * @param userInfo
	 * @return
	 */
	public Student findByUserInfo(UserInfo userInfo);
	
	/**
	 * ����ѧ�Ų���ѧ��
	 * @param studentNo
	 * @return
	 */
	public Student findByStudentNo(String studentNo);
	
	/**
	 * ����ѧ�Ų���ѧ��
	 * @param studentNo
	 * @param school
	 * @return
	 */
	public List findByStudentNoFuzzy(String studentNo , School school);
	
	/**
	 * DWR�õ��ĸ���ѧ�Ų���ѧ����Ϣ
	 * @param studentNo
	 * @return
	 */
	public UserInfo findUserInfoByStudentNo(String studentNo);
	
	/**
	 * ����ѧ����Ϣ
	 * @param student
	 * @param userInfo
	 * @return
	 */
	public boolean updateStudent(Student student, UserInfo userInfo);
	
	/**
	 * �޸�����
	 * @param student
	 * @return
	 */
	public boolean updatePassword(Student student);
	
	/**
	 * �����꼶����ѧ��
	 * @param grade
	 * @return
	 */
	public List<Student> findByGrade(Grade grade);
	
	/**
	 * ����ϵ����ѧ��
	 * @param department
	 * @return
	 */
	public List<Student> findByDepartment(Department department);
	
	/**
	 * ����ϵ���꼶����ѧ��
	 * @param department
	 * @param grade
	 * @return
	 */
	public List<Student> findByDepartmentAndGrade(Department department, Grade grade);
	
	/**
	 * �������ѧ��
	 * @param grade
	 * @param department
	 * @param file
	 * @return
	 */
	public String addMoreStudent(Grade grade, Department department, File file) ;
	
	/**
	 * �޸�ѧ��ͷ��
	 * @param userInfo
	 * @param photo
	 * @param oldPhoto
	 * @return
	 */
	public boolean addStudentPhoto(UserInfo userInfo, File photo,String oldPhoto);
	
	/**
	 * ����ϵ����ѧ����Ϣ
	 * @param department
	 * @return
	 */
	public List getStuNameAndNumber(Department department);

}
