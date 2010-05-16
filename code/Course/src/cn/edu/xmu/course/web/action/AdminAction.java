package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.commons.MD5;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.service.IAdminService;

/**
 * 负责管理员信息管理的类
 * @author 郑冰凌
 *
 */
public class AdminAction extends BaseAction {

	private static final long serialVersionUID = 1640606765141485215L;

	private IAdminService adminService; //管理员信息管理方法的接口

	private Administrator admin; //学院管理员
	private SuperAdmin superAdmin; //校方管理员
	private List<SuperAdmin> superAdminList;	//校方管理员列表
	private int superAdminId;	//校管理员id
	
	private String oldPassword; //管理员帐号原密码
	private String newPassword; //新密码
	
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
		MD5 md5 = new MD5();
		if(admin.getPassword().equals(md5.getMD5ofStr(oldPassword))){
			admin.setPassword(md5.getMD5ofStr(newPassword));
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
		MD5 md5 = new MD5();
		if(superAdmin.getPassword().equals(md5.getMD5ofStr(oldPassword))){
			superAdmin.setPassword(md5.getMD5ofStr(newPassword));
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

	/**
	 * 添加校管理员
	 * @return
	 */
	public String addSuperAdmin(){
		boolean result = false;
		superAdmin.setPassword(superAdmin.getAccount());
		result = adminService.addSuperAdmin(superAdmin);
		if (result) {
			addActionMessage("添加校管理员成功！");
			return SUCCESS;
		} else
			return ERROR;
	}
	
	/**
	 * 查获所有校管理员
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findAllSuperAdmin(){
		superAdminList = adminService.findAllSuperAdmin();
		if (superAdminList.size() != 0) {			
			return SUCCESS;
		} else{
			return ERROR;
		}
	}
	
	/**
	 * 删除校管理员
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String deleteSuperAdmin(){
		superAdminList = adminService.findAllSuperAdmin();
		if (superAdminList.size() == 1) {
			addActionMessage("不能删除唯一的校管理员！");
			return ERROR;
		} 
		SuperAdmin s = adminService.findSuperAdminById(superAdminId);
		boolean result = adminService.deleteSuperAmdin(s);
		if (result) {
			superAdminList = adminService.findAllSuperAdmin();
			return SUCCESS;
		} else
			return ERROR;
	}
	
	/**
	 * 还原校管理员密码
	 * @return
	 */
	public String restoreSuperAdminPassword(){
		SuperAdmin s = adminService.findSuperAdminById(superAdminId);
		s.setPassword(new MD5().getMD5ofStr(s.getAccount()));
		boolean result = adminService.updateSuperAdmin(s);
		if(result){
			addActionMessage("还原密码成功！");
			return SUCCESS;
		}
		else
			return ERROR;
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

	public List<SuperAdmin> getSuperAdminList() {
		return superAdminList;
	}

	public void setSuperAdminList(List<SuperAdmin> superAdminList) {
		this.superAdminList = superAdminList;
	}

	public int getSuperAdminId() {
		return superAdminId;
	}

	public void setSuperAdminId(int superAdminId) {
		this.superAdminId = superAdminId;
	}
	
	
}
