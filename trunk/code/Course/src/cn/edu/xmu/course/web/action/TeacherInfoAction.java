package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.commons.MD5;
import cn.edu.xmu.course.pojo.*;
import cn.edu.xmu.course.service.ISuperAdminService;
import cn.edu.xmu.course.service.ITeacherInfoService;
/**
 * 负责管理教师信息的类
 * @author 郑冰凌
 * @author 何申密
 *
 */
public class TeacherInfoAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ITeacherInfoService teacherInfoService;	//管理教师信息的接口
	private ISuperAdminService superAdminService;	//管理校方管理员的接口
	
	private Teacher teacher;	//教师
	private UserInfo userInfo;	//用户信息
	private String password;	//密码
	private String newPassword;	//新密码
	
	private List<Teacher> teacherList;	//教师列表
	private List<Department> departmentList;	//系列表
	private int teacherId;	//教师id
	private int departmentId;	//系id
	
	private File upload;	//教师头像文件
	private String uploadContentType;	//教师头像文件类型
	private String uploadFileName;	//头像文件名称
	
	/**
	 * 修改密码
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String changePassword(){
		teacher = super.getTeacher();
		MD5 md5 = new MD5();
		if(teacher.getPassword().equals(md5.getMD5ofStr(password))){
			teacher.setPassword(md5.getMD5ofStr(newPassword));
			if(teacherInfoService.updatePassword(teacher)){
				teacher = teacherInfoService.findTeacherById(super.getTeacher().getId());
				super.getSession().put(TEACHER, teacher);
				addActionMessage("修改密码成功！");
				return SUCCESS;
			}
			else{
				addActionError("修改密码失败！");
				return SUCCESS;
			}
		}
		else{
			addActionError("原密码错误！");
			return SUCCESS;
		}
	}
	
	/**
	 * 还原初始密码
	 * @return
	 */
	public String restorePassword(){
		teacher = teacherInfoService.findTeacherById(teacherId);
		teacher.setPassword(new MD5().getMD5ofStr(teacher.getTeacherNo()));
		if(teacherInfoService.updatePassword(teacher)){
			addActionMessage("还原密码成功！");
			return SUCCESS;
		}
		else
			return ERROR;
	}
	/**
	 * 修改教师信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String changeTeacherInfo(){
		if(teacherInfoService.updateTeacher(teacher, userInfo)){
			teacher = teacherInfoService.findTeacherById(super.getTeacher().getId());
			super.getSession().put(TEACHER, teacher);
			addActionMessage("修改个人信息成功！");
			return SUCCESS;
		}
		else
			return ERROR;
	}
	
	/**
	 * 修改头像
	 * @return
	 */
	public String changePhoto() {
		int pos = uploadFileName.lastIndexOf(".");
		String fileLink = "photo/" + new Date().getTime()+uploadFileName.substring(pos);		
		if (teacherInfoService.addTeacherPhoto(super.getTeacher().getUserInfo(), upload, fileLink)) {
			userInfo = super.getTeacher().getUserInfo();		
			return SUCCESS;
		} else {
			addActionError("上传头像失败，请重新上传！");
			return ERROR;
		}
	}
	
	/**
	 * 获取教师信息
	 * @return
	 */
	public String getTeacherInfo(){
		teacher = super.getTeacher();
		userInfo = teacher.getUserInfo();		
		return SUCCESS;
	}
	
	/**
	 * 跳转到修改密码
	 * @return
	 */
	public String goChangePwd(){
		return SUCCESS;
	}
	
	/**
	 * 根据学院查找所有教师
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findTeacherBySchool(){
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		School school = admin.getSchool();
		teacherList = teacherInfoService.findTeachersBySchool(school);
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
	@SuppressWarnings("unchecked")
	public String getDepartmentBySchool(){
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
	 * 添加教师
	 * @return
	 */
	public String addTeacher(){
		boolean result = false;
		Department department = superAdminService.findDepartmentById(departmentId);
		teacher.setPassword(teacher.getTeacherNo());
		userInfo.setDepartment(department);
		String photo = "photo/defaultPhoto.jpg";
		userInfo.setPhoto(photo);
		teacher.setUserInfo(userInfo);
		result = teacherInfoService.addTeacher(teacher, userInfo);
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
		this.getDepartmentBySchool();
		teacher = teacherInfoService.findTeacherById(teacherId);
		userInfo = teacher.getUserInfo();
		if(null == teacher){
			return ERROR;
		}
		else
			return SUCCESS;
	}
	
	/**
	 * 修改教师信息
	 * @return
	 */
	public String editTeacher(){
		boolean result = teacherInfoService.updateTeacher(teacher, userInfo);
		if(result){
			addActionMessage("修改教师信息成功！");
			return SUCCESS;
		}else
			return ERROR;
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


	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public ISuperAdminService getSuperAdminService() {
		return superAdminService;
	}

	public void setSuperAdminService(ISuperAdminService superAdminService) {
		this.superAdminService = superAdminService;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public File getUpload() {
		return upload;
	}
	
}
