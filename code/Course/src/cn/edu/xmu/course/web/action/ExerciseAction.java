package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.sun.org.apache.bcel.internal.generic.DLOAD;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Courseware;
import cn.edu.xmu.course.pojo.Exercise;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.IChapterService;
import cn.edu.xmu.course.service.ICoursewareService;
import cn.edu.xmu.course.service.IExerciseService;

public class ExerciseAction extends BaseAction {

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

	public String getExerciseListByChapter() {
		Course course = super.getCourse();
		exerciseList = exerciseService.getAllExercises(course);
		return SUCCESS;
	}

	public String addExercise() {
		if(upload.length()>=new Long(10485760L)){
			addActionError("上传习题大小不能超过10M,请重新上传！");
			return ERROR;
		}
		String fileLink = super.getTeacher().getUserInfo().getName() + "/"
				+ super.getCourse().getName() + "_" + uploadFileName;
		exercise.setFilename(uploadFileName);
		exercise.setFileLink(fileLink);
		chapter = chapterService.getChapterById(chapterId);
		if (exerciseService.addExercise(exercise, chapter, upload))
			return SUCCESS;
		else {
			addActionError("添加习题失败，请重新添加！");
			return ERROR;
		}
	}

	public String goEditExercise() {
		exercise = exerciseService.getExerciseById(exerciseId);
		chapterList = chapterService.getAllChapter(super.getCourse());
		chapterId = exercise.getChapter().getId();
		return SUCCESS;
	}

	public String goAddExercise() {
		chapterList = chapterService.getAllChapter(super.getCourse());
		return SUCCESS;
	}

	public String updateExercise() {
		if(upload.length()>=new Long(10485760L)){
			addActionError("上传习题大小不能超过10M,请重新上传！");
			return ERROR;
		}
		String fileLink = super.getTeacher().getUserInfo().getName() + "/"
				+ super.getCourse().getName() + "_" + uploadFileName;
		exercise.setFilename(uploadFileName);
		exercise.setFileLink(fileLink);
		chapter = chapterService.getChapterById(chapterId);
		if (exerciseService.updateExercise(exercise, chapter,upload))
			return SUCCESS;
		else {
			addActionError("更新习题失败，请重新操作！");
			return ERROR;
		}
	}

	public String deleteExercise() {
		Exercise delExercise = exerciseService.getExerciseById(exerciseId);
		if (exerciseService.deleteExercise(delExercise))
			return SUCCESS;
		else {
			addActionError("删除习题失败，请重新操作！");
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
