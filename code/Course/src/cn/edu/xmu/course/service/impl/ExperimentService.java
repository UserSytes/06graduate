package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.ExperimentDAO;
import cn.edu.xmu.course.dao.NoticeDAO;
import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Experiment;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.service.IExperimentService;

public class ExperimentService implements IExperimentService {
	private ExperimentDAO experimentDAO;
	private NoticeDAO noticeDAO;

	public boolean addExperiment(Experiment experiment, Chapter chapter,
			File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + experiment.getFileLink();
		File file = new File(fileName);
		experiment.setChapter(chapter);
		experiment.setTime(Calendar.getInstance().getTime());
		String title = "添加实验指导《"+experiment.getTitle()+"》";
		String content = "<p>添加最新实验指导《"+experiment.getTitle()+"》，请同学们注意查阅。</p>";
		Notice notice = new Notice(chapter.getCourse(),title,content,new Date(),1);	
		try {			
			if (FileOperation.copy(upload, file)){
				experimentDAO.save(experiment);
				getNoticeDAO().save(notice);
				return true;
			}				
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteExperiment(Experiment experiment) {
		// TODO Auto-generated method stub
		try {
			experimentDAO.delete(experiment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List getAllExperiments(Course course) {
		// TODO Auto-generated method stub
		return experimentDAO.findByCourse(course.getId());
	}

	public Experiment getExperimentById(Integer id) {
		// TODO Auto-generated method stub
		return experimentDAO.findById(id);
	}

	@SuppressWarnings("unchecked")
	public List getExperimentsByChapter(Chapter chapter) {
		List<Experiment> experiments = experimentDAO.findByChapter(chapter);
		if (experiments.size() > 0)
			return experiments;
		else
			return null;
	}

	public boolean updateExperiment(Experiment experiment, Chapter chapter,File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + experiment.getFileLink();
		File file = new File(fileName);
		experiment.setChapter(chapter);
		experiment.setTime(Calendar.getInstance().getTime());
		String title = "修改实验指导《"+experiment.getTitle()+"》";
		String content = "<p>修改已有实验指导《"+experiment.getTitle()+"》，请同学们注意查阅。</p>";
		Notice notice = new Notice(chapter.getCourse(),title,content,new Date(),1);	
		try {			
			if (FileOperation.copy(upload, file)){
				experimentDAO.merge(experiment);
				getNoticeDAO().save(notice);
				return true;
			}				
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void setExperimentDAO(ExperimentDAO experimentDAO) {
		this.experimentDAO = experimentDAO;
	}

	public ExperimentDAO getExperimentDAO() {
		return experimentDAO;
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

}
