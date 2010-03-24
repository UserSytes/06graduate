package cn.edu.xmu.course.web.action;

import java.io.File;

import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.IApplicationFormService;

public class ApplicationFormAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int courseId;
	private Integer sort = 1;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private ApplicationForm applicationForm;
	private IApplicationFormService applicationFormService;

	/**
	 * ��ȡ��ǰ�γ̣��״ε���γ�ʱ���صķ���
	 * 
	 * @return
	 */
	public String getCurrentCourse() {
		Course course = super.getCourse();
		if (null == applicationFormService.getApplicationForm(course.getId())) {
			applicationForm = new ApplicationForm();
		} else {

			applicationForm = applicationFormService.getApplicationForm(course
					.getId());
		}
		return SUCCESS;
	}

	/**
	 * �����������
	 * 
	 * @return
	 */
	public String findApplicationForm() {
		Course course = super.getCourse();
		applicationForm = applicationFormService.getApplicationForm(course
				.getId());
		if (getApplicationForm() == null) {
			addActionError("�걨������Ϣ�����ڣ�");
			return ERROR;
		} else
			return "applicationForm";
	}

	/**
	 * ���ϴ��ļ�����������
	 * 
	 * @return
	 */
	private String refactorFileLink() {
		Teacher teacher = super.getTeacher();
		String fileLink = teacher.getUserInfo().getName() + "/"
				+ super.getCourse().getName() + "_" + "�걨����_" + uploadFileName;
		return fileLink;
	}

	/**
	 * �����µ��걨����
	 * 
	 * @return
	 */
	public String addApplicationForm() {
		applicationForm.setFileLink(this.refactorFileLink());
		applicationForm.setFilename(uploadFileName);
		if (applicationForm.getId() == null)
			return addNewApplicationForm();
		else
			return updateApplicationForm();
	}

	/**
	 * �����걨����
	 * 
	 * @param file
	 * @return
	 */
	public String addNewApplicationForm() {
		Course course = super.getCourse();
		try {
			if (applicationFormService.addApplicationForm(applicationForm,
					course, upload)) {
				addActionMessage("���ӿγ��걨����ɹ���!");
				return SUCCESS;
			} else {
				addActionError("���ӿγ��걨����ʧ�ܣ������²�����");
				return ERROR;
			}
		} catch (Exception e) {
			addActionError("�������������²�����");
			return ERROR;
		}
	}

	/**
	 * �����걨����
	 * 
	 * @param file
	 * @return
	 */
	public String updateApplicationForm() {
		try {
			if (applicationFormService.updateApplicationForm(applicationForm,
					upload)) {
				addActionMessage("���Ŀγ��걨����ɹ�!");
				return SUCCESS;
			} else {
				addActionError("���Ŀγ��걨����ʧ�ܣ������²�����");
				return ERROR;
			}
		} catch (Exception e) {
			addActionError("�������������²�����");
			return ERROR;
		}
	}

	public void setApplicationFormService(
			IApplicationFormService applicationFormService) {
		this.applicationFormService = applicationFormService;
	}

	public IApplicationFormService getApplicationFormService() {
		return applicationFormService;
	}

	public void setApplicationForm(ApplicationForm applicationForm) {
		this.applicationForm = applicationForm;
	}

	public ApplicationForm getApplicationForm() {
		return applicationForm;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return sort;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public File getUpload() {
		return upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}
}