package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseInfo;
import cn.edu.xmu.course.service.IApplicationFormService;
import cn.edu.xmu.course.service.ICourseInfoService;

public class CourseInfoAction extends BaseAction {

	private CourseInfo courseInfo;
	private ApplicationForm applicationForm;
	private List<CourseInfo> courseInfoList;
	private Integer courseInfoId;
	private Integer sort = 1;

	private ICourseInfoService courseInfoService;
	private IApplicationFormService applicationFormService;

	/**
	 * 添加课程信息
	 * @return
	 */
	public String addNewCourseInfo() {
		Course currentCourse = super.getCourse();
		if (null == courseInfoService.getCourseInfo(currentCourse.getId(), courseInfo.getSort())) {
			if (courseInfoService.addCoureseInfo(courseInfo, currentCourse))
				return SUCCESS;
			else {
				addActionError("添加课程信息失败，请重新添加");
				return ERROR;
			}

		} else {
			if (courseInfo.getSort() == 1)
				addActionError("课程简介已经存在，无法添加，请对原有内容进行编辑！");
			else if (courseInfo.getSort() == 2)
				addActionError("教学大纲已经存在，无法添加，请对原有内容进行编辑！");
			return ERROR;

		}
	}
	
	/**
	 * 删除课程信息
	 * @return
	 */
	public String deleteCourseInfo(){
		if(courseInfoId == null){
			if(sort == 1)
				addActionError("课程简介暂无任何信息，无法删除！");
			else if(sort == 2)
				addActionError("教学大纲暂无任何信息，无法删除！");
			return ERROR;
		}

		else{
			CourseInfo delCourseInfo = courseInfoService.getCourseInfoById(courseInfoId);
			if(courseInfoService.deleteCourseInfo(delCourseInfo))
				return SUCCESS;
			else{
				addActionError("删除课程信息失败，请重新操作！");
				return ERROR;
			}
		}
	}
	
	/**
	 * 获取该课程详细信息
	 * @return
	 */
	public String getCourseInfoDetail(){
		courseInfo = courseInfoService.getCourseInfoById(courseInfoId);
		return SUCCESS;
	}

	/**
	 * 获取当前课程
	 * 
	 * @return
	 */
	public String getCurrentCourse() {
		Course course = super.getCourse();
		if (null == applicationFormService.getApplicationForm(course.getId())) {
			applicationForm = new ApplicationForm();
		} else
			applicationForm = applicationFormService.getApplicationForm(course
					.getId());
		System.out.println(applicationForm.getSort());
		return SUCCESS;
	}

	/**
	 * 获取当前课程信息
	 * 
	 * @return
	 */
	public String findCourseInfo() {
		Course currentCourse = super.getCourse();
		courseInfo=courseInfoService.getCourseInfo(currentCourse.getId(), sort);
		if (null == courseInfo) {
			courseInfo = new CourseInfo();
			courseInfo.setContent("暂无任何内容！");
		}
		return SUCCESS;
	}

	public String addApplicationForm() {
		Course course = super.getCourse();
		if (applicationForm.getId() == null) {
			if (applicationFormService.addApplicationForm(applicationForm,
					course)) {
				addActionMessage("添加课程申报表格成功!");
				return SUCCESS;
			} else
				return ERROR;
		} else {
			if (applicationFormService.updateApplicationForm(applicationForm)) {
				addActionMessage("更改课程申报表格成功!");
				return SUCCESS;
			} else
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
}
