package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.ISchoolService;

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

	private ISchoolService schoolService;	//管理学院年级的接口

	private String schoolName;	//学院名称
	private List<School> allSchoolList;	//学院列表
	private List<Department> departmentList;	//系列表
	private int schoolId;	//学院Id
	private School school;	//学院
	private int departmentId;	//系id
	private Department department;	//系

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
		result = schoolService.addSchool(school);
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
		allSchoolList = schoolService.findAllSchool();
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
		school = schoolService.findSchoolById(schoolId);
		departmentList = schoolService.findDepartmentBySchool(school);
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
		School s = schoolService.findSchoolById(schoolId);
		boolean result = schoolService.deleteSchool(s);
		if (result) {
			this.findAllSchools();
			return SUCCESS;
		} else{
			addActionMessage("该学院还有系，请先删除系再删除学院！");
			return ERROR;
		}
	}

	/**
	 * 添加年级
	 * 
	 * @return
	 */
	public String addGrade() {
		boolean result = false;
		result = schoolService.addGrade(grade);
		if (result) {
			addActionMessage("添加年级成功！");
			return SUCCESS;
		} else{
			addActionMessage("所添加的年级已经存在！");
			return ERROR;
		}
	}

	/**
	 * 删除系
	 * 
	 * @return
	 */
	public String deleteDepartment() {
		Department d = schoolService.findDepartmentById(departmentId);
		boolean result = schoolService.deleteDepartment(d);
		if (result) {
			this.findDepartmentBySchool();
			return SUCCESS;
		} else{
			addActionMessage("该系还有学生，请先删除学生再删除系！");
			return ERROR;
		}
	}

	/**
	 * 跳转到添加系
	 * 
	 * @return
	 */
	public String goAddDepartment() {
		school = schoolService.findSchoolById(schoolId);
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
		school = schoolService.findSchoolById(schoolId);	
		boolean result = schoolService.addDepartment(school, department);
		if (result) {
			addActionMessage("添加系成功！");
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
		allGradeList = schoolService.findAllGrade();
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
		Grade g = schoolService.findGradeById(gradeId);
		boolean result = schoolService.deleteGrade(g);
		if (result) {
			allGradeList = schoolService.findAllGrade();
			return SUCCESS;
		} else{
			addActionMessage("该年级还有学生，请先删除学生再删除年级！");
			return ERROR;
		}
	}

	public ISchoolService getSuperAdminService() {
		return schoolService;
	}

	public void setSuperAdminService(ISchoolService schoolService) {
		this.schoolService = schoolService;
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

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public ISchoolService getSchoolService() {
		return schoolService;
	}

	public void setSchoolService(ISchoolService schoolService) {
		this.schoolService = schoolService;
	}

}
