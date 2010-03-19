package cn.edu.xmu.course.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Pattern;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IStudentInfoService;
import cn.edu.xmu.course.service.ISuperAdminService;

/**
 * ѧ�����ҡ���ӡ�ɾ��
 * 
 * @author Sky
 * 
 */
public class StudentAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IStudentInfoService studentInfoService;
	private ISuperAdminService superAdminService;

	private Student student;
	private UserInfo userInfo;
	private School school;
	private Grade grade;
	private Department department;

	private List<Department> departmentList;
	private List<Student> studentList;
	private List<Grade> gradeList;

	private int departmentId;
	private int gradeId;
	private int studentId;

	private File studentFile;
	private String studentFileContentType;
	private String studentFileName;

	/**
	 * ��ȡĳѧԺ������ϵ
	 * 
	 * @return
	 */
	public String getDepartmentBySchool() {
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		School school = admin.getSchool();
		departmentList = superAdminService.findDepartmentBySchool(school);

		if (departmentList.size() == 0) {
			addActionMessage("��ѧԺ��û��ϵ�������� У������Ա���뿪��ϵ��");
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * ��ʼ�����ѧ������
	 * 
	 * @return
	 */
	public String goAddStudent() {
		gradeList = superAdminService.findAllGrade();
		if (gradeList.size() == 0) {
			addActionMessage("ѧУδ���ѧ���꼶��������У��������ӣ�");
			return ERROR;
		}
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		School school = admin.getSchool();
		departmentList = superAdminService.findDepartmentBySchool(school);
		if (departmentList.size() == 0) {
			addActionMessage("��ѧԺ��û��ϵ�������� У������Ա���뿪��ϵ��");
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * ���ѧ��
	 * 
	 * @return
	 */
	public String addStudent() {
		boolean result = false;
		Grade grade = superAdminService.findGradeById(gradeId);
		student.setGrade(grade);
		Department department = superAdminService
				.findDepartmentById(departmentId);
		student.setPassword(student.getStudentNo());
		userInfo.setDepartment(department);
		student.setUserInfo(userInfo);
		result = studentInfoService.addStudent(student, userInfo);
		if (result) {
			addActionMessage("���ѧ���ɹ���");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��ת���������ѧ��
	 * @return
	 */
	public String goAddMoreStudent() {
		gradeList = superAdminService.findAllGrade();
		if (gradeList.size() == 0) {
			addActionMessage("ѧУδ���ѧ���꼶��������У��������ӣ�");
			return ERROR;
		}
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		departmentList = superAdminService.findDepartmentBySchool(admin
				.getSchool());
		if (departmentList.size() == 0) {
			addActionMessage("��ѧԺ��û��ϵ�������� У������Ա���뿪��ϵ��");
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * �������ѧ��
	 * 
	 * @return
	 */
	public String addMoreStudent() {
		Grade grade = superAdminService.findGradeById(gradeId);
		Department department = superAdminService
				.findDepartmentById(departmentId);
		String result =studentInfoService.addMoreStudent(student, grade, department, studentFile);
		addActionError(result);	
		return SUCCESS;

	}

	/**
	 * ����ɾ��ѧ��
	 * @return
	 */
	public String deleteMoreStudent(){
		Grade grade = superAdminService.findGradeById(gradeId);
		Department department = superAdminService
				.findDepartmentById(departmentId);
		List<Student> students = studentInfoService.findByDepartmentAndGrade(department, grade);
		if(students.size()==0){
			addActionMessage(department.getName()+grade.getName()+grade.getGrade()+"��Ŀǰû��ѧ�����޷�ִ��ɾ��������");
			return SUCCESS;
		}
		int result = studentInfoService.deleteMoreStudent(grade, department);
		int temp = students.size() - result;
		if (temp == students.size()) {
			addActionMessage("����ɾ��ѧ��ʧ�ܣ�������ɾ����");
		} if(temp == 0){
			addActionMessage("����ɾ��ѧ���ɹ����ܹ�ɾ��"+result+"��ѧ����");
		}else
			addActionMessage("����ɾ��ѧ��ʧ�ܣ�ɾ��"+result+"��ѧ��������"+temp+"��ѧ��δɾ���������ɾ��ѧ����");
			return SUCCESS;
	}

	/**
	 * �������е��꼶
	 * 
	 * @return
	 */
	public String findAllGrade() {
		gradeList = superAdminService.findAllGrade();
		if (gradeList.size() == 0) {
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * �����꼶����ϵ����ѧ��
	 * 
	 * @return
	 */
	public String findStudentsByGrade() {
		if (gradeId == -1 && departmentId == -1) {
			return this.findStudentBySchool();
		} else if (gradeId == -1 && departmentId != -1) {
			department = superAdminService.findDepartmentById(departmentId);
			studentList = studentInfoService.findByDepartment(department);
			if (studentList.size() == 0) {
				addActionMessage(department.getName() + "��δ���ѧ����");
				return ERROR;
			} else {
				this.goAddStudent();
				return SUCCESS;
			}
		} else if (gradeId != -1 && departmentId == -1) {
			grade = superAdminService.findGradeById(gradeId);
			studentList = studentInfoService.findByGrade(grade);
			if (studentList.size() == 0) {
				addActionMessage(grade.getName() + grade.getGrade()
						+ "�� ��δ���ѧ����");
				return ERROR;
			} else {
				this.goAddStudent();
				return SUCCESS;
			}
		} else {
			department = superAdminService.findDepartmentById(departmentId);
			grade = superAdminService.findGradeById(gradeId);
			studentList = studentInfoService.findByDepartmentAndGrade(
					department, grade);
			if (studentList.size() == 0) {
				addActionMessage(grade.getName() + grade.getGrade() + "��"
						+ department.getName() + "��δ���ѧ����");
				return ERROR;
			} else {
				this.goAddStudent();
				return SUCCESS;
			}
		}
	}

	/**
	 * ����ѧԺ����ѧ��
	 * 
	 * @return
	 */
	public String findStudentBySchool() {
		this.goAddStudent();
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		School school = admin.getSchool();
		studentList = studentInfoService.findBySchool(school);
		// System.out.println("����1�� "+studentList.size());
		if (studentList.size() == 0) {
			addActionMessage("��ѧԺ��δ���ѧ����");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * ��ת���༭ѧ��
	 * 
	 * @return
	 */
	public String goEditStudent() {
		this.getDepartmentBySchool();
		this.findAllGrade();
		student = studentInfoService.findById(studentId);
		userInfo = student.getUserInfo();
		if (null == student) {
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * �༭ѧ����Ϣ
	 * 
	 * @return
	 */
	public String editStudent() {
		System.out.print("�����޸�ѧ����Ϣ��"+userInfo.getName());
		boolean result = studentInfoService.updateStudent(student, userInfo);
		if (result) {
			addActionMessage("�޸�ѧ����Ϣ�ɹ���");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ɾ��ѧ��
	 * 
	 * @return
	 */
	public String deleteStudent() {
		student = studentInfoService.findById(studentId);
		boolean result = studentInfoService.deleteStudent(student);
		if (result) {
			this.findStudentBySchool();
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ����ɾ��ѧ��
	 * 
	 * @return
	 */
	public String deleteStudentList() {
		System.out.println("����1�� " + studentList.size());
		for (Student s : studentList) {
			System.out.println("�����У� " + s.getStudentNo());
			studentInfoService.deleteStudent(s);
		}
		System.out.println("����2�� ");
		return SUCCESS;
	}

	public IStudentInfoService getStudentInfoService() {
		return studentInfoService;
	}

	public void setStudentInfoService(IStudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}

	public ISuperAdminService getSuperAdminService() {
		return superAdminService;
	}

	public void setSuperAdminService(ISuperAdminService superAdminService) {
		this.superAdminService = superAdminService;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Grade> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<Grade> gradeList) {
		this.gradeList = gradeList;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public File getStudentFile() {
		return studentFile;
	}

	public void setStudentFile(File studentFile) {
		this.studentFile = studentFile;
	}

	public String getStudentFileContentType() {
		return studentFileContentType;
	}

	public void setStudentFileContentType(String studentFileContentType) {
		this.studentFileContentType = studentFileContentType;
	}

	public String getStudentFileName() {
		return studentFileName;
	}

	public void setStudentFileName(String studentFileName) {
		this.studentFileName = studentFileName;
	}

}
