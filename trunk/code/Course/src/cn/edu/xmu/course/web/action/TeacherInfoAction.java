package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.pojo.*;
import cn.edu.xmu.course.service.ISuperAdminService;
import cn.edu.xmu.course.service.ITeacherInfoService;
/**
 * 
 * @author Sky
 *
 */
public class TeacherInfoAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ITeacherInfoService teacherInfoService;
	private ISuperAdminService superAdminService;
	
	private Teacher teacher;
	private UserInfo userInfo;
	private String password;
	private String newPassword;
	
	private List<Teacher> teacherList;
	private List<Department> departmentList;
	private int teacherId;
	private int departmentId;
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	
	public String changePassword(){
		teacher = super.getTeacher();
		if(teacher.getPassword().equals(password)){
			teacher.setPassword(newPassword);
			if(teacherInfoService.changePassword(teacher)){
				teacher = teacherInfoService.findTeacherById(super.getTeacher().getId());
				super.getSession().put(TEACHER, teacher);
				return SUCCESS;
			}
			else
				return "fail";
		}
		else
			return ERROR;
	}
	
	public String changeTeacherInfo(){
		if(teacherInfoService.updateTeacher(teacher, userInfo)){
			teacher = teacherInfoService.findTeacherById(super.getTeacher().getId());
			super.getSession().put(TEACHER, teacher);
			addActionMessage("�޸ĸ�����Ϣ�ɹ���");
			return SUCCESS;
		}
		else
			return ERROR;
	}
	
	public String changePhoto() {
		int pos = uploadFileName.lastIndexOf(".");
		String fileLink = "photo/" + new Date().getTime()+uploadFileName.substring(pos);		
		if (teacherInfoService.addTeacherPhoto(super.getTeacher().getUserInfo(), upload, fileLink)) {
			userInfo = super.getTeacher().getUserInfo();		
			return SUCCESS;
		} else {
			addActionError("�ϴ�ͷ��ʧ�ܣ��������ϴ���");
			return ERROR;
		}
	}
	
	public String getTeacherInfo(){
		teacher = super.getTeacher();
		userInfo = teacher.getUserInfo();
		System.out.println(userInfo.getPhoto());
		return SUCCESS;
	}
	
	/**
	 * ����ѧԺ�������н�ʦ
	 * @return
	 */
	public String findTeacherBySchool(){
		Administrator admin = (Administrator) super.getSession().get(ADMIN);
		School school = admin.getSchool();
		teacherList = teacherInfoService.findTeachersBySchool(school);
		if (teacherList.size() == 0) {
			addActionMessage("��ѧԺ��û��ӽ�ʦ��");
			return ERROR;
		} else
			return SUCCESS;
	}
	
	/**
	 * ��ȡĳѧԺ������ϵ
	 * @return
	 */
	public String getDepartmentBySchool(){
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
	 * ��ӽ�ʦ
	 * @return
	 */
	public String addTeacher(){
		boolean result = false;
		Department department = superAdminService.findDepartmentById(departmentId);
		teacher.setPassword(teacher.getTeacherNo());
		userInfo.setDepartment(department);
		teacher.setUserInfo(userInfo);
		result = teacherInfoService.addTeacher(teacher, userInfo);
		if (result) {
			addActionMessage("��ӽ�ʦ�ɹ���");
			return SUCCESS;
		} else
			return ERROR;
	}
	
	/**
	 * ɾ����ʦ
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
	 * ��ת���޸Ľ�ʦ��Ϣ
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
	 * �޸Ľ�ʦ��Ϣ
	 * @return
	 */
	public String editTeacher(){
		boolean result = teacherInfoService.updateTeacher(teacher, userInfo);
		if(result){
			addActionMessage("�޸Ľ�ʦ��Ϣ�ɹ���");
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
