package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Experiment;
import cn.edu.xmu.course.service.IChapterService;
import cn.edu.xmu.course.service.IExperimentService;

public class ExperimentAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -575628690307801300L;
	private List<Chapter> chapterList; // 章节列表
	private Chapter chapter; // 章节
	private Integer chapterId; // 章节ID

	private List<Experiment> experimentList; // 实验指导列表
	private Experiment experiment; // 实验指导
	private Integer experimentId; // 实验指导ID

	private File upload; // 附件
	private String uploadContentType; // 文件类型
	private String uploadFileName; // 文件名称

	private IChapterService chapterService; // 负责章节的接口
	private IExperimentService experimentService; // 负责实验指导的接口

	/**
	 * 根据章节查找实验指导
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getExperimentListByChapter() {
		Course course = super.getCourse();
		chapterList = chapterService.getAllChapter(super.getCourse());
		if (chapterId == null || chapterId == -1)
			experimentList = experimentService.getAllExperiments(course);
		else {
			chapter = chapterService.getChapterById(chapterId);
			experimentList = experimentService.getExperimentsByChapter(chapter);
		}
		return SUCCESS;
	}

	/**
	 * 根据章节查找实验指导
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getAllExperiment() {
		Course course = super.getCourse();
		experimentList = experimentService.getAllExperiments(course);
		return SUCCESS;
	}

	/**
	 * 下载实验指导
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String downloadExperiment() {
		Chapter currentChapter = chapterService.getChapter(chapterId);
		experimentList = experimentService
				.getExperimentsByChapter(currentChapter);
		if (getExperimentList() == null) {
			System.out.println("本章节无实验！");
			addActionError("本章节无实验！");
			return ERROR;
		} else
			return "experiment";
	}

	/**
	 * 添加实验指导
	 * 
	 * @return
	 */
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

	/**
	 * 跳转到编辑实验指导
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String goEditExperiment() {
		experiment = experimentService.getExperimentById(experimentId);
		chapterList = chapterService.getAllChapter(super.getCourse());
		chapterId = experiment.getChapter().getId();
		return SUCCESS;
	}

	/**
	 * 跳转到添加实验指导
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String goAddExperiment() {
		chapterList = chapterService.getAllChapter(super.getCourse());
		return SUCCESS;
	}

	/**
	 * 更新实验指导
	 * 
	 * @return
	 */
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

	/**
	 * 删除实验指导
	 * 
	 * @return
	 */
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
