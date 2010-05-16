package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.commons.MD5;
import cn.edu.xmu.course.pojo.*;
import cn.edu.xmu.course.service.ISuperAdminService;
import cn.edu.xmu.course.service.ITeacherInfoService;
/**
 * ��������ʦ��Ϣ����
 * @author ֣����
 * @author ������
 *
 */
public class TeacherInfoAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ITeacherInfoService teacherInfoService;	//�����ʦ��Ϣ�Ľӿ�
	private ISuperAdminService superAdminService;	//����У������Ա�Ľӿ�
	
	private Teacher teacher;	//��ʦ
	private UserInfo userInfo;	//�û���Ϣ
	private String password;	//����
	private String newPassword;	//������
	
	private List<Teacher> teacherList;	//��ʦ�б�
	private List<Department> departmentList;	//ϵ�б�
	private int teacherId;	//��ʦid
	private int departmentId;	//ϵid
	
	private File upload;	//��ʦͷ���ļ�
	private String uploadContentType;	//��ʦͷ���ļ�����
	private String uploadFileName;	//ͷ���ļ�����
	
	/**
	 * �޸�����
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
				addActionMessage("�޸�����ɹ���");
				return SUCCESS;
			}
			else{
				addActionError("�޸�����ʧ�ܣ�");
				return SUCCESS;
			}
		}
		else{
			addActionError("ԭ�������");
			return SUCCESS;
		}
	}
	
	/**
	 * ��ԭ��ʼ����
	 * @return
	 */
	public String restorePassword(){
		teacher = teacherInfoService.findTeacherById(teacherId);
		teacher.setPassword(new MD5().getMD5ofStr(teacher.getTeacherNo()));
		if(teacherInfoService.updatePassword(teacher)){
			addActionMessage("��ԭ����ɹ���");
			return SUCCESS;
		}
		else
			return ERROR;
	}
	/**
	 * �޸Ľ�ʦ��Ϣ
	 * @return
	 */
	@SuppressWarnings("unchecked")
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
	
	/**
	 * �޸�ͷ��
	 * @return
	 */
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
	
	/**
	 * ��ȡ��ʦ��Ϣ
	 * @return
	 */
	public String getTeacherInfo(){
		teacher = super.getTeacher();
		userInfo = teacher.getUserInfo();		
		return SUCCESS;
	}
	
	/**
	 * ��ת���޸�����
	 * @return
	 */
	public String goChangePwd(){
		return SUCCESS;
	}
	
	/**
	 * ����ѧԺ�������н�ʦ
	 * @return
	 */
	@SuppressWarnings("unchecked")
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
	@SuppressWarnings("unchecked")
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
		String photo = "photo/defaultPhoto.jpg";
		userInfo.setPhoto(photo);
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
