package cn.edu.xmu.course.web.action;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.service.IAdminService;

/**
 * 
 * @author 郑冰凌
 *
 */
public class AdminAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1640606765141485215L;

	private IAdminService adminService;
	
	private Administrator admin;
	private SuperAdmin superAdmin;
	
	private String oldPassword;
	private String newPassword;
	
	/**
	 * 获取学院管理员信息
	 * @return
	 */
	public String getAdministratorInfo(){
		admin = super.getAdmin();
		admin = adminService.findAdminById(admin.getId());
		if(admin == null){
			return ERROR;
		}else
			return SUCCESS;
	}
	
	/**
	 * 修改学院管理员信息
	 * @return
	 */
	public String changeAdministratorInfo(){
		
		boolean result = adminService.updateAdmin(admin);
		if(result){
			this.getAdministratorInfo();
			return SUCCESS;
		}else
			return ERROR;
	}
	
	/**
	 * 修改学院管理员密码
	 * @return
	 */
	public String changeAdministratorPassword(){
		admin = super.getAdmin();
		if(admin.getPassword().equals(oldPassword)){
			admin.setPassword(newPassword);
			boolean result = adminService.updateAdmin(admin);
			if(result){
				addActionMessage("修改密码成功！");
				return SUCCESS;
			}
			else
				return ERROR;
		}
		else{
			addActionMessage("原密码错误！");
			return SUCCESS;
		}
	}
	
	
	/**
	 * 修改校管理员密码
	 * @return
	 */
	public String changeSuperAdminPassword(){
		superAdmin = super.getSuperAdmin();
		if(superAdmin.getPassword().equals(oldPassword)){
			superAdmin.setPassword(newPassword);
			boolean result = adminService.updateSuperAdmin(superAdmin);
			if(result){
				addActionMessage("修改密码成功！");
				return SUCCESS;
			}
			else
				return ERROR;
		}
		else{
			addActionMessage("原密码错误！");
			return SUCCESS;
		}
	}

	public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	public SuperAdmin getSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(SuperAdmin superAdmin) {
		this.superAdmin = superAdmin;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
