package cn.edu.xmu.course.web.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseInfo;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.IApplicationFormService;
import cn.edu.xmu.course.service.ICourseInfoService;

public class CourseInfoAction extends BaseAction {

	private CourseInfo courseInfo;
	private ApplicationForm applicationForm;
	private List<CourseInfo> courseInfoList;
	private Integer courseInfoId;
	private Integer sort = 1;

	private File upload;
	private String uploadContentType;
	private String uploadFileName;

	private ICourseInfoService courseInfoService;
	private IApplicationFormService applicationFormService;

	/**
	 * ��ӿγ���Ϣ
	 * 
	 * @return
	 */
	public String addNewCourseInfo() {
		Course currentCourse = super.getCourse();
		courseInfo.setSort(sort);
		courseInfo.setTime(Calendar.getInstance().getTime());
		if (null == courseInfo.getId()) {
			if (courseInfoService.addCoureseInfo(courseInfo, currentCourse))
				return SUCCESS;
			else {
				addActionError("��ӿγ���Ϣʧ�ܣ����������");
				return ERROR;
			}

		} else {
			if (courseInfoService.updateCourseInfo(courseInfo))
				return SUCCESS;
			else
				addActionError("���¿γ���Ϣʧ�ܣ�������ȷ��");
			return ERROR;

		}
	}

	/**
	 * ɾ���γ���Ϣ
	 * 
	 * @return
	 */
	public String deleteCourseInfo() {
		CourseInfo delCourseInfo = courseInfoService
				.getCourseInfoById(courseInfoId);
		if (courseInfoService.deleteCourseInfo(delCourseInfo))
			return SUCCESS;
		else {
			addActionError("ɾ���γ���Ϣʧ�ܣ������²�����");
			return ERROR;
		}

	}

	/**
	 * �༭�γ���Ϣ
	 * 
	 * @return
	 */
	public String updateCourseInfo() {

		if (courseInfoId == null)
			courseInfo = new CourseInfo();
		else {
			courseInfo = courseInfoService.getCourseInfoById(courseInfoId);
		}
		return SUCCESS;
	}

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
	 * ��ȡ��ǰ�γ���Ϣ
	 * 
	 * @return
	 */
	public String findCourseInfo() {
		Course currentCourse = super.getCourse();
		courseInfo = courseInfoService.getCourseInfo(currentCourse.getId(),
				sort);
		if (null == courseInfo) {
			courseInfo = new CourseInfo();
			courseInfo.setContent("�����κ����ݣ�");
		}
		return SUCCESS;
	}

	/**
	 * ���ϴ��ļ�����������
	 * 
	 * @return
	 */
	private String refactorFileLink() {
		Teacher teacher = super.getTeacher();
		String fileLink = teacher.getUserInfo().getName() + "/"
				+ super.getCourse().getName() + "_" +"�걨���_"+ uploadFileName;
		return fileLink;
	}

	/**
	 * ����µ��걨���
	 * 
	 * @return
	 */
	public String addApplicationForm() {

		File file = null;
		if (upload != null) {
			applicationForm.setFileLink(this.refactorFileLink());
			applicationForm.setFilename(uploadFileName);
		}
		if (applicationForm.getId() == null)
			return addNewApplicationForm(file);
		else
			return updateApplicationForm(file);
	}

	/**
	 * ����걨���
	 * 
	 * @param file
	 * @return
	 */
	public String addNewApplicationForm(File file) {
		Course course = super.getCourse();
		try {
			if (applicationFormService.addApplicationForm(applicationForm,
					course, upload)) {
				addActionMessage("��ӿγ��걨���ɹ���!");
				return SUCCESS;
			} else {
				addActionError("��ӿγ��걨���ʧ�ܣ������²�����");
				return ERROR;
			}
		} catch (Exception e) {
			addActionError("�������������²�����");
			return ERROR;
		}
	}

	/**
	 * �����걨���
	 * 
	 * @param file
	 * @return
	 */
	public String updateApplicationForm(File file) {
		try {
			if (applicationFormService.updateApplicationForm(applicationForm,
					upload)) {
				addActionMessage("���Ŀγ��걨���ɹ�!");
				return SUCCESS;
			} else {
				addActionError("���Ŀγ��걨���ʧ�ܣ������²�����");
				return ERROR;
			}
		} catch (Exception e) {
			addActionError("�������������²�����");
			return ERROR;
		}
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}

	public CourseInfo getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfoService(ICourseInfoService courseInfoService) {
		this.courseInfoService = courseInfoService;
	}

	public ICourseInfoService getCourseInfoService() {
		return courseInfoService;
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

	public void setCourseInfoList(List<CourseInfo> courseInfoList) {
		this.courseInfoList = courseInfoList;
	}

	public List<CourseInfo> getCourseInfoList() {
		return courseInfoList;
	}

	public void setCourseInfoId(Integer courseInfoId) {
		this.courseInfoId = courseInfoId;
	}

	public Integer getCourseInfoId() {
		return courseInfoId;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return sort;
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

}
