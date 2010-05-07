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
	private List<Chapter> chapterList; // �½��б�
	private Chapter chapter; // �½�
	private Integer chapterId; // �½�ID

	private List<Experiment> experimentList; // ʵ��ָ���б�
	private Experiment experiment; // ʵ��ָ��
	private Integer experimentId; // ʵ��ָ��ID

	private File upload; // ����
	private String uploadContentType; // �ļ�����
	private String uploadFileName; // �ļ�����

	private IChapterService chapterService; // �����½ڵĽӿ�
	private IExperimentService experimentService; // ����ʵ��ָ���Ľӿ�

	/**
	 * �����½ڲ���ʵ��ָ��
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
	 * �����½ڲ���ʵ��ָ��
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
	 * ����ʵ��ָ��
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String downloadExperiment() {
		Chapter currentChapter = chapterService.getChapter(chapterId);
		experimentList = experimentService
				.getExperimentsByChapter(currentChapter);
		if (getExperimentList() == null) {
			System.out.println("���½���ʵ�飡");
			addActionError("���½���ʵ�飡");
			return ERROR;
		} else
			return "experiment";
	}

	/**
	 * ���ʵ��ָ��
	 * 
	 * @return
	 */
	public String addExperiment() {
		if (upload.length() >= new Long(10485760L)) {
			addActionError("�ϴ�ϰ���С���ܳ���10M,�������ϴ���");
			return ERROR;
		}
		String fileLink = super.getPreFileNameByTeacher() + uploadFileName;
		experiment.setFilename(uploadFileName);
		experiment.setFileLink(fileLink);
		chapter = chapterService.getChapterById(chapterId);
		if (experimentService.addExperiment(experiment, chapter, upload))
			return SUCCESS;
		else {
			addActionError("���ϰ��ʧ�ܣ���������ӣ�");
			return ERROR;
		}
	}

	/**
	 * ��ת���༭ʵ��ָ��
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
	 * ��ת�����ʵ��ָ��
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String goAddExperiment() {
		chapterList = chapterService.getAllChapter(super.getCourse());
		return SUCCESS;
	}

	/**
	 * ����ʵ��ָ��
	 * 
	 * @return
	 */
	public String updateExperiment() {
		if (upload.length() >= new Long(10485760L)) {
			addActionError("�ϴ�ϰ���С���ܳ���10M,�������ϴ���");
			return ERROR;
		}
		String fileLink = super.getPreFileNameByTeacher() + uploadFileName;
		experiment.setFilename(uploadFileName);
		experiment.setFileLink(fileLink);
		chapter = chapterService.getChapterById(chapterId);
		if (experimentService.updateExperiment(experiment, chapter, upload))
			return SUCCESS;
		else {
			addActionError("����ϰ��ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ɾ��ʵ��ָ��
	 * 
	 * @return
	 */
	public String deleteExperiment() {
		Experiment delExperiment = experimentService
				.getExperimentById(experimentId);
		if (experimentService.deleteExperiment(delExperiment))
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
