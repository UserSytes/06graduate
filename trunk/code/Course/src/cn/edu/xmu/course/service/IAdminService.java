package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.SuperAdmin;

/**
 * ����У��ѧԺ����Ա��Ϣ����Ľӿ�
 * @author ֣����
 *
 */
public interface IAdminService {

	/**
	 * �����ʺŲ���ѧԺ����Ա
	 * @param account
	 * @return
	 */
	public Administrator getAdminByAccount(String account);
	
	/**
	 * ���ѧԺ����Ա
	 * @param admin
	 * @param school
	 * @return 
	 */
	public boolean addAdmin(Administrator admin, School school);
	
	/**
	 * ɾ��ѧԺ����Ա
	 * @param admin
	 * @return
	 */
	public boolean deleteAdmin(Administrator admin);
	
	/**
	 * �������е�ѧԺ����Ա
	 * @return
	 */
	public List findAllAdmin();
	
	/**
	 * ����ѧԺ����Ա
	 * @param admin
	 * @return
	 */
	public boolean updateAdmin(Administrator admin);
	
	/**
	 * ����id����ѧԺ����Ա
	 * @param id
	 * @return
	 */
	public Administrator findAdminById(int id);
	
	/**
	 * ���У����Ա
	 * @param superAdmin
	 * @return
	 */
	public boolean addSuperAdmin(SuperAdmin superAdmin);
	
	/**
	 * ����У����Ա
	 * @param superAdmin
	 * @return
	 */
	public boolean updateSuperAdmin(SuperAdmin superAdmin);
	
	/**
	 * ����id����У����Ա
	 * @param id
	 * @return
	 */
	public SuperAdmin findSuperAdminById(int id);
}
