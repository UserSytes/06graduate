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
import cn.edu.xmu.course.pojo.Experiment;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.IChapterService;
import cn.edu.xmu.course.service.ICoursewareService;
import cn.edu.xmu.course.service.IExerciseService;
import cn.edu.xmu.course.service.IExperimentService;

public class ExperimentAction extends BaseAction {

	private List<Chapter> chapterList;
	private Chapter chapter;
	private Integer chapterId;

	private List<Experiment> experimentList;
	private Experiment experiment;
	private Integer experimentId;

	private File upload;
	private String uploadContentType;
	private String uploadFileName;

	private IChapterService chapterService;
	private IExperimentService experimentService;

	public String getExperimentListByChapter() {
		Course course = super.getCourse();
		chapterList = chapterService.getAllChapter(super.getCourse());
		if(chapterId ==null ||chapterId== -1)
		experimentList = experimentService.getAllExperiments(course);
		else{
			chapter = chapterService.getChapterById(chapterId);
			experimentList = experimentService.getExperimentsByChapter(chapter);
		}
		return SUCCESS;
	}

	public String addExperiment() {
		if (upload.length() >= new Long(10485760L)) {
			addActionError("上传习题大小不能超过10M,请重新上传！");
			return ERROR;
		}
		String fileLink = super.getPreFileNameByTeacher() + uploadFileName;
		experiment.setFilename(uploadFileName);
		experiment.setFileLink(fileLink);
		chapter = chapterService.getChapterById(chapterId);
		if (experimentService.addExperiment(experiment, chapter, upload))
			return SUCCESS;
		else {
			addActionError("添加习题失败，请重新添加！");
			return ERROR;
		}
	}

	public String goEditExperiment() {
		experiment = experimentService.getExperimentById(experimentId);
		chapterList = chapterService.getAllChapter(super.getCourse());
		chapterId = experiment.getChapter().getId();
		return SUCCESS;
	}

	public String goAddExperiment() {
		chapterList = chapterService.getAllChapter(super.getCourse());
		return SUCCESS;
	}

	public String updateExperiment() {
		if (upload.length() >= new Long(10485760L)) {
			addActionError("上传习题大小不能超过10M,请重新上传！");
			return ERROR;
		}
		String fileLink = super.getPreFileNameByTeacher() + uploadFileName;
		experiment.setFilename(uploadFileName);
		experiment.setFileLink(fileLink);
		chapter = chapterService.getChapterById(chapterId);
		if (experimentService.updateExperiment(experiment, chapter, upload))
			return SUCCESS;
		else {
			addActionError("更新习题失败，请重新操作！");
			return ERROR;
		}
	}

	public String deleteExperiment() {
		Experiment delExperiment = experimentService
				.getExperimentById(experimentId);
		if (experimentService.deleteExperiment(delExperiment))
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

	public Integer getExperimentId() {
		return experimentId;
	}

	public void setExperimentId(Integer experimentId) {
		this.experimentId = experimentId;
	}

	public IExperimentService getExperimentService() {
		return experimentService;
	}

	public void setExperimentService(IExperimentService experimentService) {
		this.experimentService = experimentService;
	}

}
