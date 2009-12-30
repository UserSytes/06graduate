package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * �γ�ϰ��
 * @author Administrator
 *
 */
public interface IExerciseService {

	/**
	 * ���Ҹÿγ����е�ϰ��
	 * @param teacherCoures
	 * @return
	 */
	public List getAllExercises(Course course);
	
	/**
	 * ���Ҹ�Ŀ¼�����е�ϰ��
	 * @param chapter
	 * @return
	 */
	public List getExercisesByChapter(Chapter chapter);
	
	/**
	 * ��ø�ϰ��
	 * @param id
	 * @return
	 */
	public Exercise getExerciseById(Integer id);
	
	/**
	 * ����µ�ϰ��
	 * @param exercise
	 * @param chapter
	 * @return
	 */
	public boolean addExercise(Exercise exercise, Chapter chapter, File upload);

	/**
	 * ���ϰ��
	 * @param exercise
	 * @param chapter
	 * @return
	 */
	public boolean updateExercise(Exercise exercise, Chapter chapter, File upload);
	
	/**
	 * ɾ��ϰ��
	 * @param exercise
	 * @return
	 */
	public boolean deleteExercise(Exercise exercise);
}
