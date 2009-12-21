package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * 课程考卷
 * @author Administrator
 *
 */
public interface IExaminationService {

	/**
	 * 查找所有课程考卷
	 * @param teacherCourse
	 * @return
	 */
	public List getAllExaminations(Course course);
	
	/**
	 * 查找课程考卷
	 * @param id
	 * @return
	 */
	public Examination getExaminationById(Integer id);
	
	/**
	 * 添加课程考卷
	 * @param examination
	 * @param teacherCourse
	 * @return
	 */
	public boolean addExamination(Examination examination, Course course);
	
	/**
	 * 更新课程考卷
	 * @param examination
	 * @return
	 */
	public boolean updateExamination(Examination examination);
	
	/**
	 * 删除课程考卷
	 * @param examination
	 * @return
	 */
	public boolean deleteExamination(Examination examination);
}
