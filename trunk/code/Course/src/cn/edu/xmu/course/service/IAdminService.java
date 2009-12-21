package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.School;

public interface IAdminService {

public boolean addAdmin(Administrator admin, School school);
	
	public boolean deleteAdmin(Administrator admin);
	
	public List findAllAdmin();
	
	public Administrator findAdminById(int id);
}
