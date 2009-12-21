package cn.edu.xmu.course.service.impl;

import cn.edu.xmu.course.dao.DepartmentDAO;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.service.IDepartmentService;

public class DepartmentService implements IDepartmentService{

	private DepartmentDAO departmentDAO;
	
	public Department getDepartmentById(Integer departmentId) {
		// TODO Auto-generated method stub
		return departmentDAO.findById(departmentId);
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

}
