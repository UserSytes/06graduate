package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Achievement;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseInfo;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IAchievementService;
import cn.edu.xmu.course.service.ICourseInfoService;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.INoticeService;
import cn.edu.xmu.course.service.ITeacherInfoService;

public class EnterCourseAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7104728441652536429L;

	private INoticeService noticeService;
	private ICourseService courseService;
	private ICourseInfoService courseInfoService;
	private ITeacherInfoService teacherInfoService;
	private IAchievementService achievementService;
	private UserInfo userInfo;
	private Integer sort;
	private Notice notice;
	private CourseInfo courseInfo;
	private Course course;
	private Integer noticeId;
	private List<Notice> noticeList;
	private List<Notice> noticeList2;
	private Integer count;
	private Teacher teacher;
	private List<Achievement> achievementList;
	
	public String goIndexQuery(){
		course=super.getCourse();
		setCourseInfo(courseInfoService.getCourseInfo(course.getId(),
				1));
		setAchievementList(getAchievementService().getAllAchievements(course));
		if (null == getCourseInfo()) {
			setCourseInfo(new CourseInfo());
			getCourseInfo().setContent("暂无任何内容！");
		}		
		setNoticeList(noticeService.findLastestFiveNews(course,0));	
		
		return SUCCESS;
	}
	
	public String getLeftNotice(){
		course=super.getCourse();
		setTeacher(course.getTeacher());
		setUserInfo(getTeacher().getUserInfo());
		setNoticeList2(noticeService.findLastestFiveNews(course,1));
		setCount(course.getCount());	
		System.out.println(noticeList2.size());
		return SUCCESS;
	}

	public void setNoticeService(INoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public INoticeService getNoticeService() {
		return noticeService;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public List<Notice> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return sort;
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

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}

	public void setNoticeList2(List<Notice> noticeList2) {
		this.noticeList2 = noticeList2;
	}

	public List<Notice> getNoticeList2() {
		return noticeList2;
	}

	public void setTeacherInfoService(ITeacherInfoService teacherInfoService) {
		this.teacherInfoService = teacherInfoService;
	}

	public ITeacherInfoService getTeacherInfoService() {
		return teacherInfoService;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setAchievementList(List<Achievement> achievementList) {
		this.achievementList = achievementList;
	}

	public List<Achievement> getAchievementList() {
		return achievementList;
	}

	public void setAchievementService(IAchievementService achievementService) {
		this.achievementService = achievementService;
	}

	public IAchievementService getAchievementService() {
		return achievementService;
	}

}
