package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.*;

/**
 * ��ѧĿ¼�༭
 * @author Administrator
 *
 */
public interface IChapterService {

	/**
	 * ��øÿγ�����Ŀ¼
	 * @param teacherCourse
	 * @return
	 */
	public List getAllChapter(TeacherCourse teacherCourse);
	
	/**
	 * ��ӿγ�Ŀ¼
	 * @param teacherCourse
	 * @param chapter
	 * @return
	 */
	public boolean addChapter(TeacherCourse teacherCourse, Chapter chapter);

	/**
	 * ���¿γ�Ŀ¼
	 * @param teacherCourse
	 * @param chapter
	 * @return
	 */
	public boolean updateChapter(Chapter chapter);
	
	/**
	 * ɾ���γ�Ŀ¼
	 * @param chapter
	 * @return
	 */
	public boolean addChapter(Chapter chapter);
	
	
}
