package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.ExcellentWork;

public interface IExcellentWorkService {
	/**
	 * 查找优秀作业
	 * @param course
	 * @return
	 */
	public List<ExcellentWork> getAllExcellentWorks(Course course);
	/**
	 * 获得该习题
	 * @param id
	 * @return
	 */
	public ExcellentWork getExcellentWorkById(Integer id);
	/**
	 * 添加新的优秀作业
	 * @param exercise
	 * @param chapter
	 * @return
	 */
	public boolean addExcellentWork(ExcellentWork excellentWork, Course course,File upload);

	/**
	 * 更新优秀作业
	 * @param exercise
	 * @param chapter
	 * @return
	 */
	public boolean updateExcellentWork(ExcellentWork excellentWork, Course course,File upload);
	
	/**
	 * 删除优秀作业
	 * @param exercise
	 * @return
	 */
	public boolean deleteExcellentWork(ExcellentWork excellentWork);
}
