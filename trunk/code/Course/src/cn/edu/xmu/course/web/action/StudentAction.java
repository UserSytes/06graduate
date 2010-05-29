package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.commons.MD5;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.ISchoolService;
import cn.edu.xmu.course.service.IStudentInfoService;

/**
 * ѧ�����ҡ���ӡ�ɾ��
 * 
 * @author ֣����
 * 
 */
public class StudentAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IStudentInfoService studentInfoService;	//����ѧ����Ϣ�Ľӿ�
	private ISchoolService schoolService;	//����У������Ա��Ϣ�Ľӿ�

	private Student student;	//ѧ��
	private UserInfo userInfo;	//�û���Ϣ
	private School school;	//ѧԺ
	private Grade grade;	//�꼶
	private Department department;	//ϵ

	private List<Department> departmentList;	//ϵ�б�
	private List<Student> studentList;	//ѧ���б�
	private List<Grade> gradeList;	//�꼶�б�

	private int departmentId;	//ϵid
	private int gradeId;	//�꼶Id
	private int studentId;	//ѧ��id

	private File studentFile;	//ѧ����Ϣ�ļ�
	private String studentFileContentType;	//ѧ����Ϣ�ļ�����
	private String studentFileName;	//ѧ����Ϣ�ļ�����
	
	private String studentNo;	//ѧ��ѧ�š��ʺ�

	/**
	 * ��ȡĳѧԺ������ϵ
	 * 
	 * @return
	 */
	public String getDepartmentBySchool() {
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		School school = admin.getSchool();
		departmentList = getSchoolService().findDepartmentBySchool(school);

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
		gradeList = getSchoolService().findAllGrade();
		if (gradeList.size() == 0) {
			addActionMessage("ѧУδ���ѧ���꼶��������У��������ӣ�");
			return ERROR;
		}
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		School school = admin.getSchool();
		departmentList = getSchoolService().findDepartmentBySchool(school);
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
		Grade grade = getSchoolService().findGradeById(gradeId);
		student.setGrade(grade);
		Department department = getSchoolService()
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
		gradeList = getSchoolService().findAllGrade();
		if (gradeList.size() == 0) {
			addActionMessage("ѧУδ���ѧ���꼶��������У��������ӣ�");
			return ERROR;
		}
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		departmentList = getSchoolService().findDepartmentBySchool(admin
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
		Grade grade = getSchoolService().findGradeById(gradeId);
		Department department = getSchoolService()
				.findDepartmentById(departmentId);
		String result =studentInfoService.addMoreStudent(grade, department, studentFile);
		addActionError(result);	
		return SUCCESS;

	}

	/**
	 * ����ɾ��ѧ��
	 * @return
	 */
	public String deleteMoreStudent(){
		Grade grade = getSchoolService().findGradeById(gradeId);
		Department department = getSchoolService()
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
		gradeList = getSchoolService().findAllGrade();
		if (gradeList.size() == 0) {
			return ERROR;
		} else {
			return SUCCESS;
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
		boolean result = studentInfoService.updateStudent(student, userInfo);
		if (result) {
			addActionMessage("�޸�ѧ����Ϣ�ɹ���");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��ԭ��ʼ����
	 * @return
	 */
	public String restorePassword(){
		student = studentInfoService.findById(studentId);
		student.setPassword(new MD5().getMD5ofStr(student.getStudentNo()));
		if(studentInfoService.updatePassword(student)){
			addActionMessage("��ԭ����ɹ���");
			return SUCCESS;
		}
		else
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


	public IStudentInfoService getStudentInfoService() {
		return studentInfoService;
	}

	public void setStudentInfoService(IStudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}

	public ISchoolService getschoolService() {
		return getSchoolService();
	}

	public void setschoolService(ISchoolService schoolService) {
		this.setSchoolService(schoolService);
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

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setSchoolService(ISchoolService schoolService) {
		this.schoolService = schoolService;
	}

	public ISchoolService getSchoolService() {
		return schoolService;
	}

}
