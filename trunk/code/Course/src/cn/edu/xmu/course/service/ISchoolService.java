package cn.edu.xmu.course.service;

import java.util.List;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;

/**
 * 此接口是负责超级管理员业务的service接口，主要包括院系管理、年级管理模块
 * @author 郑冰凌
 *
 */
public interface ISchoolService {

	/**
	 * 添加学院
	 * @param school
	 * @return
	 */
	public boolean addSchool(School school);
	
	/**
	 * 删除学院
	 * @param school
	 * @return
	 */
	public boolean deleteSchool(School school);
	
	/**
	 * 添加系
	 * @param school
	 * @param department
	 * @return
	 */
	public boolean addDepartment(School school, Department department);
	
	/**
	 * 删除系
	 * @param department
	 * @return
	 */
	public boolean deleteDepartment(Department department);
	
	/**
	 * 验证学院名dwr
	 * @param name
	 * @return
	 */
	public School checkSchool(String name);
	
	/**
	 * 查找所有学院
	 * @return
	 */
	public List findAllSchool();
	
	/**
	 * 根据id查找学院
	 * @param id
	 * @return
	 */
	public School findSchoolById(int id);
	
	/**
	 * 查找学院的系
	 * @param school
	 * @return
	 */
	public List findDepartmentBySchool(School school);
	
	/**
	 * 根据Id查找系
	 * @param id
	 * @return
	 */
	public Department findDepartmentById(int id);

	/**
	 * 添加年级
	 */
	public boolean addGrade(Grade grade);
	
	/**
	 * 删除年级
	 * @param grade
	 * @return
	 */
	public boolean deleteGrade(Grade grade);
	
	/**
	 * 查找所有年级
	 * @return
	 */
	public List findAllGrade();
	
	/**
	 * 根据id查找年级
	 * @param id
	 * @return
	 */
	public Grade findGradeById(int id);
	
	/**
	 * 根据名字查找学院
	 * @param name
	 * @return
	 */
	public School findSchoolByName(String name);
}
