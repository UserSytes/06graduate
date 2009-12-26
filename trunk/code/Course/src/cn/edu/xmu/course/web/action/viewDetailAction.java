package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Achievement;
import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseInfo;
import cn.edu.xmu.course.pojo.TeacherTeam;
import cn.edu.xmu.course.service.IAchievementService;
import cn.edu.xmu.course.service.IApplicationFormService;
import cn.edu.xmu.course.service.ICourseInfoService;
import cn.edu.xmu.course.service.ITeacherTeamService;

public class viewDetailAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationForm applicationForm;
	private CourseInfo courseInfo;
	private Course course;
	private Achievement achievement;
	private List<TeacherTeam> teacherTeamList;
	private int courseId;
	private IApplicationFormService applicationFormService;
	private ICourseInfoService courseInfoService;
	private ITeacherTeamService teacherTeamService;
	private IAchievementService achievementService;
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
		if (getApplicationForm() == null) {
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
	/**
	 * 查找师资队伍
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findTeacherTeam(){
		teacherTeamList=teacherTeamService.getTeacherTeam(courseId);
		if (getTeacherTeamList() == null) {
			return ERROR;
		} else
			return "teachers";
	}
	/**
	 * 查找成果展示
	 * @return
	 */
	public String findAchievement(){
		achievement=achievementService.getAchievement(courseId);
		if (getAchievement() == null) {
			return ERROR;
		} else
			return "achievement";
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

	public void setTeacherTeamService(ITeacherTeamService teacherTeamService) {
		this.teacherTeamService = teacherTeamService;
	}

	public ITeacherTeamService getTeacherTeamService() {
		return teacherTeamService;
	}

	public void setTeacherTeamList(List<TeacherTeam> teacherTeamList) {
		this.teacherTeamList = teacherTeamList;
	}

	public List<TeacherTeam> getTeacherTeamList() {
		return teacherTeamList;
	}

	public void setAchievementService(IAchievementService achievementService) {
		this.achievementService = achievementService;
	}

	public IAchievementService getAchievementService() {
		return achievementService;
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Achievement getAchievement() {
		return achievement;
	}

}
