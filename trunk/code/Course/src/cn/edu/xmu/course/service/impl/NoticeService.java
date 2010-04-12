package cn.edu.xmu.course.service.impl;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.commons.PageBean;
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
	public List getNoticeBySort(Course course, Integer sort) {
		return noticeDAO.findByCourseAndSort(course.getId(), sort);
	}
	
	public Notice findLastestNotice(Course course) {
		List<Notice> list=noticeDAO.findByCourseAndSort(course.getId(), 1);
		if(list.size()==0)
			return null;
		else 
			return list.get(0);
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

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

	public List findLastestFiveNews(Course course,int sort) {
		return noticeDAO.findLastestFiveNews(course,sort);
	}

	public PageBean queryForPage(Course course, Integer sort, int pageSize, int page) {
		final String hql = "select notice from Notice notice where notice.course.id='" + course.getId()
							+ "' and sort='" + sort + "' order by notice.time DESC";        //查询语句
        int allRow = noticeDAO.getAllRowCount(hql);    //总记录数
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数
        final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录
        final int length = pageSize;    //每页记录数
        final int currentPage = PageBean.countCurrentPage(page);
        List<Notice> list = noticeDAO.queryForPage(hql,offset, length);        //"一页"的记录    
        //把分页信息保存到Bean中
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);    
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(allRow);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(list);
        pageBean.init();
        return pageBean;
	}

	



}
