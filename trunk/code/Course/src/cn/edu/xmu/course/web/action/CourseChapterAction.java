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
	private List<Chapter> chapterList; // �½��б�
	private Chapter chapter; // �½�
	private Integer chapterId; // �½�ID
	private List<Courseware> coursewareList; // �μ��б�
	private Courseware courseware; // �μ�

	private List<Experiment> experimentList; // ʵ��ָ���б�
	private Experiment experiment; // ʵ��ָ��

	private List<Exercise> exerciseList; // ��ϰ�б�
	private Exercise exercise; // ��ϰ

	private Course course; // �γ�

	private IChapterService chapterService; // �����½ڵĽӿ�
	private ICoursewareService coursewareService; // ����μ��Ľӿ�
	private IExerciseService exerciseService; // ����ϰ��Ľӿ�
	private IExperimentService experimentService; // ����ʵ��ָ���Ľӿ�

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
