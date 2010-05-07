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
	private List<Courseware> coursewareList; // 课件列表
	private Courseware courseware; // 课件

	private List<Experiment> experimentList; // 实验指导列表
	private Experiment experiment; // 实验指导

	private List<Exercise> exerciseList; // 练习列表
	private Exercise exercise; // 练习

	private Course course; // 课程

	private IChapterService chapterService; // 负责章节的接口
	private ICoursewareService coursewareService; // 负责课件的接口
	private IExerciseService exerciseService; // 负责习题的接口
	private IExperimentService experimentService; // 负责实验指导的接口

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

	public List<Experiment> getExperimentList() {
		return experimentList;
	}

	public void setExperimentList(List<Experiment> experimentList) {
		this.experimentList = experimentList;
	}

	public Experiment getExperiment() {
		return experiment;
	}

	public void setExperiment(Experiment experiment) {
		this.experiment = experiment;
	}

	public List<Exercise> getExerciseList() {
		return exerciseList;
	}

	public void setExerciseList(List<Exercise> exerciseList) {
		this.exerciseList = exerciseList;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
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

	public ICoursewareService getCoursewareService() {
		return coursewareService;
	}

	public void setCoursewareService(ICoursewareService coursewareService) {
		this.coursewareService = coursewareService;
	}

	public IExerciseService getExerciseService() {
		return exerciseService;
	}

	public void setExerciseService(IExerciseService exerciseService) {
		this.exerciseService = exerciseService;
	}

	public IExperimentService getExperimentService() {
		return experimentService;
	}

	public void setExperimentService(IExperimentService experimentService) {
		this.experimentService = experimentService;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

	public Integer getChapterId() {
		return chapterId;
	}

}
