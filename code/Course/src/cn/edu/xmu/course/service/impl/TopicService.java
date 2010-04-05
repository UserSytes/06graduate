package cn.edu.xmu.course.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.commons.CalculateDate;
import cn.edu.xmu.course.commons.PageBean;
import cn.edu.xmu.course.dao.TopicDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.service.ITopicService;

public class TopicService implements ITopicService{
	private TopicDAO topicDAO;
	public boolean addTopic(Course course,Topic topic) {
		topic.setCourse(course);
		topic.setTime(new Date());
		topic.setCountPerson(0);
		topic.setCountReply(0);
		topic.setLastAnswer("无");
		try {
			topicDAO.save(topic);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteTopic(Topic topic) {
		try {
			topicDAO.delete(topic);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List getAllTopics(Course course) {
		// TODO Auto-generated method stub
		return topicDAO.findByCourse(course);
	}

	public Topic getTopicById(Integer id) {
		// TODO Auto-generated method stub
		return topicDAO.findById(id);
	}

	public boolean updateTopic(Topic topic) {
		// TODO Auto-generated method stub
		try {
			topicDAO.merge(topic);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public List getTopicsByTeacher(Teacher teacher,int day) {
		// TODO Auto-generated method stub
		if(day == 0)
			return topicDAO.getTopicByTeacher(teacher);
		else{
			Calendar date=CalculateDate.addDate(Calendar.getInstance(), (0-day));
			return topicDAO.getTopicByDate(teacher,CalculateDate.toDate(date.getTime()));
		}
	}

	public List<Topic> getTopicByShcool(School school){
		return topicDAO.getTopicByShcool(school);
	}
	/**
	 * 按照主题名称搜索
	 * @param course
	 * @param name
	 * @return
	 */
	public List<Topic> searchTopicByName(Course course,String name) {
		return topicDAO.findByName(course,name);
	}
	/**
	 * 按照发帖人名称搜索
	 * @param course
	 * @param authorName
	 * @return
	 */
	public List<Topic> searchTopicByAuthorName(Course course,String authorName) {
		return topicDAO.findByAuthorName(course,authorName);
	}
	/**
	 * 按照主题名称和发帖人名称综合搜索
	 * @param course
	 * @param name
	 * @param authorName
	 * @return
	 */
	public List<Topic> searchtopicByNameAndAuthorName(Course course,String name,
			String authorName) {
		return topicDAO.findByNameAndAuthorName(course,name, authorName);
	}
	/**
	 * 按照主题发帖时间搜索
	 * @param course
	 * @param date
	 * @return
	 */
	public List<Topic> searchTopicByTime(Course course,Date date) {
		return topicDAO.findByTime(course,date);
	}
	/**
	 * 按照主题发帖人和时间搜索
	 * @param course
	 * @param authorName
	 * @param date
	 * @return
	 */
	public List<Topic> searchTopicByAuthorNameAndTime(Course course,
			String authorName, Date date) {
		return topicDAO.findByAuthorNameAndTime(course, authorName, date);
	}
	/**
	 * 按照主题名称、发帖人和时间搜索
	 * @param course
	 * @param authorName
	 * @param date
	 * @return
	 */
	public List<Topic> searchTopicByNameAndAuthorNameAndTime(Course course,String name,
			String authorName, Date date) {
		return topicDAO.findByNameAndAuthorNameAndTime(course, name, authorName, date);
	}
	/**
	 * 按照主题名称和发帖时间搜索
	 * @param course
	 * @param name
	 * @param date
	 * @return
	 */
	public List<Topic> searchTopicByNameAndTime(Course course, String name,
			Date date) {
		return topicDAO.findByNameAndTime(course, name, date);
	}

	public List<Topic> searchTopicByKey(String key, School school){
		return topicDAO.searchTopicByKey(key, school);
	}
	
	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}

	public TopicDAO getTopicDAO() {
		return topicDAO;
	}

	public PageBean queryForPage(int pageSize, int page) {
		final String hql = "from Topic";        //查询语句
        int allRow = topicDAO.getAllRowCount(hql);    //总记录数
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数
        final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录
        final int length = pageSize;    //每页记录数
        final int currentPage = PageBean.countCurrentPage(page);
        List<Topic> list = topicDAO.queryForPage(hql,offset, length);        //"一页"的记录    
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
