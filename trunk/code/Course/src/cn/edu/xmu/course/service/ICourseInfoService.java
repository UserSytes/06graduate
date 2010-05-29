package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseInfo;

/**
 * �༭�γ���Ϣ��������ѧ��٣��γ̼���
 * @author ������
 * @author ������
 *
 */
public interface ICourseInfoService {
	
	/**
	 * ���ҵ�ǰ�γ���Ϣ
	 * @param course
	 * @return
	 */
	public List<CourseInfo> getCourseInfosByCourse(Course course);
	
	/**
	 * ���ݿγ���ϢId���Ҹÿγ���Ϣ
	 * @param courseInfoId
	 * @return
	 */
	public CourseInfo getCourseInfoById(Integer courseInfoId);
	
	/**
	 * ��ӿγ���Ϣ
	 * @param courseInfo
	 * @param sort
	 * @return
	 */
	public boolean addCoureseInfo(CourseInfo courseInfo,Course course);

	/**
	 * ���¿γ���Ϣ
	 * @param courseInfo
	 * @param sort
	 * @return
	 */
	public boolean updateCourseInfo(CourseInfo courseInfo);
	
	/**
	 * ɾ���γ���Ϣ
	 * @param courseInfo
	 * @param sort
	 * @return
	 */
	public boolean deleteCourseInfo(CourseInfo courseInfo);
	/**
	 * ͨ���γ�Id���ҿγ̼��/���
	 * @param courseId
	 * @param sort
	 * @return
	 */
	public CourseInfo getCourseInfo(int courseId,int sort);
}
