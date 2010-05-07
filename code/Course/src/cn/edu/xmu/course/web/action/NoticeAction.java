package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.INoticeService;
/**
 * 负责通知公告的类
 * @author 何申密
 * @author 许子彦
 *
 */
public class NoticeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7104728441652536429L;

	private INoticeService noticeService; // 负责通知公告的接口
	private ICourseService courseService; // 负责课程的接口
	private Integer sort; // 通知公告类型
	private Notice notice; // 通知公告
	private Course course; // 课程
	private Integer courseId; // 课程ID
	private Teacher teacher; // 教师
	private Integer noticeId; // 通知公告ID
	private List<Notice> noticeList; // 通知公告列表
	private List<Course> courseList; // 课程列表

	/**
	 * 添加新的课程通知
	 * 
	 * @return
	 */
	public String addNewNotice() {
		course = courseService.getCourseById(courseId);
		if (noticeService.addNotice(notice, course)) {
			addActionMessage("添加课程通知成功！");
			return SUCCESS;
		} else {
			addActionError("添加课程通知失败，请重新添加！");
			return ERROR;
		}
	}

	/**
	 * 删除课程通知
	 * 
	 * @return
	 */
	public String deleteNotice() {
		notice = noticeService.getNoticeById(noticeId);
		if (noticeService.deleteNotice(notice)) {
			addActionMessage("删除课程通知成功！");
			return SUCCESS;
		} else {
			addActionError("删除课程通知失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 根据课程查找课程通知
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getNoticeListByCourse() {
		courseList = courseService.findCoursesByTeacher(super.getTeacher()
				.getId(), 1);
		if (courseId != -1) {
			course = courseService.getCourseById(courseId);
			noticeList = noticeService.getNoticeListByCourse(course);
		} else
			noticeList = noticeService.getNoticeListByTeacher(super
					.getTeacher());
		return SUCCESS;
	}

	/**
	 * 根据教师查找课程通知
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getNoticeListByTeacher() {
		courseList = courseService.findCoursesByTeacher(super.getTeacher()
				.getId(), 1);
		noticeList = noticeService.getNoticeListByTeacher(super.getTeacher());
		return SUCCESS;

	}

	/**
	 * 根据类别查找课程通知
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getNoticeBySort2() {
		course = super.getCourse();
		noticeList = getNoticeService().getNoticeBySort(course, sort);
		// noticeList = noticeService.getNoticeBySort(course, getSort());
		setSort(getSort());
		return SUCCESS;
	}

	public String findNoticeById() {
		course = super.getCourse();
		notice = noticeService.getNoticeById(noticeId);
		if (getNotice() == null) {
			addActionError("新闻或通告已不存在！");
			return ERROR;
		} else
			return SUCCESS;

	}

	public String findLastestNotice() {
		course = super.getCourse();
		notice = noticeService.findLastestNotice(course);
		return SUCCESS;
	}

	/**
	 * 更新课程通知
	 * 
	 * @return
	 */
	public String updateNotice() {
		course = courseService.getCourseById(courseId);
		if (noticeService.updateNotice(notice, course)) {
			addActionMessage("更新课程通知成功！");
			return SUCCESS;
		} else {
			addActionError("更新课程通知失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 跳到添加课程通知
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String goAddNotice() {
		courseList = courseService.findCoursesByTeacher(super.getTeacher()
				.getId(), 1);
		return SUCCESS;
	}

	/**
	 * 跳到更新课程通知
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String goEditNotice() {
		courseList = courseService.findCoursesByTeacher(super.getTeacher()
				.getId(), 1);
		notice = noticeService.getNoticeById(noticeId);
		courseId = notice.getCourse().getId();
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return sort;
	}

}
