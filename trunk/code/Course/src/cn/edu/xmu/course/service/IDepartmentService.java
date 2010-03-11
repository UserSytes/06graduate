package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.Department;
/**
 * 
 * @author Sky
 *
 */
public interface IDepartmentService {

	/**
	 * ����ϵ��id���ϵ
	 * @param departmentId
	 * @return
	 */
	public Department getDepartmentById(Integer departmentId);
	
	/**
	 * �������Ʋ���ϵ
	 * @param name
	 * @return
	 */
	public Department getDepartmentByName(String name);
}
