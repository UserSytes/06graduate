package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Examination;
import cn.edu.xmu.course.service.IExaminationService;
/**
 * ����γ��Ծ����
 * @author ������
 * @author ������
 *
 */
public class ExaminationAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5129824371383442450L;
	private List<Examination> examinationList; // �Ծ��б�
	private Examination examination; // �Ծ�
	private Integer examinationId; // �Ծ�ID

	private File upload; // ����
	private String uploadContentType; // �ļ�����
	private String uploadFileName; // �ļ�����

	private IExaminationService examinationService; // ����γ��Ծ�Ľӿ�

	/**
	 * ���ݿγ̲����Ծ�
	 * 
	 * @return
	 */
	public String getExaminationListByCourse() {
		examinationList = examinationService.getAllExaminations(super
				.getCourse());
		return SUCCESS;
	}

	/**
	 * ���������Ծ�
	 * 
	 * @return
	 */
	public String getAllExamination() {
		Course course = super.getCourse();
		examinationList = examinationService.getAllExaminations(course);
		return SUCCESS;
	}

	/**
	 * �����Ծ�
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
			addActionError("��ӿγ��Ծ�ʧ�ܣ���������ӣ�");
			return ERROR;
		}
	}

	/**
	 * ��ת���༭�Ծ�
	 * 
	 * @return
	 */
	public String goEditExamination() {
		examination = examinationService.getExaminationById(examinationId);
		return SUCCESS;
	}

	/**
	 * �����Ծ�
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
			addActionError("���¿γ��Ծ�ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ɾ���Ծ�
	 * 
	 * @return
	 */
	public String deleteExamination() {
		Examination delExamination = examinationService
				.getExaminationById(examinationId);
		if (examinationService.deleteExamination(delExamination))
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
