package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.ExaminationDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Examination;
import cn.edu.xmu.course.service.IExaminationService;

public class ExaminationService implements IExaminationService {

	private ExaminationDAO examinationDAO;

	public boolean addExamination(Examination examination, Course course,
			File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + examination.getFileLink();
		File file = new File(fileName);
		examination.setCourse(course);
		try {			
			if (FileOperation.copy(upload, file)){
				examinationDAO.save(examination);
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
		try {			
			if (FileOperation.copy(upload, file)){
				examinationDAO.merge(examination);
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

}
