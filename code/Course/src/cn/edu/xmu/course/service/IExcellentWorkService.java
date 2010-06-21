package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.ExcellentWork;

public interface IExcellentWorkService {
	/**
	 * ����������ҵ
	 * @param course
	 * @return
	 */
	public List<ExcellentWork> getAllExcellentWorks(Course course);
	/**
	 * ��ø�ϰ��
	 * @param id
	 * @return
	 */
	public ExcellentWork getExcellentWorkById(Integer id);
	/**
	 * ����µ�������ҵ
	 * @param exercise
	 * @param chapter
	 * @return
	 */
	public boolean addExcellentWork(ExcellentWork excellentWork, Course course,File upload);

	/**
	 * ����������ҵ
	 * @param exercise
	 * @param chapter
	 * @return
	 */
	public boolean updateExcellentWork(ExcellentWork excellentWork, Course course,File upload);
	
	/**
	 * ɾ��������ҵ
	 * @param exercise
	 * @return
	 */
	public boolean deleteExcellentWork(ExcellentWork excellentWork);
}
