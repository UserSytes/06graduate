package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.*;

/**
 * �걨���
 * @author Administrator
 *
 */
public interface IApplicationFormService {

	/**
	 * ���Ҹÿγ̵��걨���
	 * @param teacherCourse
	 * @return
	 */
	public ApplicationForm getApplicationForm(TeacherCourse teacherCourse);
	
	/**
	 * ��ӿγ��걨���
	 * @param applicationForm
	 * @param teacherCourse
	 * @return
	 */
	public boolean addApplicationForm(ApplicationForm applicationForm, TeacherCourse teacherCourse);
	
	/**
	 * ���¿γ��걨���
	 * @param applicationForm
	 * @return
	 */
	public boolean updateApplicationForm(ApplicationForm applicationForm);
	
	/**
	 * ɾ���γ��걨���
	 * @param applicationForm
	 * @return
	 */
	public boolean deleteApplicationForm(ApplicationForm applicationForm);
	
}
