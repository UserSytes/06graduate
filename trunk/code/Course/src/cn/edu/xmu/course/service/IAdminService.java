package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.SuperAdmin;

/**
 * 负责校、学院管理员信息管理的接口
 * @author 郑冰凌
 *
 */
public interface IAdminService {

	/**
	 * 根据帐号查找学院管理员
	 * @param account
	 * @return
	 */
	public Administrator getAdminByAccount(String account);
	
	/**
	 * 添加学院管理员
	 * @param admin
	 * @param school
	 * @return 
	 */
	public boolean addAdmin(Administrator admin, School school);
	
	/**
	 * 删除学院管理员
	 * @param admin
	 * @return
	 */
	public boolean deleteAdmin(Administrator admin);
	
	/**
	 * 查找所有的学院管理员
	 * @return
	 */
	public List findAllAdmin();
	
	/**
	 * 更新学院管理员
	 * @param admin
	 * @return
	 */
	public boolean updateAdmin(Administrator admin);
	
	/**
	 * 根据id查找学院管理员
	 * @param id
	 * @return
	 */
	public Administrator findAdminById(int id);
	
	/**
	 * 添加校管理员
	 * @param superAdmin
	 * @return
	 */
	public boolean addSuperAdmin(SuperAdmin superAdmin);
	
	/**
	 * 更新校管理员
	 * @param superAdmin
	 * @return
	 */
	public boolean updateSuperAdmin(SuperAdmin superAdmin);
	
	/**
	 * 根据id查找校管理员
	 * @param id
	 * @return
	 */
	public SuperAdmin findSuperAdminById(int id);
}
