package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.DepartmentDAO;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.service.IDepartmentService;
/**
 * 
 * @author Sky
 *
 */
public class DepartmentService implements IDepartmentService{

	private DepartmentDAO departmentDAO;
	
	public Department getDepartmentByName(String name){
		List<Department> departments = departmentDAO.findByName(name);
		if(departments.size() == 0){
			return null;
		}else
			return departments.get(0);
	}
	
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
