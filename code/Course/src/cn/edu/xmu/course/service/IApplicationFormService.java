package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.*;

/**
 * 申报表格
 * @author Administrator
 *
 */
public interface IApplicationFormService {

	/**
	 * 查找该课程的申报表格
	 * @param teacherCourse
	 * @return
	 */
	public ApplicationForm getApplicationForm(TeacherCourse teacherCourse);
	
	/**
	 * 添加课程申报表格
	 * @param applicationForm
	 * @param teacherCourse
	 * @return
	 */
	public boolean addApplicationForm(ApplicationForm applicationForm, TeacherCourse teacherCourse);
	
	/**
	 * 更新课程申报表格
	 * @param applicationForm
	 * @return
	 */
	public boolean updateApplicationForm(ApplicationForm applicationForm);
	
	/**
	 * 删除课程申报表格
	 * @param applicationForm
	 * @return
	 */
	public boolean deleteApplicationForm(ApplicationForm applicationForm);
	
}
