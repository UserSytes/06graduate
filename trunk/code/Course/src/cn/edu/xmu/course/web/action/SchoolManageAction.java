package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.ISchoolService;

/**
 * ����ѧԺ�������
 * @author ֣����
 *
 */
public class SchoolManageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ISchoolService schoolService;	//����ѧԺ�꼶�Ľӿ�

	private String schoolName;	//ѧԺ����
	private List<School> allSchoolList;	//ѧԺ�б�
	private List<Department> departmentList;	//ϵ�б�
	private int schoolId;	//ѧԺId
	private School school;	//ѧԺ
	private int departmentId;	//ϵid
	private Department department;	//ϵ

	// �꼶����
	private List<Grade> allGradeList;	//�꼶�б�
	private Grade grade;	//�꼶
	private int gradeId;	//�꼶id

	/**
	 * ���ѧԺ
	 * 
	 * @return
	 */
	public String addSchool() {
		boolean result = false;
		result = schoolService.addSchool(school);
		if (result) {
			addActionMessage("���ѧԺ�ɹ���");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��������ѧԺ
	 * 
	 * @return
	 */
	public String findAllSchools() {
		allSchoolList = schoolService.findAllSchool();
		if (allSchoolList.size() == 0) {
			return ERROR;
		} else
			return "allSchools";
	}

	/**
	 * ����ϵ
	 * 
	 * @return
	 */
	public String findDepartmentBySchool() {
		school = schoolService.findSchoolById(schoolId);
		departmentList = schoolService.findDepartmentBySchool(school);
		if (departmentList.size() == 0) {
			addActionMessage("��ѧԺû��ϵ��");
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * ɾ��ѧԺ
	 * 
	 * @return
	 */
	public String deleteSchool() {
		School s = schoolService.findSchoolById(schoolId);
		boolean result = schoolService.deleteSchool(s);
		if (result) {
			this.findAllSchools();
			return SUCCESS;
		} else{
			addActionMessage("��ѧԺ����ϵ������ɾ��ϵ��ɾ��ѧԺ��");
			return ERROR;
		}
	}

	/**
	 * ����꼶
	 * 
	 * @return
	 */
	public String addGrade() {
		boolean result = false;
		result = schoolService.addGrade(grade);
		if (result) {
			addActionMessage("����꼶�ɹ���");
			return SUCCESS;
		} else{
			addActionMessage("����ӵ��꼶�Ѿ����ڣ�");
			return ERROR;
		}
	}

	/**
	 * ɾ��ϵ
	 * 
	 * @return
	 */
	public String deleteDepartment() {
		Department d = schoolService.findDepartmentById(departmentId);
		boolean result = schoolService.deleteDepartment(d);
		if (result) {
			this.findDepartmentBySchool();
			return SUCCESS;
		} else{
			addActionMessage("��ϵ����ѧ��������ɾ��ѧ����ɾ��ϵ��");
			return ERROR;
		}
	}

	/**
	 * ��ת�����ϵ
	 * 
	 * @return
	 */
	public String goAddDepartment() {
		school = schoolService.findSchoolById(schoolId);
		if (school == null)
			return ERROR;
		else
			return SUCCESS;
	}

	/**
	 * ���ϵ
	 * 
	 * @return
	 */
	public String addDepartment() {
		school = schoolService.findSchoolById(schoolId);	
		boolean result = schoolService.addDepartment(school, department);
		if (result) {
			addActionMessage("���ϵ�ɹ���");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ���������꼶
	 * 
	 * @return
	 */
	public String findAllGrade() {
		allGradeList = schoolService.findAllGrade();
		if (allGradeList.size() != 0) {
			return SUCCESS;
		} else {
			addActionMessage("Ŀǰ��û���꼶��");
			return ERROR;
		}
	}

	/**
	 * ɾ���꼶
	 * 
	 * @return
	 */
	public String deleteGrade() {
		Grade g = schoolService.findGradeById(gradeId);
		boolean result = schoolService.deleteGrade(g);
		if (result) {
			allGradeList = schoolService.findAllGrade();
			return SUCCESS;
		} else{
			addActionMessage("���꼶����ѧ��������ɾ��ѧ����ɾ���꼶��");
			return ERROR;
		}
	}

	public ISchoolService getSuperAdminService() {
		return schoolService;
	}

	public void setSuperAdminService(ISchoolService schoolService) {
		this.schoolService = schoolService;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public List<School> getAllSchoolList() {
		return allSchoolList;
	}

	public void setAllSchoolList(List<School> allSchoolList) {
		this.allSchoolList = allSchoolList;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	
	public List<Grade> getAllGradeList() {
		return allGradeList;
	}

	public void setAllGradeList(List<Grade> allGradeList) {
		this.allGradeList = allGradeList;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public ISchoolService getSchoolService() {
		return schoolService;
	}

	public void setSchoolService(ISchoolService schoolService) {
		this.schoolService = schoolService;
	}

}
