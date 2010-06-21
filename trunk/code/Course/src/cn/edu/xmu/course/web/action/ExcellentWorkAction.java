package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.ExcellentWork;
import cn.edu.xmu.course.service.IExcellentWorkService;

public class ExcellentWorkAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ExcellentWork> excellentWorkList; // 优秀作业列表
	private ExcellentWork excellentWork; // 优秀作业卷
	private Integer excellentWorkId; // 优秀作业ID

	private File upload; // 附件
	private String uploadContentType; // 文件类型
	private String uploadFileName; // 文件名称

	private IExcellentWorkService excellentWorkService; // 负责优秀作业的接口

	/**
	 * 根据课程查找优秀作业
	 * 
	 * @return
	 */
	public String getExcellentWorkListByCourse() {
		Course currentCourse = super.getCourse();
		excellentWorkList = excellentWorkService
				.getAllExcellentWorks(currentCourse);
		return SUCCESS;
	}

	/**
	 * 查找所有试卷
	 * 
	 * @return
	 */
	public String getAllExcellentWorks() {
		Course course = super.getCourse();
		excellentWorkList = excellentWorkService.getAllExcellentWorks(course);
		return SUCCESS;
	}

	/**
	 * 增加试卷
	 * 
	 * @return
	 */
	public String addExcellentWork() {
		String fileLink = super.getPreFileNameByTeacher(super.getCourse())
				+ uploadFileName;
		excellentWork.setFilename(uploadFileName);
		excellentWork.setFileLink(fileLink);
		if (excellentWorkService.addExcellentWork(excellentWork, super
				.getCourse(), upload))
			return SUCCESS;
		else {
			addActionError("添加课程试卷失败，请重新添加！");
			return ERROR;
		}
	}

	/**
	 * 跳转到编辑试卷
	 * 
	 * @return
	 */
	public String goEditExcellentWork() {
		excellentWork = excellentWorkService
				.getExcellentWorkById(excellentWorkId);
		return SUCCESS;
	}

	/**
	 * 更新试卷
	 * 
	 * @return
	 */
	public String updateExcellentWork() {
		String fileLink = super.getPreFileNameByTeacher(super.getCourse())
				+ uploadFileName;
		excellentWork.setFilename(uploadFileName);
		excellentWork.setFileLink(fileLink);
		if (excellentWorkService.updateExcellentWork(excellentWork, super
				.getCourse(), upload))
			return SUCCESS;
		else {
			addActionError("更新课程试卷失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 删除试卷
	 * 
	 * @return
	 */
	public String deleteExcellentWork() {
		ExcellentWork delExcellentWork = excellentWorkService
				.getExcellentWorkById(excellentWorkId);
		if (excellentWorkService.deleteExcellentWork(delExcellentWork))
			return SUCCESS;
		else {
			addActionError("删除课程试卷失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 根据ID查找试卷
	 * 
	 * @return
	 */
	public String getExcellentWorkById() {
		excellentWork = excellentWorkService
				.getExcellentWorkById(excellentWorkId);
		if (excellentWork == null)
			return ERROR;
		else {
			return SUCCESS;
		}
	}

	public List<ExcellentWork> getExcellentWorkList() {
		return excellentWorkList;
	}

	public void setExcellentWorkList(List<ExcellentWork> excellentWorkList) {
		this.excellentWorkList = excellentWorkList;
	}

	public ExcellentWork getExcellentWork() {
		return excellentWork;
	}

	public void setExcellentWork(ExcellentWork excellentWork) {
		this.excellentWork = excellentWork;
	}

	public Integer getExcellentWorkId() {
		return excellentWorkId;
	}

	public void setExcellentWorkId(Integer excellentWorkId) {
		this.excellentWorkId = excellentWorkId;
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

	public IExcellentWorkService getExcellentWorkService() {
		return excellentWorkService;
	}

	public void setExcellentWorkService(
			IExcellentWorkService excellentWorkService) {
		this.excellentWorkService = excellentWorkService;
	}
}
