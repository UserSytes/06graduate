package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.dao.DepartmentDAO;
import cn.edu.xmu.course.dao.GradeDAO;
import cn.edu.xmu.course.dao.SchoolDAO;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.ISchoolService;

/**
 * 此类是负责超级管理员业务的service接口，主要包括院系管理、新闻管理、年级管理模块
 * 
 * @author 郑冰凌
 * 
 */
public class SchoolService implements ISchoolService {

	private SchoolDAO schoolDAO;
	private DepartmentDAO departmentDAO;
	private GradeDAO gradeDAO;

	/*
	 * 验证学院名称(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ISuperAdminService#checkSchool(java.lang.String
	 * )
	 */
	public School checkSchool(String name) {
		List<School> schools = schoolDAO.findByName(name);
		if (schools.size() == 0) {
			return null;
		} else
			return schools.get(0);
	}

	/*
	 * 添加系(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ISuperAdminService#addDepartment(cn.edu.xmu
	 * .course.pojo.School, cn.edu.xmu.course.pojo.Department)
	 */
	public boolean addDepartment(School school, Department department) {
		// TODO Auto-generated method stub
		department.setSchool(school);
		try {
			departmentDAO.save(department);
			this.createTreeData();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 添加年级(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ISuperAdminService#addGrade(cn.edu.xmu.course
	 * .pojo.Grade)
	 */
	public boolean addGrade(Grade grade) {
		// TODO Auto-generated method stub
		List<Grade> gradeList = gradeDAO.findByGrade(grade);
		if (gradeList.size() != 0) {
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
	 * 添加学院(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ISuperAdminService#addSchool(cn.edu.xmu.course
	 * .pojo.School)
	 */
	public boolean addSchool(School school) {
		// TODO Auto-generated method stub
		try {
			schoolDAO.save(school);
			this.createTreeData();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 删除系(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ISuperAdminService#deleteDepartment(cn.edu.
	 * xmu.course.pojo.Department)
	 */
	public boolean deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		try {
			departmentDAO.delete(department);
			this.createTreeData();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 删除年级(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ISuperAdminService#deleteGrade(cn.edu.xmu.course
	 * .pojo.Grade)
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
	 * 删除学院(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ISuperAdminService#deleteSchool(cn.edu.xmu.
	 * course.pojo.School)
	 */
	public boolean deleteSchool(School school) {
		// TODO Auto-generated method stub
		try {
			schoolDAO.delete(school);
			this.createTreeData();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 查找所有年级(non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.ISuperAdminService#findAllGrade()
	 */
	public List<Grade> findAllGrade() {
		// TODO Auto-generated method stub
		return gradeDAO.findAll();
	}

	/*
	 * 查找所有学院(non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.ISuperAdminService#findAllSchool()
	 */
	public List<School> findAllSchool() {
		// TODO Auto-generated method stub
		return schoolDAO.findAll();
	}

	/*
	 * 根据学院查找年级(non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ISuperAdminService#findDepartmentBySchool(cn
	 * .edu.xmu.course.pojo.School)
	 */
	public List<Department> findDepartmentBySchool(School school) {
		// TODO Auto-generated method stub
		return departmentDAO.findByProperty("school", school);
	}

	/**
	 * 创建树文件
	 */
	public void createTreeData() {
		String path = ServletActionContext.getServletContext().getRealPath("");
		File file = new File(path + "/" + "dept_data.properties");		
		List<School> schools = this.findAllSchool();
		try {
			if (file.exists())
				file.delete();
			file.createNewFile();
			FileOutputStream out = new FileOutputStream(file, true);
			StringBuffer sb = new StringBuffer();
			sb.append("[");
			int slength = schools.size();
			for (int i = 0; i < slength; i++) {
				sb.append("{");
				sb.append("\"id\":2,");
				sb.append("\"text\":\"" + schools.get(i).getName() + "\",");
				sb.append("\"state\":\"closed\",");
				sb.append("\"children\":[");
				List<Department> depts = this.findDepartmentBySchool(schools
						.get(i));
				int dlength = depts.size();
				if (dlength > 0) {
					for (int j = 0; j < dlength; j++) {
						sb.append("{");
						sb.append("\"id\":3,");
						sb
								.append("\"text\":\"" + depts.get(j).getName()
										+ "\"");
						sb.append("}");
						if (j < (dlength - 1))
							sb.append(",");
					}
				}
				sb.append("]}");
				if (i < (slength - 1))
					sb.append(",");
			}
			sb.append("]");
			out.write(sb.toString().getBytes("utf-8"));
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.ISchoolService#findGradeById(int)
	 */
	public Grade findGradeById(int id) {
		// TODO Auto-generated method stub
		return gradeDAO.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.ISchoolService#findSchoolById(int)
	 */
	public School findSchoolById(int id) {
		// TODO Auto-generated method stub
		return schoolDAO.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.edu.xmu.course.service.ISchoolService#findDepartmentById(int)
	 */
	public Department findDepartmentById(int id) {
		return departmentDAO.findById(id);
	}

	/*
	 * 根据学院名字查找
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ISuperAdminService#findSchoolByName(java.lang
	 * .String)
	 */
	public School findSchoolByName(String name) {
		// TODO Auto-generated method stub
		List<School> schools = schoolDAO.findByName(name);
		if (schools.size() > 0)
			return schools.get(0);
		else
			return null;
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
}
