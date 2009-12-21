package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.AdministratorDAO;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.IAdminService;

public class AdminService implements IAdminService {

	private AdministratorDAO administratorDAO;
	final String password = "123456";
	
	public boolean addAdmin(Administrator admin, School school) {
		// TODO Auto-generated method stub
		admin.setSchool(school);
		admin.setPassword(password);	
		return administratorDAO.save(admin);
	}
	
	public boolean deleteAdmin(Administrator admin) {
		// TODO Auto-generated method stub
		return administratorDAO.delete(admin);
	}
	
	public List findAllAdmin() {
		// TODO Auto-generated method stub
		return administratorDAO.findAll();
	}
	
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

	public String getPassword() {
		return password;
	}
	
	
}
