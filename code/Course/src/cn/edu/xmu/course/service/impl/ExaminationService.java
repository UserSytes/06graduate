package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.ExaminationDAO;
import cn.edu.xmu.course.dao.NoticeDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Examination;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.service.IExaminationService;

public class ExaminationService implements IExaminationService {

	private ExaminationDAO examinationDAO;
	private NoticeDAO noticeDAO;

	public boolean addExamination(Examination examination, Course course,
			File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + examination.getFileLink();
		File file = new File(fileName);
		examination.setCourse(course);
		String title = "添加实验指导《"+examination.getTitle()+"》";
		String content = "<p>添加最新实验指导《"+examination.getTitle()+"》，请同学们注意查阅。</p>";
		Notice notice = new Notice(course,title,content,new Date(),1);	
		try {			
			if (FileOperation.copy(upload, file)){
				examinationDAO.save(examination);
				getNoticeDAO().save(notice);
				return true;
			}				
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteExamination(Examination examination) {
		// TODO Auto-generated method stub
		try{
			examinationDAO.delete(examination);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public List getAllExaminations(Course course) {
		// TODO Auto-generated method stub
		return examinationDAO.findByCourse(course);
	}

	public Examination getExaminationById(Integer id) {
		// TODO Auto-generated method stub
		return examinationDAO.findById(id);
	}

	public boolean updateExamination(Examination examination, File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + examination.getFileLink();
		File file = new File(fileName);
		String title = "修改实验指导《"+examination.getTitle()+"》";
		String content = "<p>修改已有实验指导《"+examination.getTitle()+"》，请同学们注意查阅。</p>";
		Notice notice = new Notice(examination.getCourse(),title,content,new Date(),1);	
		try {			
			if (FileOperation.copy(upload, file)){
				examinationDAO.merge(examination);
				getNoticeDAO().save(notice);
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void setExaminationDAO(ExaminationDAO examinationDAO) {
		this.examinationDAO = examinationDAO;
	}

	public ExaminationDAO getExaminationDAO() {
		return examinationDAO;
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

}
