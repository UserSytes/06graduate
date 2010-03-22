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
	 * 查找申请表格
	 * @return
	 */
	public String findApplicationForm(){
		Course course=super.getCourse();
		applicationForm=applicationFormService.getApplicationForm(course.getId());
		if (getApplicationForm() == null) {
			addActionError("申报表格信息不存在！");
			return ERROR;
		} else
			return "applicationForm";
	}
	/**
	 * 添加新的申报表格
	 * 
	 * @return
	 */
	public String addApplicationForm() {
		if (getUpload() != null) {
			if (getUpload().length() >= new Long(10485760L)) {
				addActionError("上传课件大小不能超过10M,请重新上传！");
				return ERROR;
			}
			applicationForm.setFileLink(this.refactorFileLink());
			applicationForm.setFilename(getUploadFileName());
		}
		if (applicationForm.getId() == null)
			return addNewApplicationForm();
		else
			return updateApplicationForm();
	}
	/**
	 * 对上传文件进行重命名
	 * 
	 * @return
	 */
	private String refactorFileLink() {
		Teacher teacher = super.getTeacher();
		String fileLink = teacher.getUserInfo().getName() + "/"
				+ super.getCourse().getName() + "_" + "申报表格_" + uploadFileName;
		return fileLink;
	}
	/**
	 * 添加申报表格
	 * 
	 * @param file
	 * @return
	 */
	public String addNewApplicationForm() {
		Course course = super.getCourse();
		try {
			if (applicationFormService.addApplicationForm(applicationForm,
					course, getUpload())) {
				addActionMessage("添加课程申报表格成功！!");
				return SUCCESS;
			} else {
				addActionError("添加课程申报表格失败，请重新操作！");
				return ERROR;
			}
		} catch (Exception e) {
			addActionError("操作错误，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 更新申报表格
	 * 
	 * @param file
	 * @return
	 */
	public String updateApplicationForm() {
		try {
			if (applicationFormService.updateApplicationForm(applicationForm,
					getUpload())) {
				addActionMessage("更改课程申报表格成功!");
				return SUCCESS;
			} else {
				addActionError("更改课程申报表格失败，请重新操作！");
				return ERROR;
			}
		} catch (Exception e) {
			addActionError("操作错误，请重新操作！");
			return ERROR;
		}
	}

	public void setApplicationFormService(IApplicationFormService applicationFormService) {
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
