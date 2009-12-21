package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.ISuperAdminService;

public class SchoolManageAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ISuperAdminService superAdminService;

	private String schoolName;
	private List<School> allSchoolList;
	private List<Department> departmentList;
	private int schoolId;
	
	
	/**
	 * ����ѧԺ
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
	 * ��������ѧԺ
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
     * ����ϵ
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
	 * ɾ��ѧԺ
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
	
	

}