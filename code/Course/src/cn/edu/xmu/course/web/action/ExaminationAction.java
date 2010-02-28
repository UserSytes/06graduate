package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseMovie;
import cn.edu.xmu.course.pojo.Courseware;
import cn.edu.xmu.course.pojo.Examination;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.IChapterService;
import cn.edu.xmu.course.service.ICourseMovieService;
import cn.edu.xmu.course.service.ICoursewareService;
import cn.edu.xmu.course.service.IExaminationService;

public class ExaminationAction extends BaseAction {

	private List<Examination> examinationList;
	private Examination examination;
	private Integer examinationId;
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;

	private IExaminationService examinationService;

	public String getExaminationListByCourse() {
		System.out.println(super.getCourse());
		examinationList = examinationService.getAllExaminations(super.getCourse());
		return SUCCESS;
	}

	public String addExamination() {
		String fileLink = super.getTeacher().getUserInfo().getName() + "/"
		+ new Date().getTime()+"_"+super.getCourse().getName() + "_" + uploadFileName;
		examination.setFilename(uploadFileName);
		examination.setFileLink(fileLink);
		if (examinationService.addExamination(examination, super.getCourse(), upload))
			return SUCCESS;
		else {
			addActionError("添加课程试卷失败，请重新添加！");
			return ERROR;
		}
	}

	public String goEditExamination() {
		examination = examinationService.getExaminationById(examinationId);		
		return SUCCESS;
	}

	public String updateExamination() {
		String fileLink = super.getPreFileNameByTeacher() + uploadFileName;
		examination.setFilename(uploadFileName);
		examination.setFileLink(fileLink);
		if (examinationService.updateExamination(examination,upload))
			return SUCCESS;
		else {
			addActionError("更新课程试卷失败，请重新操作！");
			return ERROR;
		}
	}

	public String deleteExamination() {
		Examination delExamination = examinationService.getExaminationById(examinationId);
		if (examinationService.deleteExamination(delExamination))
			return SUCCESS;
		else {
			addActionError("删除课程试卷失败，请重新操作！");
			return ERROR;
		}
	}

	public String getExaminationById(){
		examination = examinationService.getExaminationById(examinationId);
		if (examination==null)
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
