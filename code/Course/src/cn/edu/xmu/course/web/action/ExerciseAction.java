package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Exercise;
import cn.edu.xmu.course.service.IChapterService;
import cn.edu.xmu.course.service.IExerciseService;
/**
 * ����ϰ�����
 * @author ������
 * @author ������
 *
 */
public class ExerciseAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7294719167547807888L;
	private List<Chapter> chapterList;
	private Chapter chapter;
	private Integer chapterId;

	private List<Exercise> exerciseList;
	private Exercise exercise;
	private Integer exerciseId;

	private File upload;
	private String uploadContentType;
	private String uploadFileName;

	private IChapterService chapterService;
	private IExerciseService exerciseService;
	/**
	 * �����½ڲ�����ϰ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getExerciseListByChapter() {
		Course course = super.getCourse();
		chapterList = chapterService.getAllChapter(super.getCourse());
		if (chapterId == null || chapterId == -1)
			exerciseList = exerciseService.getAllExercises(course);
		else {
			chapter = chapterService.getChapterById(chapterId);
			exerciseList = exerciseService.getExercisesByChapter(chapter);
		}
		return SUCCESS;
	}
	/**
	 * ����������ϰ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getAllExercise() {
		Course course = super.getCourse();
		exerciseList = exerciseService.getAllExercises(course);
		return SUCCESS;
	}
	/**
	 * ������ϰ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String downloadExercise() {
		Chapter currentChapter = chapterService.getChapter(chapterId);
		exerciseList = exerciseService.getExercisesByChapter(currentChapter);
		if (getExerciseList() == null) {
			System.out.println("���½���ϰ�⣡");
			addActionError("���½���ϰ�⣡");
			return ERROR;
		} else
			return "exercise";
	}
	/**
	 * �����ϰ
	 * @return
	 */
	public String addExercise() {		
		String fileLink = super.getPreFileNameByTeacher(super.getCourse()) + uploadFileName;
		exercise.setFilename(uploadFileName);
		exercise.setFileLink(fileLink);
		chapter = chapterService.getChapterById(chapterId);
		if (exerciseService.addExercise(exercise, chapter, upload))
			return SUCCESS;
		else {
			addActionError("���ϰ��ʧ�ܣ���������ӣ�");
			return ERROR;
		}
	}
	/**
	 * ��ת���༭��ϰ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String goEditExercise() {
		exercise = exerciseService.getExerciseById(exerciseId);
		chapterList = chapterService.getAllChapter(super.getCourse());
		chapterId = exercise.getChapter().getId();
		return SUCCESS;
	}
	/**
	 * ��ת�������ϰ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String goAddExercise() {
		chapterList = chapterService.getAllChapter(super.getCourse());
		return SUCCESS;
	}
	/**
	 * ������ϰ
	 * @return
	 */
	public String updateExercise() {	
		String fileLink = super.getPreFileNameByTeacher(super.getCourse()) + uploadFileName;
		exercise.setFilename(uploadFileName);
		exercise.setFileLink(fileLink);
		chapter = chapterService.getChapterById(chapterId);
		if (exerciseService.updateExercise(exercise, chapter, upload))
			return SUCCESS;
		else {
			addActionError("����ϰ��ʧ�ܣ������²�����");
			return ERROR;
		}
	}
	/**
	 * ɾ����ϰ
	 * @return
	 */
	public String deleteExercise() {
		Exercise delExercise = exerciseService.getExerciseById(exerciseId);
		if (exerciseService.deleteExercise(delExercise))
			return SUCCESS;
		else {
			addActionError("ɾ��ϰ��ʧ�ܣ������²�����");
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

	public Integer getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(Integer exerciseId) {
		this.exerciseId = exerciseId;
	}

	public IChapterService getChapterService() {
		return chapterService;
	}

	public void setChapterService(IChapterService chapterService) {
		this.chapterService = chapterService;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setExerciseService(IExerciseService exerciseService) {
		this.exerciseService = exerciseService;
	}

	public IExerciseService getExerciseService() {
		return exerciseService;
	}

}
