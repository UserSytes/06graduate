package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.pojo.Teacher;

public interface INoticeService {

	/**
	 * ��ӿγ�֪ͨ����
	 * @param notice
	 * @param course
	 * @return
	 */
	public boolean addNotice(Notice notice, Course course);
	
	/**
	 * ���¿γ�֪ͨ����
	 * @param notice
	 * @return
	 */
	public boolean updateNotice(Notice notice, Course course);
	
	/**
	 * ɾ���γ�֪ͨ����
	 * @param notice
	 * @return
	 */
	public boolean deleteNotice(Notice notice);
	
	/**
	 * ���ݽ�ʦ���ҿγ�֪ͨ����
	 * @param teacher
	 * @return
	 */
	public List getNoticeListByTeacher(Teacher teacher);
	
	/**
	 * ���ݿγ̲��ҿγ�֪ͨ����
	 * @param course
	 * @return
	 */
	public List getNoticeListByCourse(Course course); 
	
	/**
	 * ����ID���ҿγ�֪ͨ����
	 * @param id
	 * @return
	 */
	public Notice getNoticeById(Integer id);
	/**
	 * ���������ҿγ̹���
	 * @param course
	 * @param sort
	 * @return
	 */
	public List getNoticeBySort(Course course,Integer sort);

	/**
	 * �������µ�7���γ�����
	 * @param course
	 * @return
	 */
	public List findLastestSevenNotices(Course course,int sort);
	
	/**
	 * �������µ�10���γ�֪ͨ
	 * @param course
	 * @return
	 */
	public List findLastestLeftNotices(Course course);
	

}
