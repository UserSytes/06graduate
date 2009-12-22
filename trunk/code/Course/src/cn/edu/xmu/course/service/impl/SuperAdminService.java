package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.DepartmentDAO;
import cn.edu.xmu.course.dao.GradeDAO;
import cn.edu.xmu.course.dao.SchoolDAO;
import cn.edu.xmu.course.dao.SuperAdminDAO;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.ISuperAdminService;

public class SuperAdminService implements ISuperAdminService {

	private SuperAdminDAO superAdminDAO;
	private SchoolDAO schoolDAO;
	private DepartmentDAO departmentDAO;
	private GradeDAO gradeDAO;

	public boolean addDepartment(School school, Department department) {
		// TODO Auto-generated method stub
		//department.setSchool(school);
		try {
			departmentDAO.save(department);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean addGrade(Grade grade) {
		// TODO Auto-generated method stub
		try {
			gradeDAO.save(grade);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean addSchool(School school) {
		// TODO Auto-generated method stub
		try {
			schoolDAO.save(school);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		try {
			departmentDAO.delete(department);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteGrade(Grade grade) {
		// TODO Auto-generated method stub
		try {
			gradeDAO.delete(grade);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteSchool(School school) {
		// TODO Auto-generated method stub
		try {
			schoolDAO.delete(school);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List findAllGrade() {
		// TODO Auto-generated method stub
		return gradeDAO.findAll();
	}

	public List findAllSchool() {
		// TODO Auto-generated method stub
		return schoolDAO.findAll();
	}

	public List findDepartmentBySchool(School school) {
		// TODO Auto-generated method stub
		return departmentDAO.findByProperty("school", school);
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

	public GradeDAO getGradeDAO() {
		return gradeDAO;
	}

	public void setGradeDAO(GradeDAO gradeDAO) {
		this.gradeDAO = gradeDAO;
	}

	public Grade findGradeById(int id) {
		// TODO Auto-generated method stub
		return gradeDAO.findById(id);
	}

	public School findSchoolById(int id) {
		// TODO Auto-generated method stub
		return schoolDAO.findById(id);
	}
	
	public Department findDepartmentById(int id){
		return departmentDAO.findById(id);
	}

}
