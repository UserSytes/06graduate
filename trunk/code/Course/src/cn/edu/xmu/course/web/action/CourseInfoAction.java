package cn.edu.xmu.course.web.action;

import cn.edu.xmu.course.pojo.CourseInfo;
import cn.edu.xmu.course.service.ICourseInfoService;

public class CourseInfoAction extends BaseAction{

	private CourseInfo courseInfo;
	private String test;
	
	
	private ICourseInfoService courseInfoService;
	
	public String addNewCourseInfo(){
		System.out.println(courseInfo.getContent());
		test = courseInfo.getContent();
		return SUCCESS;
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
}
