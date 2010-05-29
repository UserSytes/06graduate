package cn.edu.xmu.course.service;

import java.io.File;
import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;

/**
 * 申报表格
 * @author 何申密
 * @author 许子彦
 *
 */
public interface IApplicationFormService {

	/**
	 * 查找该课程的申报表格
	 * @param teacherCourse
	 * @return
	 */
	public ApplicationForm getApplicationForm(int courseId);
	
	/**
	 * 添加课程申报表格
	 * @param applicationForm
	 * @param teacherCourse
	 * @return
	 */
	public boolean addApplicationForm(ApplicationForm applicationForm, Course course,File upload);
	
	/**
	 * 更新课程申报表格
	 * @param applicationForm
	 * @return
	 */
	public boolean updateApplicationForm(ApplicationForm applicationForm,File upload);
	
	/**
	 * 删除课程申报表格
	 * @param applicationForm
	 * @return
	 */
	public boolean deleteApplicationForm(ApplicationForm applicationForm);
	
}
