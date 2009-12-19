package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * �γ�ʵ��
 * @author Administrator
 *
 */
public interface IExperimentService {

	/**
	 * ���Ҹÿγ����е�ʵ��
	 * @param teacherCoures
	 * @return
	 */
	public List getAllExperiments(TeacherCourse teacherCoures);
	
	/**
	 * ���Ҹ�Ŀ¼�����е�ϰ��
	 * @param chapter
	 * @return
	 */
	public List getExperimentsByChapter(Chapter chapter);
	
	/**
	 * ��ø�ϰ��
	 * @param id
	 * @return
	 */
	public Experiment getExperimentById(Integer id);
	
	/**
	 * ����µ�ϰ��
	 * @param experiment
	 * @param chapter
	 * @return
	 */
	public boolean addExperiment(Experiment experiment, Chapter chapter);

	/**
	 * ���ϰ��
	 * @param experiment
	 * @param chapter
	 * @return
	 */
	public boolean updateExperiment(Experiment experiment, Chapter chapter);
	
	/**
	 * ɾ��ϰ��
	 * @param experiment
	 * @return
	 */
	public boolean deleteExperiment(Experiment experiment);
}
