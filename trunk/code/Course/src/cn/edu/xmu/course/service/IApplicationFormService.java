package cn.edu.xmu.course.service;

import java.io.File;
import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;

/**
 * �걨���
 * @author ������
 * @author ������
 *
 */
public interface IApplicationFormService {

	/**
	 * ���Ҹÿγ̵��걨���
	 * @param teacherCourse
	 * @return
	 */
	public ApplicationForm getApplicationForm(int courseId);
	
	/**
	 * ��ӿγ��걨���
	 * @param applicationForm
	 * @param teacherCourse
	 * @return
	 */
	public boolean addApplicationForm(ApplicationForm applicationForm, Course course,File upload);
	
	/**
	 * ���¿γ��걨���
	 * @param applicationForm
	 * @return
	 */
	public boolean updateApplicationForm(ApplicationForm applicationForm,File upload);
	
	/**
	 * ɾ���γ��걨���
	 * @param applicationForm
	 * @return
	 */
	public boolean deleteApplicationForm(ApplicationForm applicationForm);
	
}
