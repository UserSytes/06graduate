package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.IAdminService;
import cn.edu.xmu.course.service.ISuperAdminService;

public class SchoolManageAction extends BaseAction{

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
	
	/**
	 * 添加学院管理员
	 */
	private int adminSchoolId;
	private School adminSchool;
	private String adminName;
	private String adminAccount;
	
	/**
	 * 添加学院
	 * @return
	 */
	public String addSchool(){
		boolean result = false;
		result = superAdminService.addSchool(schoolName);
//		List schools = superAdminService.findAllSchool();		
//		School sc = (School) schools.get(0);
//		System.out.println("test:  "+sc.getName());
		if(result)
			return SUCCESS;
		else 
			return ERROR;
	}
	
	/**
	 * 查找所有学院
	 * @return
	 */
	public String findAllSchools(){
		allSchoolList = superAdminService.findAllSchool();
		//System.out.println("test:  "+allSchoolList.get(0).getName());
		if(allSchoolList.size()==0){
			return ERROR;
		}else
			return "allSchools";
	}
	
    /**
     * 查找系
     * @return
     */
	public String findDepartmentBySchool(){
		School s = superAdminService.findSchoolById(schoolId);
		departmentList = superAdminService.findDepartmentBySchool(s);
		if(departmentList.size()==0){
			return ERROR;
		}else
			return "departments";
	}
	
	/**
	 * 删除学院
	 * @return
	 */
	public String deleteSchool(){
		School s = superAdminService.findSchoolById(schoolId);
		boolean result = superAdminService.deleteSchool(s);
		if(result){
			return SUCCESS;
		}else
			return ERROR;
	}
	
	/**
	 * 添加学院管理员
	 * @return
	 */
	public String addAdmin(){
		System.out.println("test1:  "+adminSchoolId);
		adminSchool = superAdminService.findSchoolById(adminSchoolId);
		System.out.println("test2:  "+adminSchool.getName());
		boolean result = false;
		result = adminService.addAdmin(adminName, adminAccount, adminSchool);
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

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminAccount() {
		return adminAccount;
	}

	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
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

}
