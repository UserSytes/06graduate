package cn.edu.xmu.course.service.impl;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.dao.NoticeDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.INoticeService;

/**
 * 负责通知公告的接口
 * 
 * @author 许子彦
 * @author 何申密
 * 
 */
public class NoticeService implements INoticeService {

	private NoticeDAO noticeDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.INoticeService#addNotice(cn.edu.xmu.course.
	 * pojo.Notice, cn.edu.xmu.course.pojo.Course)
	 */
	public boolean addNotice(Notice notice, Course course) {
		// TODO Auto-generated method stub
		notice.setCourse(course);
		notice.setTime(new Date());
		try {
			noticeDAO.save(notice);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.INoticeService#deleteNotice(cn.edu.xmu.course
	 * .pojo.Notice)
	 */
	public boolean deleteNotice(Notice notice) {
		// TODO Auto-generated method stub
		try {
			noticeDAO.delete(notice);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.INoticeService#getNoticeBySort(cn.edu.xmu.course
	 * .pojo.Course, java.lang.Integer)
	 */
	public List<Notice> getNoticeBySort(Course course, Integer sort) {
		return noticeDAO.findByCourseAndSort(course.getId(), sort);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.INoticeService#getNoticeListByCourse(cn.edu
	 * .xmu.course.pojo.Course)
	 */
	public List<Notice> getNoticeListByCourse(Course course) {
		// TODO Auto-generated method stub
		return noticeDAO.findByCourse(course);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.INoticeService#getNoticeListByTeacher(cn.edu
	 * .xmu.course.pojo.Teacher)
	 */
	public List<Notice> getNoticeListByTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return noticeDAO.findByTeacher(teacher.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.INoticeService#getNoticeById(java.lang.Integer)
	 */
	public Notice getNoticeById(Integer id) {
		// TODO Auto-generated method stub
		return noticeDAO.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.INoticeService#updateNotice(cn.edu.xmu.course
	 * .pojo.Notice, cn.edu.xmu.course.pojo.Course)
	 */
	public boolean updateNotice(Notice notice, Course course) {
		// TODO Auto-generated method stub
		notice.setCourse(course);
		notice.setTime(new Date());
		try {
			noticeDAO.merge(notice);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.INoticeService#findLastestSevenNotices(cn.edu
	 * .xmu.course.pojo.Course, int)
	 */
	public List<Notice> findLastestSevenNotices(Course course, int sort) {
		return noticeDAO.findLastestSevenNotices(course, sort);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.INoticeService#findLastestLeftNotices(cn.edu
	 * .xmu.course.pojo.Course)
	 */
	public List findLastestLeftNotices(Course course) {
		// TODO Auto-generated method stub
		return noticeDAO.findLastestLeftNotices(course);
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}
}
