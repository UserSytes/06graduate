package cn.edu.xmu.course.service;

import java.util.List;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;

/**
 * �˽ӿ��Ǹ��𳬼�����Աҵ���service�ӿڣ���Ҫ����Ժϵ�����꼶����ģ��
 * @author ֣����
 *
 */
public interface ISchoolService {

	/**
	 * ���ѧԺ
	 * @param school
	 * @return
	 */
	public boolean addSchool(School school);
	
	/**
	 * ɾ��ѧԺ
	 * @param school
	 * @return
	 */
	public boolean deleteSchool(School school);
	
	/**
	 * ���ϵ
	 * @param school
	 * @param department
	 * @return
	 */
	public boolean addDepartment(School school, Department department);
	
	/**
	 * ɾ��ϵ
	 * @param department
	 * @return
	 */
	public boolean deleteDepartment(Department department);
	
	/**
	 * ��֤ѧԺ��dwr
	 * @param name
	 * @return
	 */
	public School checkSchool(String name);
	
	/**
	 * ��������ѧԺ
	 * @return
	 */
	public List findAllSchool();
	
	/**
	 * ����id����ѧԺ
	 * @param id
	 * @return
	 */
	public School findSchoolById(int id);
	
	/**
	 * ����ѧԺ��ϵ
	 * @param school
	 * @return
	 */
	public List findDepartmentBySchool(School school);
	
	/**
	 * ����Id����ϵ
	 * @param id
	 * @return
	 */
	public Department findDepartmentById(int id);

	/**
	 * ����꼶
	 */
	public boolean addGrade(Grade grade);
	
	/**
	 * ɾ���꼶
	 * @param grade
	 * @return
	 */
	public boolean deleteGrade(Grade grade);
	
	/**
	 * ���������꼶
	 * @return
	 */
	public List findAllGrade();
	
	/**
	 * ����id�����꼶
	 * @param id
	 * @return
	 */
	public Grade findGradeById(int id);
	
	/**
	 * �������ֲ���ѧԺ
	 * @param name
	 * @return
	 */
	public School findSchoolByName(String name);
}
