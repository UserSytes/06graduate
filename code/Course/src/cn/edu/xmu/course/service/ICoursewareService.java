package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * �γ̰̽�
 * @author Administrator
 *
 */
public interface ICoursewareService {

	/**
	 * ���Ҹÿγ����е�ʵ��
	 * @param teacherCoures
	 * @return
	 */
	public List getAllCoursewares(TeacherCourse teacherCoures);
	
	/**
	 * ���Ҹ�Ŀ¼�����е�ϰ��
	 * @param chapter
	 * @return
	 */
	public List getCoursewaresByChapter(Chapter chapter);
	
	/**
	 * ��ø�ϰ��
	 * @param id
	 * @return
	 */
	public Courseware getCoursewareById(Integer id);
	
	/**
	 * ����µ�ϰ��
	 * @param Courseware
	 * @param chapter
	 * @return
	 */
	public boolean addCourseware(Courseware courseware, Chapter chapter);

	/**
	 * ���ϰ��
	 * @param courseware
	 * @param chapter
	 * @return
	 */
	public boolean updateCourseware(Courseware courseware, Chapter chapter);
	
	/**
	 * ɾ��ϰ��
	 * @param courseware
	 * @return
	 */
	public boolean deleteCourseware(Courseware courseware);
}
