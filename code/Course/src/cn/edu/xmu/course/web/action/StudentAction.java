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
 * 学生查找、添加、删除
 * 
 * @author 郑冰凌
 * 
 */
public class StudentAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IStudentInfoService studentInfoService;	//管理学生信息的接口
	private ISuperAdminService superAdminService;	//管理校方管理员信息的接口

	private Student student;	//学生
	private UserInfo userInfo;	//用户信息
	private School school;	//学院
	private Grade grade;	//年级
	private Department department;	//系

	private List<Department> departmentList;	//系列表
	private List<Student> studentList;	//学生列表
	private List<Grade> gradeList;	//年级列表

	private int departmentId;	//系id
	private int gradeId;	//年级Id
	private int studentId;	//学生id

	private File studentFile;	//学生信息文件
	private String studentFileContentType;	//学生信息文件类型
	private String studentFileName;	//学生信息文件名称
	
	private String studentNo;	//学生学号、帐号

	/**
	 * 获取某学院的所有系
	 * 
	 * @return
	 */
	public String getDepartmentBySchool() {
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		School school = admin.getSchool();
		departmentList = superAdminService.findDepartmentBySchool(school);

		if (departmentList.size() == 0) {
			addActionMessage("本学院还没有系，请先向 校方管理员申请开设系！");
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * 初始化添加学生界面
	 * 
	 * @return
	 */
	public String goAddStudent() {
		gradeList = superAdminService.findAllGrade();
		if (gradeList.size() == 0) {
			addActionMessage("学校未添加学生年级，请先向校方申请添加！");
			return ERROR;
		}
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		School school = admin.getSchool();
		departmentList = superAdminService.findDepartmentBySchool(school);
		if (departmentList.size() == 0) {
			addActionMessage("本学院还没有系，请先向 校方管理员申请开设系！");
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * 添加学生
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
		String photo = "photo/defaultPhoto.jpg";
		userInfo.setPhoto(photo);
		student.setUserInfo(userInfo);
		result = studentInfoService.addStudent(student, userInfo);
		if (result) {
			addActionMessage("添加学生成功！");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 跳转到批量添加学生
	 * @return
	 */
	public String goAddMoreStudent() {
		gradeList = superAdminService.findAllGrade();
		if (gradeList.size() == 0) {
			addActionMessage("学校未添加学生年级，请先向校方申请添加！");
			return ERROR;
		}
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		departmentList = superAdminService.findDepartmentBySchool(admin
				.getSchool());
		if (departmentList.size() == 0) {
			addActionMessage("本学院还没有系，请先向 校方管理员申请开设系！");
			return ERROR;
		} else
			return SUCCESS;
	}

	/**
	 * 批量添加学生
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
	 * 批量删除学生
	 * @return
	 */
	public String deleteMoreStudent(){
		Grade grade = superAdminService.findGradeById(gradeId);
		Department department = superAdminService
				.findDepartmentById(departmentId);
		List<Student> students = studentInfoService.findByDepartmentAndGrade(department, grade);
		if(students.size()==0){
			addActionMessage(department.getName()+grade.getName()+grade.getGrade()+"级目前没有学生，无法执行删除操作！");
			return SUCCESS;
		}
		int result = studentInfoService.deleteMoreStudent(grade, department);
		int temp = students.size() - result;
		if (temp == students.size()) {
			addActionMessage("批量删除学生失败，请重新删除！");
		} if(temp == 0){
			addActionMessage("批量删除学生成功，总共删除"+result+"个学生！");
		}else
			addActionMessage("批量删除学生失败，删除"+result+"个学生！还有"+temp+"个学生未删除，请继续删除学生！");
			return SUCCESS;
	}

	/**
	 * 查找所有的年级
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
	 * 根据学院查找学生
	 * 
	 * @return
	 */
	public String findStudentBySchool() {
		this.goAddStudent();
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		School school = admin.getSchool();
		studentList = studentInfoService.findBySchool(school);
		if (studentList.size() == 0) {
			addActionMessage("本学院尚未添加学生！");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * 跳转到编辑学生
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
	 * 编辑学生信息
	 * 
	 * @return
	 */
	public String editStudent() {
		boolean result = studentInfoService.updateStudent(student, userInfo);
		if (result) {
			addActionMessage("修改学生信息成功！");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 删除学生
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

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentNo() {
		return studentNo;
	}

}
