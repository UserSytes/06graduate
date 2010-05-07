package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseInfo;
import cn.edu.xmu.course.service.ICourseInfoService;
/**
 * 负责课程信息的类
 * @author 何申密
 * @author 许子彦
 *
 */
public class CourseInfoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8520468160026179099L;
	private CourseInfo courseInfo; // 课程信息
	private ApplicationForm applicationForm; // 申报表格
	private List<CourseInfo> courseInfoList; // 课程信息列表
	private Integer courseInfoId; // 课程信息ID
	private Integer sort = 1; // 课程信息类别

	private File upload; // 附件
	private String uploadContentType; // 文件类型
	private String uploadFileName; // 文件名称

	private ICourseInfoService courseInfoService; // 负责课程信息的接口

	/**
	 * 添加课程信息
	 * 
	 * @return
	 */
	public String addNewCourseInfo() {
		Course currentCourse = super.getCourse();
		courseInfo.setSort(1);
		if (null == courseInfo.getId()) {
			if (courseInfoService.addCoureseInfo(courseInfo, currentCourse)) {
				addActionError("添加课程简介成功！");
				return SUCCESS;
			} else {
				addActionError("添加课程简介失败，请重新添加！");
				return ERROR;
			}

		} else {
			if (courseInfoService.updateCourseInfo(courseInfo)) {
				addActionError("更新课程简介成功！");
				return SUCCESS;
			} else
				addActionError("更新课程简介失败，请重新操作！");
			return ERROR;

		}
	}

	/**
	 * 添加教学大纲
	 * 
	 * @return
	 */
	public String addNewCourseOutline() {
		Course currentCourse = super.getCourse();
		courseInfo.setSort(2);
		if (null == courseInfo.getId()) {
			if (courseInfoService.addCoureseInfo(courseInfo, currentCourse)) {
				addActionError("添加教学大纲成功！");
				return SUCCESS;
			} else {
				addActionError("添加教学大纲失败，请重新添加！");
				return ERROR;
			}

		} else {
			if (courseInfoService.updateCourseInfo(courseInfo)) {
				addActionError("更新教学大纲成功！");
				return SUCCESS;
			} else
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
		courseInfo = courseInfoService.getCourseInfo(currentCourse.getId(), 1);
		if (null == courseInfo) {
			courseInfo = new CourseInfo();
			courseInfo.setContent("暂无任何内容！");
		}
		return SUCCESS;
	}

	/**
	 * 查找教学大纲
	 * 
	 * @return
	 */
	public String findCourseOutline() {
		Course currentCourse = super.getCourse();
		courseInfo = courseInfoService.getCourseInfo(currentCourse.getId(), 2);
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
		if (sort == 1)
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
