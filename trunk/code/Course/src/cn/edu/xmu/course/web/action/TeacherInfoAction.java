package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.*;
import cn.edu.xmu.course.service.ITeacherInfoService;

public class TeacherInfoAction extends BaseAction{

	private ITeacherInfoService teacherInfoService;
	
	private Teacher teacher;
	private UserInfo userInfo;
	private String password;
	private String newPassword;
	
	private List<Teacher> teacherList;
	private List<Department> departmentList;
	private int teacherId;
	
	public String changePassword(){
		teacher = teacherInfoService.getTeacher("123");
		if(teacher.getPassword().equals(password)){
			teacher.setPassword(newPassword);
			if(teacherInfoService.changePassword(teacher))
				return SUCCESS;
			else
				return "fail";
		}
		else
			return ERROR;
	}
	
	public String changeTeacherInfo(){
		if(teacherInfoService.updateTeacher(teacher, userInfo))
			return SUCCESS;
		else
			return ERROR;
	}
	
	public String getTeacherInfo(){
		teacher = teacherInfoService.getTeacher("123");
		userInfo = teacher.getUserInfo();
		return SUCCESS;
	}
	
	/**
	 * 根据学院查找所有教师
	 * @return
	 */
	public String findTeacherBySchool(){
		Administrator admin = (Administrator) ActionSession.getSession().get(ADMIN);
		School school = admin.getSchool();
		teacherList = teacherInfoService.findTeacherBySchool(school);
		if (teacherList.size() == 0) {
			addActionMessage("本学院还没添加教师！");
			return ERROR;
		} else
			return SUCCESS;
	}
	
	/**
	 * 获取某学院的所有系
	 * @return
	 */
	public String getDepartmentBySchool(){
		Administrator admin = (Administrator) ActionSession.getSession().get(ADMIN);
		School school = admin.getSchool();
		departmentList = (List<Department>) school.getDepartments();
		if (departmentList.size() == 0) {
			addActionMessage("本学院还没有系，请先向 校方管理员申请开设系！");
			return ERROR;
		} else
			return SUCCESS;
	}
	
	/**
	 * 添加教师
	 * @return
	 */
	public String addTeacher(){
		boolean result = false;
		teacher.setPassword(teacher.getTeacherNo());
		result = teacherInfoService.addTeacher(teacher);
		if (result) {
			addActionMessage("添加教师成功！");
			return SUCCESS;
		} else
			return ERROR;
	}
	
	/**
	 * 删除教师
	 * @return
	 */
	public String deleteTeacher(){
		teacher = teacherInfoService.findTeacherById(teacherId);
		boolean result = teacherInfoService.deleteTeacher(teacher);
		if (result) {
			this.findTeacherBySchool();
			return SUCCESS;
		} else
			return ERROR;
	}
	
	/**
	 * 跳转到修改教师信息
	 * @return
	 */
	public String goEditTeacher(){
		teacher = teacherInfoService.findTeacherById(teacherId);
		if(null == teacher){
			return ERROR;
		}
		else
			return SUCCESS;
	}
	
	public void setTeacherInfoService(ITeacherInfoService teacherInfoService) {
		this.teacherInfoService = teacherInfoService;
	}

	public ITeacherInfoService getTeacherInfoService() {
		return teacherInfoService;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
	
}
