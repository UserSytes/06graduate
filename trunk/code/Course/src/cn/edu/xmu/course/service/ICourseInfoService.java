package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.*;

/**
 * �༭�γ���Ϣ��������ѧ��٣��γ̼���
 * @author Administrator
 *
 */
public interface ICourseInfoService {
	
	/**
	 * ��ȡ���ſγ̵���Ϣ
	 * @param course
	 * @param sort ���ͣ���ٻ��߼�飩
	 * @return
	 */
	public CourseInfo getCourseInfo(Course course, int sort);
	
	/**
	 * ��ӿγ���Ϣ
	 * @param courseInfo
	 * @param sort
	 * @return
	 */
	public boolean addCoureseInfo(CourseInfo courseInfo, int sort);

	/**
	 * ���¿γ���Ϣ
	 * @param courseInfo
	 * @param sort
	 * @return
	 */
	public boolean updateCourseInfo(CourseInfo courseInfo, int sort);
	
	/**
	 * ɾ���γ���Ϣ
	 * @param courseInfo
	 * @param sort
	 * @return
	 */
	public boolean deleteCourseInfo(CourseInfo courseInfo, int sort);
	/**
	 * ͨ���γ�Id���ҿγ̼��/���
	 * @param courseId
	 * @param sort
	 * @return
	 */
	public CourseInfo getCourseInfo(int courseId,int sort);
}
