package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.News;
import cn.edu.xmu.course.pojo.School;

/**
 * �˽ӿ��Ǹ��𳬼�����Աҵ���service�ӿڣ���Ҫ����Ժϵ�������Ź����꼶����ģ��
 * @author ֣����
 *
 */
public interface ISuperAdminService {

	//Ժϵ����
	public boolean addSchool(School school);
	
	public boolean deleteSchool(School school);
	
	public boolean addDepartment(School school, Department department);
	
	public boolean deleteDepartment(Department department);
	
	public List findAllSchool();
	
	public School findSchoolById(int id);
	
	public List findDepartmentBySchool(School school);

	//�꼶����
	public boolean addGrade(Grade grade);
	
	public boolean deleteGrade(Grade grade);
	
	public List findAllGrade();
	
	public Grade findGradeById(int id);
}
