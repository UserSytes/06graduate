package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.News;
import cn.edu.xmu.course.pojo.School;

/**
 * 此接口是负责超级管理员业务的service接口，主要包括院系管理、新闻管理、年级管理模块
 * @author 郑冰凌
 *
 */
public interface ISuperAdminService {

	//院系管理
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
	
	//新闻管理
	public List findAllNews();
	
	public boolean addNews(News news);
	
	public boolean deleteNews(News news); 
	
	public News findNewsById(int id);
	
	//年级管理
	public boolean addGrade(String name, Integer grade);
	
	public boolean deleteGrade(Grade grade);
	
	public List findAllGrade();
	
	public Grade findGradeById(int id);
}
