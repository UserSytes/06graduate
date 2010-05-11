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
/**
 * 负责进入课程初始化的类
 * @author 何申密
 * @author 许子彦
 *
 */
public class EnterCourseAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7104728441652536429L;

	private INoticeService noticeService; // 负责通知公告的接口
	private ICourseService courseService; // 负责课程的接口
	private ICourseInfoService courseInfoService; // 负责课程信息的接口
	private ITeacherInfoService teacherInfoService; // 负责教师信息的接口
	private IAchievementService achievementService; // 负责教学成果的接口
	private UserInfo userInfo; // 用户信息
	private Integer sort; // 导航栏类型
	private Notice notice; // 通知公告
	private CourseInfo courseInfo; // 课程信息
	private Course course; // 课程
	private Integer noticeId; // 通知公告ID
	private List<Notice> noticeList; // 通知列表
	private List<Notice> noticeList2; // 公告列表
	private Integer count; // 课程访问量
	private Teacher teacher; // 教师
	private List<Achievement> achievementList; // 教学成果列表
	private String color; // 颜色
	private String header; // 导航栏
	private String sortname; // 导航栏类型名称
	private String filtercon; // 导航栏图标
	private String result; // 导航栏设置结果

	/**
	 * 进入课程首页查询
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String goIndexQuery() {
		course = super.getCourse();
		setCourseInfo(courseInfoService.getCourseInfo(course.getId(), 1));
		setAchievementList(getAchievementService().findLastestSevenAchievements(course));
		if (null == getCourseInfo()) {
			setCourseInfo(new CourseInfo());
			getCourseInfo().setContent("暂无任何内容！");
		}
		setNoticeList(noticeService.findLastestSevenNotices(course, 0));
		return SUCCESS;
	}

	/**
	 * 查找左边栏公告
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getLeftNotice() {
		course = super.getCourse();
		setTeacher(course.getTeacher());
		setUserInfo(getTeacher().getUserInfo());
		setNoticeList2(noticeService.findLastestLeftNotices(course));
		setCount(course.getCount());
		return SUCCESS;
	}

	/**
	 * 更换风格
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String changeColor() {
		if (color.equals(super.getSession().get("style")))
			color = null;
		else
			super.getSession().put("style", color);
		return SUCCESS;
	}

	/**
	 * 更换导航栏
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String changeHeader() {
		super.getSession().put("header", header);
		course = super.getCourse();
		if (header.equals("header_sand.jsp")) {
			super.getSession().put("sort", "sorttype");
			super.getSession().put("filtercon", "allcon");
		}
		return SUCCESS;
	}

	/**
	 * 导航栏排列
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String sortSand() {
		if (sortname != null)
			super.getSession().put("sort", sortname);
		if (filtercon != null)
			super.getSession().put("filtercon", filtercon);
		result = "{sort:'" + super.getSession().get("sort") + "',filtercon:'"
				+ super.getSession().get("filtercon") + "'}";
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getFiltercon() {
		return filtercon;
	}

	public void setFiltercon(String filtercon) {
		this.filtercon = filtercon;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

}
