package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Courseware;
import cn.edu.xmu.course.service.IChapterService;
import cn.edu.xmu.course.service.ICoursewareService;

public class CoursewareAction extends BaseAction {

	private List<Chapter> chapterList;
	private Chapter chapter;
	private Integer chapterId;

	private List<Courseware> coursewareList;
	private Courseware courseware;
	private Integer coursewareId;

	private IChapterService chapterService;
	private ICoursewareService coursewareService;

	public String getCoursewareByChapter() {
		Course course = super.getCourse();
		coursewareList = coursewareService.getAllCoursewares(course);
		return SUCCESS;
	}

	public String addCourseware() {
		chapter = chapterService.getChapterById(chapterId);
		if (coursewareService.addCourseware(courseware, chapter))
			return SUCCESS;
		else {
			addActionError("��ӿμ�ʧ�ܣ���������ӣ�");
			return ERROR;
		}
	}

	public String goEditCourseware() {
		courseware = coursewareService.getCoursewareById(coursewareId);
		return SUCCESS;
	}

	public String updateCourseware() {
		chapter = chapterService.getChapterById(chapterId);
		if (coursewareService.updateCourseware(courseware, chapter))
			return SUCCESS;
		else {
			addActionError("���¿μ�ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	public String deleteCourseware() {
		Courseware delCourseware = coursewareService
				.getCoursewareById(coursewareId);
		if (coursewareService.deleteCourseware(delCourseware))
			return SUCCESS;
		else {
			addActionError("ɾ���μ�ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	public List<Chapter> getChapterList() {
		return chapterList;
	}

	public void setChapterList(List<Chapter> chapterList) {
		this.chapterList = chapterList;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public Integer getChapterId() {
		return chapterId;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

	public List<Courseware> getCoursewareList() {
		return coursewareList;
	}

	public void setCoursewareList(List<Courseware> coursewareList) {
		this.coursewareList = coursewareList;
	}

	public Courseware getCourseware() {
		return courseware;
	}

	public void setCourseware(Courseware courseware) {
		this.courseware = courseware;
	}

	public IChapterService getChapterService() {
		return chapterService;
	}

	public void setChapterService(IChapterService chapterService) {
		this.chapterService = chapterService;
	}

	public ICoursewareService getCoursewareService() {
		return coursewareService;
	}

	public void setCoursewareService(ICoursewareService coursewareService) {
		this.coursewareService = coursewareService;
	}

	public void setCoursewareId(Integer coursewareId) {
		this.coursewareId = coursewareId;
	}

	public Integer getCoursewareId() {
		return coursewareId;
	}

}
