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
	public boolean addSchool(String schoolName);
	
	public boolean deleteSchool(School school);
	
	public boolean addDepartment(School school, String departmentName);
	
	public boolean deleteDepartment(Department department);
	
	public List findAllSchool();
	
	public School findSchoolById(int id);
	
	public List findDepartmentBySchool(School school);
	
	public boolean addAdmin(String name, String account, School school);
	
	public boolean deleteAdmin(Administrator admin);
	
	public List findAllAdmin();
	
	public Administrator findAdminById(int id);
	
	//���Ź���
	public List findAllNews();
	
	public boolean addNews(News news);
	
	public boolean deleteNews(News news); 
	
	public News findNewsById(int id);
	
	//�꼶����
	public boolean addGrade(String name, Integer grade);
	
	public boolean deleteGrade(Grade grade);
	
	public List findAllGrade();
	
	public Grade findGradeById(int id);
}
