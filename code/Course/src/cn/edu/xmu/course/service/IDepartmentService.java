package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.Department;

public interface IDepartmentService {

	/**
	 * ����ϵ��id���ϵ
	 * @param departmentId
	 * @return
	 */
	public Department getDepartmentById(Integer departmentId);
}
