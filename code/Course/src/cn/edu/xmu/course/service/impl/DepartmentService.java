package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.DepartmentDAO;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.service.IDepartmentService;
/**
 * �����Ǹ������ϵ
 * @author ֣����
 *
 */
public class DepartmentService implements IDepartmentService{

	private DepartmentDAO departmentDAO;
	
	/*
	 * �������ƻ�ȡϵ(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IDepartmentService#getDepartmentByName(java.lang.String)
	 */
	public Department getDepartmentByName(String name){
		List<Department> departments = departmentDAO.findByName(name);
		if(departments.size() == 0){
			return null;
		}else
			return departments.get(0);
	}
	
	/*
	 * ����id����ϵ(non-Javadoc)
	 * @see cn.edu.xmu.course.service.IDepartmentService#getDepartmentById(java.lang.Integer)
	 */
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
