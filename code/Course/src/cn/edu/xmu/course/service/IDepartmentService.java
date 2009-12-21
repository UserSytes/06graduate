package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.Department;

public interface IDepartmentService {

	/**
	 * 根据系别id获得系
	 * @param departmentId
	 * @return
	 */
	public Department getDepartmentById(Integer departmentId);
}
