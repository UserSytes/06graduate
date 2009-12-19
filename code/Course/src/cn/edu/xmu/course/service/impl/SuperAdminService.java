package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.AdministratorDAO;
import cn.edu.xmu.course.dao.DepartmentDAO;
import cn.edu.xmu.course.dao.GradeDAO;
import cn.edu.xmu.course.dao.NewsDAO;
import cn.edu.xmu.course.dao.SchoolDAO;
import cn.edu.xmu.course.dao.SuperAdminDAO;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.News;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.service.ISuperAdminService;

public class SuperAdminService implements ISuperAdminService {

	private AdministratorDAO administratorDAO;
	private SuperAdminDAO superAdminDAO;
	private SchoolDAO schoolDAO;
	private DepartmentDAO departmentDAO;
	private NewsDAO newsDAO;
	private GradeDAO gradeDAO;
	
	final String password = "123456";
	
	public boolean addAdmin(String name, String account, School school) {
		// TODO Auto-generated method stub
		Administrator admin = new Administrator();
		admin.setAccount(account);
		admin.setName(name);
		admin.setSchool(school);
		admin.setPassword(password);	
		return administratorDAO.save(admin);
	}

	public boolean addDepartment(School school, String departmentName) {
		// TODO Auto-generated method stub
		Department department = new Department();
		department.setName(departmentName);
		department.setSchool(school);
		return departmentDAO.save(department);
	}

	public boolean addGrade(String name, Integer gra) {
		// TODO Auto-generated method stub
		Grade grade = new Grade();
		grade.setGrade(gra);
		grade.setName(name);
		return gradeDAO.save(grade);
	}

	public boolean addNews(News news) {
		// TODO Auto-generated method stub
		return newsDAO.save(news);
	}

	public boolean addSchool(String schoolName) {
		// TODO Auto-generated method stub
		School school = new School();
		school.setName(schoolName);
		return schoolDAO.save(school);
	}

	public boolean deleteAdmin(Administrator admin) {
		// TODO Auto-generated method stub
		return administratorDAO.delete(admin);
	}

	public boolean deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentDAO.delete(department);
	}

	public boolean deleteGrade(Grade grade) {
		// TODO Auto-generated method stub
		return gradeDAO.delete(grade);
	}

	public boolean deleteNews(News news) {
		// TODO Auto-generated method stub
		return newsDAO.delete(news);
	}

	public boolean deleteSchool(School school) {
		// TODO Auto-generated method stub
		return schoolDAO.delete(school);
	}

	public List findAllAdmin() {
		// TODO Auto-generated method stub
		return administratorDAO.findAll();
	}

	public List findAllGrade() {
		// TODO Auto-generated method stub
		return gradeDAO.findAll();
	}

	public List findAllNews() {
		// TODO Auto-generated method stub
		return newsDAO.findAll();
	}

	public List findAllSchool() {
		// TODO Auto-generated method stub
		return schoolDAO.findAll();
	}

	public List findDepartmentBySchool(School school) {
		// TODO Auto-generated method stub
		return departmentDAO.findByProperty("school", school);
	}

	public AdministratorDAO getAdministratorDAO() {
		return administratorDAO;
	}

	public void setAdministratorDAO(AdministratorDAO administratorDAO) {
		this.administratorDAO = administratorDAO;
	}

	public SuperAdminDAO getSuperAdminDAO() {
		return superAdminDAO;
	}

	public void setSuperAdminDAO(SuperAdminDAO superAdminDAO) {
		this.superAdminDAO = superAdminDAO;
	}

	public SchoolDAO getSchoolDAO() {
		return schoolDAO;
	}

	public void setSchoolDAO(SchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}

	public void setNewsDAO(NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	public GradeDAO getGradeDAO() {
		return gradeDAO;
	}

	public void setGradeDAO(GradeDAO gradeDAO) {
		this.gradeDAO = gradeDAO;
	}

	public String getPassword() {
		return password;
	}
	
	

}
