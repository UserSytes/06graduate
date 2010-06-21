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
	private List<ExcellentWork> excellentWorkList; // ������ҵ�б�
	private ExcellentWork excellentWork; // ������ҵ��
	private Integer excellentWorkId; // ������ҵID

	private File upload; // ����
	private String uploadContentType; // �ļ�����
	private String uploadFileName; // �ļ�����

	private IExcellentWorkService excellentWorkService; // ����������ҵ�Ľӿ�

	/**
	 * ���ݿγ̲���������ҵ
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
	 * ���������Ծ�
	 * 
	 * @return
	 */
	public String getAllExcellentWorks() {
		Course course = super.getCourse();
		excellentWorkList = excellentWorkService.getAllExcellentWorks(course);
		return SUCCESS;
	}

	/**
	 * �����Ծ�
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
			addActionError("��ӿγ��Ծ�ʧ�ܣ���������ӣ�");
			return ERROR;
		}
	}

	/**
	 * ��ת���༭�Ծ�
	 * 
	 * @return
	 */
	public String goEditExcellentWork() {
		excellentWork = excellentWorkService
				.getExcellentWorkById(excellentWorkId);
		return SUCCESS;
	}

	/**
	 * �����Ծ�
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
			addActionError("���¿γ��Ծ�ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ɾ���Ծ�
	 * 
	 * @return
	 */
	public String deleteExcellentWork() {
		ExcellentWork delExcellentWork = excellentWorkService
				.getExcellentWorkById(excellentWorkId);
		if (excellentWorkService.deleteExcellentWork(delExcellentWork))
			return SUCCESS;
		else {
			addActionError("ɾ���γ��Ծ�ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ����ID�����Ծ�
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
