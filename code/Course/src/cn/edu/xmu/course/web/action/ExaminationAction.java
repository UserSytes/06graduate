package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Examination;
import cn.edu.xmu.course.service.IExaminationService;
/**
 * 负责课程试卷的类
 * @author 何申密
 * @author 许子彦
 *
 */
public class ExaminationAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5129824371383442450L;
	private List<Examination> examinationList; // 试卷列表
	private Examination examination; // 试卷
	private Integer examinationId; // 试卷ID

	private File upload; // 附件
	private String uploadContentType; // 文件类型
	private String uploadFileName; // 文件名称

	private IExaminationService examinationService; // 负责课程试卷的接口

	/**
	 * 根据课程查找试卷
	 * 
	 * @return
	 */
	public String getExaminationListByCourse() {
		examinationList = examinationService.getAllExaminations(super
				.getCourse());
		return SUCCESS;
	}

	/**
	 * 查找所有试卷
	 * 
	 * @return
	 */
	public String getAllExamination() {
		Course course = super.getCourse();
		examinationList = examinationService.getAllExaminations(course);
		return SUCCESS;
	}

	/**
	 * 增加试卷
	 * 
	 * @return
	 */
	public String addExamination() {
		String fileLink = super.getPreFileNameByTeacher(super.getCourse()) + uploadFileName;
		examination.setFilename(uploadFileName);
		examination.setFileLink(fileLink);
		if (examinationService.addExamination(examination, super.getCourse(),
				upload))
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
	public String goEditExamination() {
		examination = examinationService.getExaminationById(examinationId);
		return SUCCESS;
	}

	/**
	 * 更新试卷
	 * 
	 * @return
	 */
	public String updateExamination() {
		String fileLink = super.getPreFileNameByTeacher(super.getCourse()) + uploadFileName;
		examination.setFilename(uploadFileName);
		examination.setFileLink(fileLink);
		if (examinationService.updateExamination(examination, upload))
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
	public String deleteExamination() {
		Examination delExamination = examinationService
				.getExaminationById(examinationId);
		if (examinationService.deleteExamination(delExamination))
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
	public String getExaminationById() {
		examination = examinationService.getExaminationById(examinationId);
		if (examination == null)
			return ERROR;
		else {
			return SUCCESS;
		}
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

	public List<Examination> getExaminationList() {
		return examinationList;
	}

	public void setExaminationList(List<Examination> examinationList) {
		this.examinationList = examinationList;
	}

	public Examination getExamination() {
		return examination;
	}

	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	public Integer getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(Integer examinationId) {
		this.examinationId = examinationId;
	}

	public IExaminationService getExaminationService() {
		return examinationService;
	}

	public void setExaminationService(IExaminationService examinationService) {
		this.examinationService = examinationService;
	}

}
