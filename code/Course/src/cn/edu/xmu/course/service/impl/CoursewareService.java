package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.CoursewareDAO;
import cn.edu.xmu.course.dao.NoticeDAO;
import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Courseware;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.service.ICoursewareService;

public class CoursewareService implements ICoursewareService {

	private CoursewareDAO coursewareDAO;
	private NoticeDAO noticeDAO;

	public boolean addCourseware(Courseware courseware, Chapter chapter,
			File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + courseware.getFileLink();
		File file = new File(fileName);
		courseware.setChapter(chapter);
		courseware.setTime(Calendar.getInstance().getTime());
		String title = "添加课件《"+courseware.getTitle()+"》";
		String content = "<p>添加最新课件《"+courseware.getTitle()+"》，请同学们注意查阅。</p>";
		Notice notice = new Notice(chapter.getCourse(),title,content,new Date(),1);	
		try {			
			if (FileOperation.copy(upload, file)){
				coursewareDAO.save(courseware);
				noticeDAO.save(notice);
				return true;
			}				
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteCourseware(Courseware courseware) {
		// TODO Auto-generated method stub
		try {
			coursewareDAO.delete(courseware);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List getAllCoursewares(Course course) {
		// TODO Auto-generated method stub
		return coursewareDAO.findByCourse(course.getId());
	}

	public Courseware getCoursewareById(Integer id) {
		// TODO Auto-generated method stub
		return coursewareDAO.findById(id);
	}

	public List getCoursewaresByChapter(Chapter chapter) {
		// TODO Auto-generated method stub
		List<Courseware> coursewareList=coursewareDAO.findByChapter(chapter);
		if (coursewareList.size() > 0)
			return coursewareList;
		else
			return null;
	}

	public boolean updateCourseware(Courseware courseware, Chapter chapter,
			File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + courseware.getFileLink();
		File file = new File(fileName);
		courseware.setChapter(chapter);
		courseware.setTime(Calendar.getInstance().getTime());
		String title = "修改课件《"+courseware.getTitle()+"》";
		String content = "<p>修改已有课件《"+courseware.getTitle()+"》，请同学们注意查阅。</p>";
		Notice notice = new Notice(chapter.getCourse(),title,content,new Date(),1);	
		try {			
			if (FileOperation.copy(upload, file)){
				coursewareDAO.merge(courseware);
				noticeDAO.save(notice);
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void setCoursewareDAO(CoursewareDAO coursewareDAO) {
		this.coursewareDAO = coursewareDAO;
	}

	public CoursewareDAO getCoursewareDAO() {
		return coursewareDAO;
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

}
