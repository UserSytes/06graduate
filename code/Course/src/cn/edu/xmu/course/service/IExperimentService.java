package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * 课程实验
 * @author Administrator
 *
 */
public interface IExperimentService {

	/**
	 * 查找该课程所有的实验
	 * @param teacherCoures
	 * @return
	 */
	public List getAllExperiments(Course course);
	
	/**
	 * 查找该目录下所有的习题
	 * @param chapter
	 * @return
	 */
	public List getExperimentsByChapter(Chapter chapter);
	
	/**
	 * 获得该习题
	 * @param id
	 * @return
	 */
	public Experiment getExperimentById(Integer id);
	
	/**
	 * 添加新的习题
	 * @param experiment
	 * @param chapter
	 * @return
	 */
	public boolean addExperiment(Experiment experiment, Chapter chapter);

	/**
	 * 添加习题
	 * @param experiment
	 * @param chapter
	 * @return
	 */
	public boolean updateExperiment(Experiment experiment, Chapter chapter);
	
	/**
	 * 删除习题
	 * @param experiment
	 * @return
	 */
	public boolean deleteExperiment(Experiment experiment);
}
