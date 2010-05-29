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

/**
 * �γ̿���
 * 
 * @author ������
 * @author ������
 * 
 */
public class ExaminationService implements IExaminationService {

	private ExaminationDAO examinationDAO;
	private NoticeDAO noticeDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IExaminationService#addExamination(cn.edu.xmu
	 * .course.pojo.Examination, cn.edu.xmu.course.pojo.Course, java.io.File)
	 */
	public boolean addExamination(Examination examination, Course course,
			File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + examination.getFileLink();
		File file = new File(fileName);
		examination.setCourse(course);
		String title = "���ʵ��ָ����" + examination.getTitle() + "��";
		String content = "<p>�������ʵ��ָ����" + examination.getTitle()
				+ "������ͬѧ��ע����ġ�</p>";
		Notice notice = new Notice(course, title, content, new Date(), 1);
		try {
			if (FileOperation.copy(upload, file)) {
				examinationDAO.save(examination);
				getNoticeDAO().save(notice);
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IExaminationService#deleteExamination(cn.edu
	 * .xmu.course.pojo.Examination)
	 */
	public boolean deleteExamination(Examination examination) {
		// TODO Auto-generated method stub
		try {
			examinationDAO.delete(examination);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IExaminationService#getAllExaminations(cn.edu
	 * .xmu.course.pojo.Course)
	 */
	public List<Examination> getAllExaminations(Course course) {
		// TODO Auto-generated method stub
		return examinationDAO.findByCourse(course);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IExaminationService#getExaminationById(java
	 * .lang.Integer)
	 */
	public Examination getExaminationById(Integer id) {
		// TODO Auto-generated method stub
		return examinationDAO.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IExaminationService#updateExamination(cn.edu
	 * .xmu.course.pojo.Examination, java.io.File)
	 */
	public boolean updateExamination(Examination examination, File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + examination.getFileLink();
		File file = new File(fileName);
		String title = "�޸�ʵ��ָ����" + examination.getTitle() + "��";
		String content = "<p>�޸�����ʵ��ָ����" + examination.getTitle()
				+ "������ͬѧ��ע����ġ�</p>";
		Notice notice = new Notice(examination.getCourse(), title, content,
				new Date(), 1);
		try {
			if (FileOperation.copy(upload, file)) {
				examinationDAO.merge(examination);
				getNoticeDAO().save(notice);
				return true;
			} else
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
