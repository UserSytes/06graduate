package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.ExperimentDAO;
import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Courseware;
import cn.edu.xmu.course.pojo.Experiment;
import cn.edu.xmu.course.service.IExperimentService;

public class ExperimentService implements IExperimentService {
	private ExperimentDAO experimentDAO;

	public boolean addExperiment(Experiment experiment, Chapter chapter,
			File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + experiment.getFileLink();
		File file = new File(fileName);
		experiment.setChapter(chapter);
		experiment.setTime(Calendar.getInstance().getTime());
		try {			
			if (FileOperation.copy(upload, file)){
				experimentDAO.save(experiment);
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
		try {			
			if (FileOperation.copy(upload, file)){
				experimentDAO.merge(experiment);
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

}
