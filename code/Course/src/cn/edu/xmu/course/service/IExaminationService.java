package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * �γ̿���
 * @author Administrator
 *
 */
public interface IExaminationService {

	/**
	 * �������пγ̿���
	 * @param teacherCourse
	 * @return
	 */
	public List getAllExaminations(Course course);
	
	/**
	 * ���ҿγ̿���
	 * @param id
	 * @return
	 */
	public Examination getExaminationById(Integer id);
	
	/**
	 * ��ӿγ̿���
	 * @param examination
	 * @param teacherCourse
	 * @return
	 */
	public boolean addExamination(Examination examination, Course course);
	
	/**
	 * ���¿γ̿���
	 * @param examination
	 * @return
	 */
	public boolean updateExamination(Examination examination);
	
	/**
	 * ɾ���γ̿���
	 * @param examination
	 * @return
	 */
	public boolean deleteExamination(Examination examination);
}
