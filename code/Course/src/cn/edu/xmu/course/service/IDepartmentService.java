package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.Department;
/**
 * 
 * @author Sky
 *
 */
public interface IDepartmentService {

	/**
	 * 根据系别id获得系
	 * @param departmentId
	 * @return
	 */
	public Department getDepartmentById(Integer departmentId);
	
	/**
	 * 根据名称查找系
	 * @param name
	 * @return
	 */
	public Department getDepartmentByName(String name);
}
