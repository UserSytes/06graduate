package cn.edu.xmu.course.web.action;

import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseInfo;
import cn.edu.xmu.course.service.IApplicationFormService;
import cn.edu.xmu.course.service.ICourseInfoService;

public class CourseInfoAction extends BaseAction{

	private CourseInfo courseInfo;
	private ApplicationForm applicationForm;
	private String test;
	
	
	private ICourseInfoService courseInfoService;
	private IApplicationFormService applicationFormService;
	
	public String addNewCourseInfo(){
		System.out.println(courseInfo.getContent());
		test = courseInfo.getContent();
		return SUCCESS;
	}
	

	/**
	 * 获取当前课程
	 * 
	 * @return
	 */
	public String getCurrentCourse() {
		Course course = super.getCourse();
		if(null==applicationFormService.getApplicationForm(course.getId())){
			applicationForm = new ApplicationForm();
			applicationForm.setLevel("国家级");
		}
			applicationForm=applicationFormService.getApplicationForm(course.getId());

		return null;
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

	public void setTest(String test) {
		this.test = test;
	}

	public String getTest() {
		return test;
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
}
