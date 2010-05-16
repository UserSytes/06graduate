package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.commons.MD5;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.service.IAdminService;

/**
 * �������Ա��Ϣ�������
 * @author ֣����
 *
 */
public class AdminAction extends BaseAction {

	private static final long serialVersionUID = 1640606765141485215L;

	private IAdminService adminService; //����Ա��Ϣ�������Ľӿ�

	private Administrator admin; //ѧԺ����Ա
	private SuperAdmin superAdmin; //У������Ա
	private List<SuperAdmin> superAdminList;	//У������Ա�б�
	private int superAdminId;	//У����Աid
	
	private String oldPassword; //����Ա�ʺ�ԭ����
	private String newPassword; //������
	
	/**
	 * ��ȡѧԺ����Ա��Ϣ
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
	 * �޸�ѧԺ����Ա��Ϣ
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
	 * �޸�ѧԺ����Ա����
	 * @return
	 */
	public String changeAdministratorPassword(){
		admin = super.getAdmin();
		MD5 md5 = new MD5();
		if(admin.getPassword().equals(md5.getMD5ofStr(oldPassword))){
			admin.setPassword(md5.getMD5ofStr(newPassword));
			boolean result = adminService.updateAdmin(admin);
			if(result){
				addActionMessage("�޸�����ɹ���");
				return SUCCESS;
			}
			else
				return ERROR;
		}
		else{
			addActionMessage("ԭ�������");
			return SUCCESS;
		}
	}
	
	
	/**
	 * �޸�У����Ա����
	 * @return
	 */
	public String changeSuperAdminPassword(){
		superAdmin = super.getSuperAdmin();
		MD5 md5 = new MD5();
		if(superAdmin.getPassword().equals(md5.getMD5ofStr(oldPassword))){
			superAdmin.setPassword(md5.getMD5ofStr(newPassword));
			boolean result = adminService.updateSuperAdmin(superAdmin);
			if(result){
				addActionMessage("�޸�����ɹ���");
				return SUCCESS;
			}
			else
				return ERROR;
		}
		else{
			addActionMessage("ԭ�������");
			return SUCCESS;
		}
	}

	/**
	 * ���У����Ա
	 * @return
	 */
	public String addSuperAdmin(){
		boolean result = false;
		superAdmin.setPassword(superAdmin.getAccount());
		result = adminService.addSuperAdmin(superAdmin);
		if (result) {
			addActionMessage("���У����Ա�ɹ���");
			return SUCCESS;
		} else
			return ERROR;
	}
	
	/**
	 * �������У����Ա
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
	 * ɾ��У����Ա
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String deleteSuperAdmin(){
		superAdminList = adminService.findAllSuperAdmin();
		if (superAdminList.size() == 1) {
			addActionMessage("����ɾ��Ψһ��У����Ա��");
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
	 * ��ԭУ����Ա����
	 * @return
	 */
	public String restoreSuperAdminPassword(){
		SuperAdmin s = adminService.findSuperAdminById(superAdminId);
		s.setPassword(new MD5().getMD5ofStr(s.getAccount()));
		boolean result = adminService.updateSuperAdmin(s);
		if(result){
			addActionMessage("��ԭ����ɹ���");
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
