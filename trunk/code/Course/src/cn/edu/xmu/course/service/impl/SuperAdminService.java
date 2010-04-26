package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.DepartmentDAO;
import cn.edu.xmu.course.dao.GradeDAO;
import cn.edu.xmu.course.dao.SchoolDAO;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.ISuperAdminService;

/**
 * �����Ǹ��𳬼�����Աҵ���service�ӿڣ���Ҫ����Ժϵ�������Ź����꼶����ģ��
 * @author ֣����
 *
 */
public class SuperAdminService implements ISuperAdminService {

	private SchoolDAO schoolDAO;
	private DepartmentDAO departmentDAO;
	private GradeDAO gradeDAO;

	/*
	 * ��֤ѧԺ����(non-Javadoc)
	 * @see cn.edu.xmu.course.service.ISuperAdminService#checkSchool(java.lang.String)
	 */
	public School checkSchool(String name){
		List<School> schools = schoolDAO.findByName(name);
		if(schools.size()==0){
			return null;
		}else
			return schools.get(0);
	}
	
	/*
	 * ���ϵ(non-Javadoc)
	 * @see cn.edu.xmu.course.service.ISuperAdminService#addDepartment(cn.edu.xmu.course.pojo.School, cn.edu.xmu.course.pojo.Department)
	 */
	public boolean addDepartment(School school, Department department) {
		// TODO Auto-generated method stub
		//department.setSchool(school);
		try {
			departmentDAO.save(department);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ����꼶(non-Javadoc)
	 * @see cn.edu.xmu.course.service.ISuperAdminService#addGrade(cn.edu.xmu.course.pojo.Grade)
	 */
	public boolean addGrade(Grade grade) {
		// TODO Auto-generated method stub
		List<Grade> gradeList = gradeDAO.findByGrade(grade);
		if(gradeList.size()!=0){
			return false;
		}
		try {
			gradeDAO.save(grade);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/*
	 * ���ѧԺ(non-Javadoc)
	 * @see cn.edu.xmu.course.service.ISuperAdminService#addSchool(cn.edu.xmu.course.pojo.School)
	 */
	public boolean addSchool(School school) {
		// TODO Auto-generated method stub
		try {
			schoolDAO.save(school);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ɾ��ϵ(non-Javadoc)
	 * @see cn.edu.xmu.course.service.ISuperAdminService#deleteDepartment(cn.edu.xmu.course.pojo.Department)
	 */
	public boolean deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		try {
			departmentDAO.delete(department);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ɾ���꼶(non-Javadoc)
	 * @see cn.edu.xmu.course.service.ISuperAdminService#deleteGrade(cn.edu.xmu.course.pojo.Grade)
	 */
	public boolean deleteGrade(Grade grade) {
		// TODO Auto-generated method stub
		try {
			gradeDAO.delete(grade);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ɾ��ѧԺ(non-Javadoc)
	 * @see cn.edu.xmu.course.service.ISuperAdminService#deleteSchool(cn.edu.xmu.course.pojo.School)
	 */
	public boolean deleteSchool(School school) {
		// TODO Auto-generated method stub
		try {
			schoolDAO.delete(school);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * ���������꼶(non-Javadoc)
	 * @see cn.edu.xmu.course.service.ISuperAdminService#findAllGrade()
	 */
	public List findAllGrade() {
		// TODO Auto-generated method stub
		return gradeDAO.findAll();
	}

	/*
	 * ��������ѧԺ(non-Javadoc)
	 * @see cn.edu.xmu.course.service.ISuperAdminService#findAllSchool()
	 */
	public List findAllSchool() {
		// TODO Auto-generated method stub
		return schoolDAO.findAll();
	}

	/*
	 * ����ѧԺ�����꼶(non-Javadoc)
	 * @see cn.edu.xmu.course.service.ISuperAdminService#findDepartmentBySchool(cn.edu.xmu.course.pojo.School)
	 */
	public List findDepartmentBySchool(School school) {
		// TODO Auto-generated method stub
		return departmentDAO.findByProperty("school", school);
	}

	public SchoolDAO getSchoolDAO() {
		return schoolDAO;
	}

	public void setSchoolDAO(SchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public GradeDAO getGradeDAO() {
		return gradeDAO;
	}

	public void setGradeDAO(GradeDAO gradeDAO) {
		this.gradeDAO = gradeDAO;
	}

	public Grade findGradeById(int id) {
		// TODO Auto-generated method stub
		return gradeDAO.findById(id);
	}

	public School findSchoolById(int id) {
		// TODO Auto-generated method stub
		return schoolDAO.findById(id);
	}
	
	public Department findDepartmentById(int id){
		return departmentDAO.findById(id);
	}

}
