package cn.edu.xmu.course.web.action;

import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseInfo;
import cn.edu.xmu.course.service.IApplicationFormService;
import cn.edu.xmu.course.service.ICourseInfoService;

public class viewDetailAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationForm applicationForm;
	private CourseInfo courseInfo;
	private Course course;
	private int courseId;
	private IApplicationFormService applicationFormService;
	private ICourseInfoService courseInfoService;
	public ApplicationForm getApplicationForm() {
		return applicationForm;
	}

	public void setApplicationForm(ApplicationForm applicationForm) {
		this.applicationForm = applicationForm;
	}

	

	public IApplicationFormService getApplicationFormService() {
		return applicationFormService;
	}

	public void setApplicationFormService(
			IApplicationFormService applicationFormService) {
		this.applicationFormService = applicationFormService;
	}
	/**
	 * 查找申请表格
	 * @return
	 */
	public String findApplicationForm(){
		applicationForm=applicationFormService.getApplicationForm(courseId);
		if (applicationForm == null) {
			return ERROR;
		} else
			return "applicationForm";
	}
	/**
	 * 查找课程简介
	 * @return
	 */
	public String findCourseInfo(){
		courseInfo=courseInfoService.getCourseInfo(courseId, 1);
		System.out.println("\naction"+courseInfo.getTitle());
		if (getCourseInfo() == null) {
			return ERROR;
		} else
			return "courseInfo";
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourseInfoService(ICourseInfoService courseInfoService) {
		this.courseInfoService = courseInfoService;
	}

	public ICourseInfoService getCourseInfoService() {
		return courseInfoService;
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}

	public CourseInfo getCourseInfo() {
		return courseInfo;
	}

}
