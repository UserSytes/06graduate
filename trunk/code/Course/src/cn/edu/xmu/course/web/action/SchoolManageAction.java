package cn.edu.xmu.course.web.action;

import cn.edu.xmu.course.service.ISuperAdminService;

public class SchoolManageAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ISuperAdminService superAdminService;

	private String schoolName;
	
	/**
	 * Ìí¼ÓÑ§Ôº
	 * @return
	 */
	public String addSchool(){
		boolean result = false;
		result = superAdminService.addSchool(schoolName);
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
	
	

}
