package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.IAdminService;
import cn.edu.xmu.course.service.ISuperAdminService;

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

	private ISuperAdminService superAdminService;	//����У������Ա�Ľӿ�
	private IAdminService adminService;	//����ѧԺ����Ա��ѧԺ��Ϣ�Ľӿ�

	private String schoolName;	//ѧԺ����
	private List<School> allSchoolList;	//ѧԺ�б�
	private List<Department> departmentList;	//ϵ�б�
	private int schoolId;	//ѧԺId
	private School school;	//ѧԺ
	private int departmentId;	//ϵid
	private Department department;	//ϵ

	// ���ѧԺ����Ա
	private int adminSchoolId;	//ѧԺ����Ա����ѧԺid
	private Administrator admin;	//ѧԺ����Ա
	private School adminSchool;	//ѧԺ����Ա����ѧԺ	
	private int adminId;	//ѧԺ����Աid
	private List<Administrator> adminList;	//ѧԺ����Ա�б�

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
		result = superAdminService.addSchool(school);
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
		allSchoolList = superAdminService.findAllSchool();
		// System.out.println("test:  "+allSchoolList.get(6).getName());
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
		school = superAdminService.findSchoolById(schoolId);
		departmentList = superAdminService.findDepartmentBySchool(school);
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
		School s = superAdminService.findSchoolById(schoolId);
		boolean result = superAdminService.deleteSchool(s);
		if (result) {
			this.findAllSchools();
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ���ѧԺ����Ա
	 * 
	 * @return
	 */
	public String addAdmin() {
		adminSchool = superAdminService.findSchoolById(adminSchoolId);
		boolean result = false;
		result = adminService.addAdmin(admin, adminSchool);
		if (result) {
			addActionMessage("���ѧԺ����Ա�ɹ���");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ����꼶
	 * 
	 * @return
	 */
	public String addGrade() {
		boolean result = false;
		result = superAdminService.addGrade(grade);
		if (result) {
			addActionMessage("����꼶�ɹ���");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ɾ��ϵ
	 * 
	 * @return
	 */
	public String deleteDepartment() {
		Department d = superAdminService.findDepartmentById(departmentId);
		boolean result = superAdminService.deleteDepartment(d);
		if (result) {
			this.findDepartmentBySchool();
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��ת�����ϵ
	 * 
	 * @return
	 */
	public String goAddDepartment() {
		school = superAdminService.findSchoolById(schoolId);
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
		// department.setSchool(school);
		school = superAdminService.findSchoolById(schoolId);
		// System.out.println("����2�� "+school);
		// System.out.println("����3�� "+school.getName());
		department.setSchool(school);
		boolean result = superAdminService.addDepartment(school, department);
		if (result) {
			addActionMessage("���ϵ�ɹ���");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��ת��ѧԺ����Ա�б�
	 * 
	 * @return
	 */
	public String getAllAdmin() {
		adminList = adminService.findAllAdmin();
		if (adminList.size() != 0) {
			return SUCCESS;
		} else {
			addActionMessage("Ŀǰ��û��ѧԺ����Ա��");
			return ERROR;
		}

	}

	/**
	 * ɾ��ѧԺ����Ա
	 * 
	 * @return
	 */
	public String deleteAdmin() {
		Administrator a = adminService.findAdminById(adminId);
		boolean result = adminService.deleteAdmin(a);
		if (result) {
			adminList = adminService.findAllAdmin();
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
		allGradeList = superAdminService.findAllGrade();
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
		Grade g = superAdminService.findGradeById(gradeId);
		boolean result = superAdminService.deleteGrade(g);
		if (result) {
			allGradeList = superAdminService.findAllGrade();
			return SUCCESS;
		} else
			return ERROR;
	}

	public ISuperAdminService getSuperAdminService() {
		return superAdminService;
	}

	public void setSuperAdminService(ISuperAdminService superAdminService) {
		this.superAdminService = superAdminService;
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

	public School getAdminSchool() {
		return adminSchool;
	}

	public void setAdminSchool(School adminSchool) {
		this.adminSchool = adminSchool;
	}

	public int getAdminSchoolId() {
		return adminSchoolId;
	}

	public void setAdminSchoolId(int adminSchoolId) {
		this.adminSchoolId = adminSchoolId;
	}

	public IAdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
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

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
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

	public List<Administrator> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<Administrator> adminList) {
		this.adminList = adminList;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

}
