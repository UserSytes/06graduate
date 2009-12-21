package cn.edu.xmu.course.web.action;

import cn.edu.xmu.course.pojo.*;
import cn.edu.xmu.course.service.ITeacherInfoService;

public class TeacherInfoAction extends BaseAction{

	private ITeacherInfoService teacherInfoService;
	
	private Teacher teacher;
	
	private UserInfo userInfo;

	private String password;
	
	private String newPassword;
	
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
}
