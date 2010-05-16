package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;

import cn.edu.xmu.course.commons.MD5;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IStudentInfoService;

/**
 * �������ѧ����ҳ����
 * 
 * @author ֣����
 * 
 */
public class StudentInfoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6085308815177983503L;
	private IStudentInfoService studentInfoService; // ����ѧ����Ϣ�Ľӿ�

	private Student student; // ѧ��
	private UserInfo userInfo; // �û���Ϣ
	private String oldPassword; // ԭ����
	private String newPassword; // ������

	private File upload; // ͷ���ļ�
	private String uploadContentType; // ͷ���ļ�����
	private String uploadFileName; // ͷ���ļ�����
	private String photoPath; // ͷ��·��

	/**
	 * �޸�ͷ��
	 * 
	 * @return
	 */
	public String changeHead() {
		student = (Student) super.getSession().get(STUDENT);
		String oldPhoto = student.getUserInfo().getPhoto();
		int pos = uploadFileName.lastIndexOf(".");
		String fileLink = "photo/" + new Date().getTime()
				+ uploadFileName.substring(pos);
		student.getUserInfo().setPhoto(fileLink);
		if (studentInfoService.addStudentPhoto(student.getUserInfo(), upload,
				oldPhoto)) {
			userInfo = student.getUserInfo();
			return SUCCESS;
		} else {
			addActionError("�ϴ�ͷ��ʧ�ܣ��������ϴ���");
			return ERROR;
		}
	}

	/**
	 * ����ѧ��������Ϣ
	 * 
	 * @return
	 */
	public String findStudentInfo() {
		student = null;
		student = (Student) super.getSession().get(STUDENT);
		student = studentInfoService.findById(student.getId());
		if (student == null) {
			addActionError("����δ��¼�����ȵ�¼��");
			return ERROR;
		} else {
			userInfo = student.getUserInfo();
			return SUCCESS;
		}
	}

	/**
	 * �޸�ѧ����Ϣ
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String changeStudentInfo() {
		boolean result = studentInfoService.updateStudent(student, userInfo);
		if (result) {
			student = studentInfoService.findById(student.getId());
			userInfo = student.getUserInfo();
			super.getSession().put(STUDENT, student);
			super.getSession().put(USERINFO, userInfo);
			super.getSession().put("user", userInfo.getName() + "ͬѧ");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * �޸�����
	 * 
	 * @return
	 */
	public String changePassword() {
		student = (Student) super.getSession().get(STUDENT);
		MD5 md5 = new MD5();
		if (student.getPassword().equals(md5.getMD5ofStr(oldPassword))) {
			student.setPassword(md5.getMD5ofStr(newPassword));
			boolean result = studentInfoService.updatePassword(student);
			if (result) {
				addActionMessage("�޸�����ɹ���");
				return SUCCESS;
			} else {
				addActionMessage("�޸�����ʧ�ܣ�");
				return SUCCESS;
			}
		} else {
			addActionError("ԭ�������");
			return SUCCESS;
		}
	}

	public IStudentInfoService getStudentInfoService() {
		return studentInfoService;
	}

	public void setStudentInfoService(IStudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getPhotoPath() {
		return photoPath;
	}

}
