package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.IAdminService;
import cn.edu.xmu.course.service.ISuperAdminService;

public class SchoolManageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ISuperAdminService superAdminService;
	private IAdminService adminService;

	private String schoolName;
	private List<School> allSchoolList;
	private List<Department> departmentList;
	private int schoolId;
	private School school;
	private int departmentId;
	private Department department;

	// 添加学院管理员
	private int adminSchoolId;
	private Administrator admin;
	private School adminSchool;

	// 年级管理
	private List<Grade> allGradeList;
	private Grade grade;
	/**
	 * 添加学院
	 * 
	 * @return
	 */
	public String addSchool() {
		boolean result = false;
		result = superAdminService.addSchool(school);
		if (result){
			addActionMessage("添加学院成功！"); 
			return SUCCESS;
		}
		else
			return ERROR;
	}

	/**
	 * 查找所有学院
	 * 
	 * @return
	 */
	public String findAllSchools() {
		allSchoolList = superAdminService.findAllSchool();
		//System.out.println("test:  "+allSchoolList.get(6).getName());
		if (allSchoolList.size() == 0) {
			return ERROR;
		} else
			return "allSchools";
	}

	/**
	 * 查找系
	 * 
	 * @return
	 */
	public String findDepartmentBySchool() {
		school = superAdminService.findSchoolById(schoolId);
		departmentList = superAdminService.findDepartmentBySchool(school);
		if (departmentList.size() == 0) {
			addActionMessage("该学院没有系！"); 
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * 删除学院
	 * 
	 * @return
	 */
	public String deleteSchool() {
		School s = superAdminService.findSchoolById(schoolId);
		boolean result = superAdminService.deleteSchool(s);
		if (result) {
			this.findAllSchools();
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 添加学院管理员
	 * 
	 * @return
	 */
	public String addAdmin() {
		adminSchool = superAdminService.findSchoolById(adminSchoolId);
		boolean result = false;
		result = adminService.addAdmin(admin, adminSchool);
		if (result){
			addActionMessage("添加学院管理员成功！"); 
			return SUCCESS;
		}
		else
			return ERROR;
	}

	/**
	 * 添加年级
	 * 
	 * @return
	 */
	public String addGrade() {
		boolean result = false;
		if (result) {
			addActionMessage("添加年级成功！"); 
			return SUCCESS;
		} else
			return ERROR;
	}
	
	/**
	 * 删除系
	 * @return
	 */
	public String deleteDepartment(){
		Department d = superAdminService.findDepartmentById(departmentId);
		boolean result = superAdminService.deleteDepartment(d);
		if (result) {
			this.findDepartmentBySchool();
			return SUCCESS;
		} else
			return ERROR;
	}
	
	/**
	 * 跳转到添加系
	 * @return
	 */
	public String goAddDepartment(){
		school = superAdminService.findSchoolById(schoolId);
		System.out.println("测试1： "+school.getName());
		if(school==null)
			return ERROR;
		else 
			return SUCCESS;
	}
	
	/**
	 * 添加系
	 * @return
	 */
	public String addDepartment(){
		//department.setSchool(school);
		System.out.println("测试2： "+school.getName());
		boolean result = superAdminService.addDepartment(school, department);
		if(result)
			return SUCCESS;
		else 
			return ERROR;
	}

	public ISuperAdminService getSuperAdminService() {
		return superAdminService;
	}

	public void setSuperAdminService(ISuperAdminService superAdminService) {
		this.superAdminService = superAdminService;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public List<School> getAllSchoolList() {
		return allSchoolList;
	}

	public void setAllSchoolList(List<School> allSchoolList) {
		this.allSchoolList = allSchoolList;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public School getAdminSchool() {
		return adminSchool;
	}

	public void setAdminSchool(School adminSchool) {
		this.adminSchool = adminSchool;
	}

	public int getAdminSchoolId() {
		return adminSchoolId;
	}

	public void setAdminSchoolId(int adminSchoolId) {
		this.adminSchoolId = adminSchoolId;
	}

	public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	public List<Grade> getAllGradeList() {
		return allGradeList;
	}

	public void setAllGradeList(List<Grade> allGradeList) {
		this.allGradeList = allGradeList;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}


}
