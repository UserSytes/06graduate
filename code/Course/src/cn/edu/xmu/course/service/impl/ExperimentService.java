package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.ExperimentDAO;
import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Experiment;
import cn.edu.xmu.course.service.IExperimentService;

public class ExperimentService implements IExperimentService {
	private ExperimentDAO experimentDAO;
	public boolean addExperiment(Experiment experiment, Chapter chapter) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteExperiment(Experiment experiment) {
		// TODO Auto-generated method stub
		return false;
	}

	public List getAllExperiments(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	public Experiment getExperimentById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List getExperimentsByChapter(Chapter chapter) {
		List<Experiment> experiments=experimentDAO.findByChapter(chapter);
		if (experiments.size() > 0)
			return experiments;
		else
			return null;
	}

	public boolean updateExperiment(Experiment experiment, Chapter chapter) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setExperimentDAO(ExperimentDAO experimentDAO) {
		this.experimentDAO = experimentDAO;
	}

	public ExperimentDAO getExperimentDAO() {
		return experimentDAO;
	}

	

}
