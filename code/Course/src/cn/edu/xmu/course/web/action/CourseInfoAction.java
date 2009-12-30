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
	 * 添加课程信息
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
				addActionError("添加课程信息失败，请重新添加");
				return ERROR;
			}

		} else {
			if (courseInfoService.updateCourseInfo(courseInfo))
				return SUCCESS;
			else
				addActionError("更新课程信息失败，请重新确认");
			return ERROR;

		}
	}

	/**
	 * 删除课程信息
	 * 
	 * @return
	 */
	public String deleteCourseInfo() {
		CourseInfo delCourseInfo = courseInfoService
				.getCourseInfoById(courseInfoId);
		if (courseInfoService.deleteCourseInfo(delCourseInfo))
			return SUCCESS;
		else {
			addActionError("删除课程信息失败，请重新操作！");
			return ERROR;
		}

	}

	/**
	 * 编辑课程信息
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
	 * 获取当前课程，首次点击课程时加载的方法
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
	 * 获取当前课程信息
	 * 
	 * @return
	 */
	public String findCourseInfo() {
		Course currentCourse = super.getCourse();
		courseInfo = courseInfoService.getCourseInfo(currentCourse.getId(),
				sort);
		if (null == courseInfo) {
			courseInfo = new CourseInfo();
			courseInfo.setContent("暂无任何内容！");
		}
		return SUCCESS;
	}

	/**
	 * 对上传文件进行重命名
	 * 
	 * @return
	 */
	private String refactorFileLink() {
		Teacher teacher = super.getTeacher();
		String fileLink = teacher.getUserInfo().getName() + "/"
				+ super.getCourse().getName() + "_" +"申报表格_"+ uploadFileName;
		return fileLink;
	}

	/**
	 * 添加新的申报表格
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
	 * 添加申报表格
	 * 
	 * @param file
	 * @return
	 */
	public String addNewApplicationForm(File file) {
		Course course = super.getCourse();
		try {
			if (applicationFormService.addApplicationForm(applicationForm,
					course, upload)) {
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
	public String updateApplicationForm(File file) {
		try {
			if (applicationFormService.updateApplicationForm(applicationForm,
					upload)) {
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
