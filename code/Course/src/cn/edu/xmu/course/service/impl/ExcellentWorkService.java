package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.ExcellentWorkDAO;
import cn.edu.xmu.course.dao.NoticeDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.ExcellentWork;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.service.IExcellentWorkService;

public class ExcellentWorkService implements IExcellentWorkService {
	private ExcellentWorkDAO excellentWorkDAO;
	private NoticeDAO noticeDAO;

	public boolean addExcellentWork(ExcellentWork excellentWork, Course course,
			File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + excellentWork.getFileLink();
		File file = new File(fileName);
		excellentWork.setTime(Calendar.getInstance().getTime());
		excellentWork.setCourse(course);
		String title = "添加优秀作业《" + excellentWork.getTitle() + "》";
		String content = "<p>添加最新的优秀作业《" + excellentWork.getTitle()
				+ "》，请同学们注意查阅。</p>";
		Notice notice = new Notice(course, title, content, new Date(), 1);
		try {
			if (FileOperation.copy(upload, file)) {
				getExcellentWorkDAO().save(excellentWork);
				getNoticeDAO().save(notice);
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteExcellentWork(ExcellentWork excellentWork) {
		// TODO Auto-generated method stub
		try {
			excellentWorkDAO.delete(excellentWork);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<ExcellentWork> getAllExcellentWorks(Course course) {
		// TODO Auto-generated method stub
		return excellentWorkDAO.findByCourse(course.getId());
	}

	public ExcellentWork getExcellentWorkById(Integer id) {
		return excellentWorkDAO.findById(id);
	}

	public boolean updateExcellentWork(ExcellentWork excellentWork,
			Course course, File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + excellentWork.getFileLink();
		File file = new File(fileName);
		excellentWork.setCourse(course);
		excellentWork.setTime(Calendar.getInstance().getTime());
		String title = "修改优秀作业《" + excellentWork.getTitle() + "》";
		String content = "<p>修改已有优秀作业《" + excellentWork.getTitle()
				+ "》，请同学们注意查阅。</p>";
		Notice notice = new Notice(course, title, content, new Date(), 1);
		try {
			if (FileOperation.copy(upload, file)) {
				excellentWorkDAO.merge(excellentWork);
				getNoticeDAO().save(notice);
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void setExcellentWorkDAO(ExcellentWorkDAO excellentWorkDAO) {
		this.excellentWorkDAO = excellentWorkDAO;
	}

	public ExcellentWorkDAO getExcellentWorkDAO() {
		return excellentWorkDAO;
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

}
