package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.INoticeService;
/**
 * ����֪ͨ�������
 * @author ������
 * @author ������
 *
 */
public class NoticeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7104728441652536429L;

	private INoticeService noticeService; // ����֪ͨ����Ľӿ�
	private ICourseService courseService; // ����γ̵Ľӿ�
	private Integer sort; // ֪ͨ��������
	private Notice notice; // ֪ͨ����
	private Course course; // �γ�
	private Integer courseId; // �γ�ID
	private Teacher teacher; // ��ʦ
	private Integer noticeId; // ֪ͨ����ID
	private List<Notice> noticeList; // ֪ͨ�����б�
	private List<Course> courseList; // �γ��б�

	/**
	 * ����µĿγ�֪ͨ
	 * 
	 * @return
	 */
	public String addNewNotice() {
		course = courseService.getCourseById(courseId);
		if (noticeService.addNotice(notice, course)) {
			addActionMessage("��ӿγ�֪ͨ�ɹ���");
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
	 * ���ݽ�ʦ���ҿγ�֪ͨ
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
	 * ���������ҿγ�֪ͨ
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
			addActionError("���Ż�ͨ���Ѳ����ڣ�");
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
	 * ���¿γ�֪ͨ
	 * 
	 * @return
	 */
	public String updateNotice() {
		course = courseService.getCourseById(courseId);
		if (noticeService.updateNotice(notice, course)) {
			addActionMessage("���¿γ�֪ͨ�ɹ���");
			return SUCCESS;
		} else {
			addActionError("���¿γ�֪ͨʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ������ӿγ�֪ͨ
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
	 * �������¿γ�֪ͨ
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
