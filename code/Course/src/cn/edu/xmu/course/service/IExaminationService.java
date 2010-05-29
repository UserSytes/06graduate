package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Examination;

/**
 * 课程考卷
 * @author 何申密
 * @author 许子彦
 *
 */
public interface IExaminationService {

	/**
	 * 查找所有课程考卷
	 * @param teacherCourse
	 * @return
	 */
	public List<Examination> getAllExaminations(Course course);
	
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
	public boolean addExamination(Examination examination, Course course, File upload);
	
	/**
	 * 更新课程考卷
	 * @param examination
	 * @return
	 */
	public boolean updateExamination(Examination examination, File upload);
	
	/**
	 * 删除课程考卷
	 * @param examination
	 * @return
	 */
	public boolean deleteExamination(Examination examination);
}
