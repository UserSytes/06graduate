package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.pojo.Teacher;

public interface INoticeService {

	/**
	 * 添加课程通知公告
	 * @param notice
	 * @param course
	 * @return
	 */
	public boolean addNotice(Notice notice, Course course);
	
	/**
	 * 更新课程通知公告
	 * @param notice
	 * @return
	 */
	public boolean updateNotice(Notice notice, Course course);
	
	/**
	 * 删除课程通知公告
	 * @param notice
	 * @return
	 */
	public boolean deleteNotice(Notice notice);
	
	/**
	 * 根据教师查找课程通知公告
	 * @param teacher
	 * @return
	 */
	public List getNoticeListByTeacher(Teacher teacher);
	
	/**
	 * 根据课程查找课程通知公告
	 * @param course
	 * @return
	 */
	public List getNoticeListByCourse(Course course); 
	
	/**
	 * 根据ID查找课程通知公告
	 * @param id
	 * @return
	 */
	public Notice getNoticeById(Integer id);
}
