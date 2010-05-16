package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.commons.MD5;
import cn.edu.xmu.course.dao.AdministratorDAO;
import cn.edu.xmu.course.dao.SuperAdminDAO;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.service.IAdminService;

/**
 * 负责校、学院管理员信息管理的类
 * @author 郑冰凌
 * 
 */
public class AdminService implements IAdminService {

	private AdministratorDAO administratorDAO;
	private SuperAdminDAO superAdminDAO;

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IAdminService#getAdminByAccount(java.lang.String)
	 */
	public Administrator getAdminByAccount(String account) {
		List<Administrator> admins = administratorDAO.findByAccount(account);
		if (admins.size() == 0) {
			return null;
		} else
			return admins.get(0);
	}

	/*
	 * 添加学院管理员(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IAdminService#addAdmin(cn.edu.xmu.course.pojo
	 * .Administrator, cn.edu.xmu.course.pojo.School)
	 */
	public boolean addAdmin(Administrator admin, School school) {
		// TODO Auto-generated method stub
		MD5 md5 = new MD5();
		admin.setPassword(md5.getMD5ofStr(admin.getAccount()));
		admin.setSchool(school);		
		try {
			administratorDAO.save(admin);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 删除学院管理员(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IAdminService#deleteAdmin(cn.edu.xmu.course
	 * .pojo.Administrator)
	 */
	public boolean deleteAdmin(Administrator admin) {
		// TODO Auto-generated method stub
		try {
			administratorDAO.delete(admin);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 查找所有的学院管理员(non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.IAdminService#findAllAdmin()
	 */
	public List findAllAdmin() {
		// TODO Auto-generated method stub
		return administratorDAO.findAll();
	}

	/*
	 * 根据id查找学院管理员(non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.IAdminService#findAdminById(int)
	 */
	public Administrator findAdminById(int id) {
		// TODO Auto-generated method stub
		return administratorDAO.findById(id);
	}

	public AdministratorDAO getAdministratorDAO() {
		return administratorDAO;
	}

	public void setAdministratorDAO(AdministratorDAO administratorDAO) {
		this.administratorDAO = administratorDAO;
	}

	public SuperAdminDAO getSuperAdminDAO() {
		return superAdminDAO;
	}

	public void setSuperAdminDAO(SuperAdminDAO superAdminDAO) {
		this.superAdminDAO = superAdminDAO;
	}

	/*
	 * 添加校管理员(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IAdminService#addSuperAdmin(cn.edu.xmu.course
	 * .pojo.SuperAdmin)
	 */
	public boolean addSuperAdmin(SuperAdmin superAdmin) {
		// TODO Auto-generated method stub
		MD5 md5 = new MD5();
		superAdmin.setPassword(md5.getMD5ofStr(superAdmin.getPassword()));
		try {
			superAdminDAO.save(superAdmin);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 根据id查找校管理员(non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.IAdminService#findSuperAdminById(int)
	 */
	public SuperAdmin findSuperAdminById(int id) {
		// TODO Auto-generated method stub
		return superAdminDAO.findById(id);
	}

	/*
	 * 更新学院管理员(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IAdminService#updateAdmin(cn.edu.xmu.course
	 * .pojo.Administrator)
	 */
	public boolean updateAdmin(Administrator admin) {
		// TODO Auto-generated method stub
		try {
			administratorDAO.merge(admin);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 更新校管理员(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IAdminService#updateSuperAdmin(cn.edu.xmu.course
	 * .pojo.SuperAdmin)
	 */
	public boolean updateSuperAdmin(SuperAdmin superAdmin) {
		// TODO Auto-generated method stub
		try {
			superAdminDAO.merge(superAdmin);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/*
	 * 根据帐号获取校管理员(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IAdminService#getSuperAdminByAccount(java.lang.String)
	 */
	public SuperAdmin getSuperAdminByAccount(String account){
		return superAdminDAO.findByAccount(account);
	}

	/*
	 * 删除校管理员(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IAdminService#deleteSuperAmdin(cn.edu.xmu.course.pojo.SuperAdmin)
	 */
	public boolean deleteSuperAmdin(SuperAdmin superAdmin) {
		// TODO Auto-generated method stub
		try {
			superAdminDAO.delete(superAdmin);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 查找所有校管理员(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IAdminService#findAllSuperAdmin()
	 */
	public List findAllSuperAdmin() {
		// TODO Auto-generated method stub
		return superAdminDAO.findAll();
	}
	

}
