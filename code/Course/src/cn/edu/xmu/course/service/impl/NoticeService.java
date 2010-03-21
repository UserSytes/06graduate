package cn.edu.xmu.course.service.impl;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.dao.NoticeDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.INoticeService;

public class NoticeService implements INoticeService {

	private NoticeDAO noticeDAO;

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

	public boolean deleteNotice(Notice notice) {
		// TODO Auto-generated method stub
		try {
			noticeDAO.delete(notice);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List getNoticeListByCourse(Course course) {
		// TODO Auto-generated method stub
		return noticeDAO.findByCourse(course);
	}

	public List getNoticeListByTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return noticeDAO.findByTeacher(teacher.getId());
	}
	
	public Notice getNoticeById(Integer id) {
		// TODO Auto-generated method stub
		return noticeDAO.findById(id);
	}

	public boolean updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		try {
			noticeDAO.merge(notice);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}



}
