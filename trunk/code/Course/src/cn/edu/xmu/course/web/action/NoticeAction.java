package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.INoticeService;

public class NoticeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7104728441652536429L;

	private INoticeService noticeService;
	private ICourseService courseService;

	private Notice notice;
	private Course course;
	private Integer courseId;
	private Teacher teacher;
	private Integer noticeId;
	private List<Notice> noticeList;
	private List<Course> courseList;

	/**
	 * ����µĿγ�֪ͨ
	 * 
	 * @return
	 */
	public String addNewNotice() {
		course = courseService.getCourseById(courseId);
		if (noticeService.addNotice(notice, course)) {
			addActionMessage("��ӿγ̳ɹ���");
			return SUCCESS;
		} else {
			addActionError("��ӿγ�֪ͨʧ�ܣ���������ӣ�");
			return ERROR;
		}
	}

	/**
	 * ɾ���γ�֪ͨ
	 * 
	 * @return
	 */
	public String deleteNotice() {
		notice = noticeService.getNoticeById(noticeId);
		if (noticeService.deleteNotice(notice)) {
			addActionMessage("ɾ���γ�֪ͨ�ɹ���");
			return SUCCESS;
		} else {
			addActionError("ɾ���γ�֪ͨʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ���ݿγ̲��ҿγ�֪ͨ
	 * 
	 * @return
	 */
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
	 * ���ݽ�ʦ���ҿγ�֪ͨ
	 * 
	 * @return
	 */
	public String getNoticeListByTeacher() {
		courseList = courseService.findCoursesByTeacher(super.getTeacher()
				.getId(), 1);
		noticeList = noticeService.getNoticeListByTeacher(super.getTeacher());
		return SUCCESS;

	}

	/**
	 * ���¿γ�֪ͨ
	 * 
	 * @return
	 */
	public String updateNotice() {
		if (noticeService.updateNotice(notice)) {
			addActionMessage("���¿γ�֪ͨ�ɹ���");
			return SUCCESS;
		} else {
			addActionError("���¿γ�֪ͨʧ�ܣ������²�����");
			return ERROR;
		}
	}
	
	/**
	 * ������ӿγ�֪ͨ
	 * @return
	 */
	public String goAddNotice(){
		courseList = courseService.findCoursesByTeacher(super.getTeacher()
				.getId(), 1);
		return SUCCESS;
	}
	
	/**
	 * �������¿γ�֪ͨ
	 * @return
	 */
	public String goEditNotice(){
		courseList = courseService.findCoursesByTeacher(super.getTeacher()
				.getId(), 1);
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

}
