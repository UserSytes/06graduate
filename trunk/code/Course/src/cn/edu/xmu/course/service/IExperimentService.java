package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Experiment;

/**
 * �γ�ʵ��
 * @author ������
 * @author ������
 * 
 */
public interface IExperimentService {

	/**
	 * ���Ҹÿγ����е�ʵ��
	 * 
	 * @param teacherCoures
	 * @return
	 */
	public List<Experiment> getAllExperiments(Course course);

	/**
	 * ���Ҹ�Ŀ¼�����е�ʵ��
	 * 
	 * @param chapter
	 * @return
	 */
	public List<Experiment> getExperimentsByChapter(Chapter chapter);

	/**
	 * ��ø�ʵ��
	 * 
	 * @param id
	 * @return
	 */
	public Experiment getExperimentById(Integer id);

	/**
	 * ����µ�ʵ��
	 * 
	 * @param experiment
	 * @param chapter
	 * @return
	 */
	public boolean addExperiment(Experiment experiment, Chapter chapter,
			File upload);

	/**
	 * ����ʵ��
	 * 
	 * @param experiment
	 * @param chapter
	 * @return
	 */
	public boolean updateExperiment(Experiment experiment, Chapter chapter,
			File upload);

	/**
	 * ɾ��ʵ��
	 * 
	 * @param experiment
	 * @return
	 */
	public boolean deleteExperiment(Experiment experiment);
}
