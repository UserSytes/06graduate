package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.service.IChapterService;
/**
 * 负责课程章节的类
 * @author 何申密
 *
 */
public class CourseChapterAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Chapter> chapterList; // 章节列表
	private Chapter chapter; // 章节
	private Integer chapterId; // 章节ID
	private Course course; // 课程

	private IChapterService chapterService; // 负责章节的接口

	/**
	 * 添加章节
	 * 
	 * @return
	 */
	public String addChapter() {
		course = super.getCourse();
		if (chapterService.addChapter(course, chapter))
			return SUCCESS;
		else {
			addActionError("添加章节错误，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 根据课程查找章节列表
	 * 
	 * @return
	 */
	public String getChapterListByCourse() {
		course = super.getCourse();
		setChapterList(chapterService.getAllChapter(course));
		return SUCCESS;
	}

	/**
	 * 删除章节
	 * @return
	 */
	public String deleteChapter() {
		Chapter delChapter = chapterService.getChapterById(chapterId);
		if (chapterService.deleteChapter(delChapter))
			return SUCCESS;
		else {
			addActionError("删除章节失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 跳转到编辑章节
	 * 
	 * @return
	 */
	public String goEditChapter() {
		chapter = chapterService.getChapterById(chapterId);
		return SUCCESS;
	}

	/**
	 * 更新章节
	 * 
	 * @return
	 */
	public String updateChapter() {
		if (chapterService.updateChapter(chapter))
			return SUCCESS;
		else {
			addActionError("更新章节失败，请重新操作！");
			return ERROR;
		}
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

	public void setChapterList(List<Chapter> chapterList) {
		this.chapterList = chapterList;
	}

	public List<Chapter> getChapterList() {
		return chapterList;
	}
	
	

	
}
