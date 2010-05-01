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

	/**
	 * 添加课程信息
	 * 
	 * @return
	 */
	public String addNewCourseInfo() {
		Course currentCourse = super.getCourse();
		courseInfo.setSort(1);
		if (null == courseInfo.getId()) {
			if (courseInfoService.addCoureseInfo(courseInfo, currentCourse)){
				addActionError("添加课程简介成功！");
				return SUCCESS;
			}				
			else {
				addActionError("添加课程简介失败，请重新添加！");
				return ERROR;
			}

		} else {
			if (courseInfoService.updateCourseInfo(courseInfo)){
				addActionError("更新课程简介成功！");
				return SUCCESS;
			}				
			else
				addActionError("更新课程简介失败，请重新操作！");
			return ERROR;

		}
	}
	
	public String addNewCourseOutline() {
		Course currentCourse = super.getCourse();
		courseInfo.setSort(2);
		if (null == courseInfo.getId()) {
			if (courseInfoService.addCoureseInfo(courseInfo, currentCourse)){
				addActionError("添加教学大纲成功！");
				return SUCCESS;
			}
			else {
				addActionError("添加教学大纲失败，请重新添加！");
				return ERROR;
			}

		} else {
			if (courseInfoService.updateCourseInfo(courseInfo)){
				addActionError("更新教学大纲成功！");
				return SUCCESS;
			}
			else
				addActionError("更新教学大纲失败，请重新操作！");
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
	 * 获取当前课程信息
	 * 
	 * @return
	 */
	public String findCourseInfo() {
		Course currentCourse = super.getCourse();
		courseInfo = courseInfoService.getCourseInfo(currentCourse.getId(),
				1);
		if (null == courseInfo) {
			courseInfo = new CourseInfo();
			courseInfo.setContent("暂无任何内容！");
		}
		return SUCCESS;
	}
	
	public String findCourseOutline() {
		Course currentCourse = super.getCourse();
		courseInfo = courseInfoService.getCourseInfo(currentCourse.getId(),
				2);
		if (null == courseInfo) {
			courseInfo = new CourseInfo();
			courseInfo.setContent("暂无任何内容！");
		}
		return SUCCESS;
	}
	
	/**
	 * 课程页面获取当前课程信息
	 * 
	 * @return
	 */
	public String findCourseInfo2() {
		Course currentCourse = super.getCourse();
		courseInfo = courseInfoService.getCourseInfo(currentCourse.getId(),
				sort);
		if (null == courseInfo) {
			courseInfo = new CourseInfo();
			courseInfo.setContent("暂无任何内容！");
		}
		if(sort==1)
			return "courseinfo1";
		else
			return "courseinfo2";
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
