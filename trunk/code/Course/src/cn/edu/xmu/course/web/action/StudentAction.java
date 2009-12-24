package cn.edu.xmu.course.web.action;

import java.util.ArrayList;
import java.util.List;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Grade;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IStudentInfoService;
import cn.edu.xmu.course.service.ISuperAdminService;

public class StudentAction extends BaseAction{
	
	private IStudentInfoService studentInfoService;
	private ISuperAdminService superAdminService;
	
	private Student student;
	private UserInfo userInfo;
	private School school;
	private Grade grade;

	private List<Department> departmentList ;
	private List<Student> studentList;
	private List<Grade> gradeList ;
	
	private int departmentId;
	private int gradeId;
	private int studentId;
	
	/**
	 * 获取某学院的所有系
	 * @return
	 */
	public String getDepartmentBySchool(){
		Administrator admin = (Administrator) ActionSession.getSession().get(ADMIN);
		School school = admin.getSchool();
		departmentList = superAdminService.findDepartmentBySchool(school);
		
		if (departmentList.size() == 0) {
			addActionMessage("本学院还没有系，请先向 校方管理员申请开设系！");
			return ERROR;
		} else
			return SUCCESS;
	}
	
	public String goAddStudent(){	
		gradeList = superAdminService.findAllGrade();
		if(gradeList.size()==0){
			return ERROR;
		}
		Administrator admin = (Administrator) ActionSession.getSession().get(ADMIN);
		School school = admin.getSchool();
		departmentList = superAdminService.findDepartmentBySchool(school);
		System.out.println("测试1： "+departmentList.size());
		if (departmentList.size() == 0) {
			addActionMessage("本学院还没有系，请先向 校方管理员申请开设系！");
			return ERROR;
		} else
			return SUCCESS;
	}
	
	/**
	 * 添加学生
	 * @return
	 */
	public String addStudent(){
		boolean result = false;
		Grade grade = superAdminService.findGradeById(gradeId);
		student.setGrade(grade);
		Department department = superAdminService.findDepartmentById(departmentId);
		student.setPassword(student.getStudentNo());
		userInfo.setDepartment(department);
		student.setUserInfo(userInfo);
		result = studentInfoService.addStudent(student, userInfo);
		if (result) {
			addActionMessage("添加学生成功！");
			return SUCCESS;
		} else
			return ERROR;
	}

	public String findAllGrade(){
		gradeList = superAdminService.findAllGrade();
		if(gradeList.size()==0){
			return ERROR;
		}else{
			return SUCCESS;
		}
	}
	
	public String findStudentsByGrade(){
		grade = superAdminService.findGradeById(gradeId);
		studentList = studentInfoService.findByGrade(grade);
		if(studentList.size()==0){
			addActionMessage("该年级尚未添加学生！");
			return ERROR;
		}else{
			return SUCCESS;
		}
	}
	
	public String findStudentBySchool(){
		Administrator admin = (Administrator) ActionSession.getSession().get(ADMIN);
		School school = admin.getSchool();
		studentList = studentInfoService.findBySchool(school);
		System.out.println("测试1： "+studentList.size());
		if(studentList.size()==0){
			addActionMessage("本学院尚未添加学生！");
			return ERROR;
		}else{
			return SUCCESS;
		}
	}
	
	public String goEditStudent(){
		return ERROR;
	}
	/**
	 * 删除学生
	 * @return
	 */
	public String deleteStudent(){
		student = studentInfoService.findById(studentId);
		boolean result = studentInfoService.deleteStudent(student);
		if(result){
			return SUCCESS;
		}else
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
	
	
}
