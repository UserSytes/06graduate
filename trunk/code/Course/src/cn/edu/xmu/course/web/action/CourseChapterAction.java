package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Courseware;
import cn.edu.xmu.course.pojo.Exercise;
import cn.edu.xmu.course.pojo.Experiment;
import cn.edu.xmu.course.service.IChapterService;
import cn.edu.xmu.course.service.ICoursewareService;
import cn.edu.xmu.course.service.IExerciseService;
import cn.edu.xmu.course.service.IExperimentService;
/**
 * ����γ��½ڵ���
 * @author ������
 *
 */
public class CourseChapterAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List chapterList; // �½��б�
	private Chapter chapter; // �½�
	private Integer chapterId; // �½�ID
	private Course course; // �γ�

	private IChapterService chapterService; // �����½ڵĽӿ�

	/**
	 * ����½�
	 * 
	 * @return
	 */
	public String addChapter() {
		course = super.getCourse();
		if (chapterService.addChapter(course, chapter))
			return SUCCESS;
		else {
			addActionError("����½ڴ��������²�����");
			return ERROR;
		}
	}

	/**
	 * ���ݿγ̲����½��б�
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getChapterListByCourse() {
		course = super.getCourse();
		chapterList = chapterService.getAllChapter(course);
		return SUCCESS;
	}

	public String deleteChapter() {
		Chapter delChapter = chapterService.getChapterById(chapterId);
		if (chapterService.deleteChapter(delChapter))
			return SUCCESS;
		else {
			addActionError("ɾ���½�ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ��ת���༭�½�
	 * 
	 * @return
	 */
	public String goEditChapter() {
		chapter = chapterService.getChapterById(chapterId);
		return SUCCESS;
	}

	/**
	 * �����½�
	 * 
	 * @return
	 */
	public String updateChapter() {
		if (chapterService.updateChapter(chapter))
			return SUCCESS;
		else {
			addActionError("�����½�ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	public List getChapterList() {
		return chapterList;
	}

	public void setChapterList(List chapterList) {
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public IChapterService getChapterService() {
		return chapterService;
	}

	public void setChapterService(IChapterService chapterService) {
		this.chapterService = chapterService;
	}
	
	

	
}
