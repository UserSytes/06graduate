package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Experiment;

/**
 * 课程实验
 * @author 何申密
 * @author 许子彦
 * 
 */
public interface IExperimentService {

	/**
	 * 查找该课程所有的实验
	 * 
	 * @param teacherCoures
	 * @return
	 */
	public List<Experiment> getAllExperiments(Course course);

	/**
	 * 查找该目录下所有的实验
	 * 
	 * @param chapter
	 * @return
	 */
	public List<Experiment> getExperimentsByChapter(Chapter chapter);

	/**
	 * 获得该实验
	 * 
	 * @param id
	 * @return
	 */
	public Experiment getExperimentById(Integer id);

	/**
	 * 添加新的实验
	 * 
	 * @param experiment
	 * @param chapter
	 * @return
	 */
	public boolean addExperiment(Experiment experiment, Chapter chapter,
			File upload);

	/**
	 * 更新实验
	 * 
	 * @param experiment
	 * @param chapter
	 * @return
	 */
	public boolean updateExperiment(Experiment experiment, Chapter chapter,
			File upload);

	/**
	 * 删除实验
	 * 
	 * @param experiment
	 * @return
	 */
	public boolean deleteExperiment(Experiment experiment);
}
