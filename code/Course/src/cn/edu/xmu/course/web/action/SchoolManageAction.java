package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.IAdminService;
import cn.edu.xmu.course.service.ISuperAdminService;

/**
 * 负责学院管理的类
 * @author 郑冰凌
 *
 */
public class SchoolManageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ISuperAdminService superAdminService;	//管理校方管理员的接口
	private IAdminService adminService;	//管理学院管理员、学院信息的接口

	private String schoolName;	//学院名称
	private List<School> allSchoolList;	//学院列表
	private List<Department> departmentList;	//系列表
	private int schoolId;	//学院Id
	private School school;	//学院
	private int departmentId;	//系id
	private Department department;	//系

	// 添加学院管理员
	private int adminSchoolId;	//学院管理员所属学院id
	private Administrator admin;	//学院管理员
	private School adminSchool;	//学院管理员所属学院	
	private int adminId;	//学院管理员id
	private List<Administrator> adminList;	//学院管理员列表

	// 年级管理
	private List<Grade> allGradeList;	//年级列表
	private Grade grade;	//年级
	private int gradeId;	//年级id

	/**
	 * 添加学院
	 * 
	 * @return
	 */
	public String addSchool() {
		boolean result = false;
		result = superAdminService.addSchool(school);
		if (result) {
			addActionMessage("添加学院成功！");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 查找所有学院
	 * 
	 * @return
	 */
	public String findAllSchools() {
		allSchoolList = superAdminService.findAllSchool();
		// System.out.println("test:  "+allSchoolList.get(6).getName());
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
		if (result) {
			addActionMessage("添加学院管理员成功！");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 添加年级
	 * 
	 * @return
	 */
	public String addGrade() {
		boolean result = false;
		result = superAdminService.addGrade(grade);
		if (result) {
			addActionMessage("添加年级成功！");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 删除系
	 * 
	 * @return
	 */
	public String deleteDepartment() {
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
	 * 
	 * @return
	 */
	public String goAddDepartment() {
		school = superAdminService.findSchoolById(schoolId);
		if (school == null)
			return ERROR;
		else
			return SUCCESS;
	}

	/**
	 * 添加系
	 * 
	 * @return
	 */
	public String addDepartment() {
		// department.setSchool(school);
		school = superAdminService.findSchoolById(schoolId);
		// System.out.println("测试2： "+school);
		// System.out.println("测试3： "+school.getName());
		department.setSchool(school);
		boolean result = superAdminService.addDepartment(school, department);
		if (result) {
			addActionMessage("添加系成功！");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 跳转到学院管理员列表
	 * 
	 * @return
	 */
	public String getAllAdmin() {
		adminList = adminService.findAllAdmin();
		if (adminList.size() != 0) {
			return SUCCESS;
		} else {
			addActionMessage("目前还没有学院管理员！");
			return ERROR;
		}

	}

	/**
	 * 删除学院管理员
	 * 
	 * @return
	 */
	public String deleteAdmin() {
		Administrator a = adminService.findAdminById(adminId);
		boolean result = adminService.deleteAdmin(a);
		if (result) {
			adminList = adminService.findAllAdmin();
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 查找所有年级
	 * 
	 * @return
	 */
	public String findAllGrade() {
		allGradeList = superAdminService.findAllGrade();
		if (allGradeList.size() != 0) {
			return SUCCESS;
		} else {
			addActionMessage("目前还没有年级！");
			return ERROR;
		}
	}

	/**
	 * 删除年级
	 * 
	 * @return
	 */
	public String deleteGrade() {
		Grade g = superAdminService.findGradeById(gradeId);
		boolean result = superAdminService.deleteGrade(g);
		if (result) {
			allGradeList = superAdminService.findAllGrade();
			return SUCCESS;
		} else
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Administrator> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<Administrator> adminList) {
		this.adminList = adminList;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

}
