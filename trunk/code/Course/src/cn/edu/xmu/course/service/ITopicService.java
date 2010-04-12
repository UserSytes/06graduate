package cn.edu.xmu.course.service;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.commons.PageBean;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.Topic;

public interface ITopicService {
	public List getAllTopics(Course course);
	public List getTopicsByTeacher(Teacher teacher,int day);
	public Topic getTopicById(Integer id);
	public boolean addTopic(Course course,Topic topic);
	public boolean updateTopic(Topic topic);
	public boolean deleteTopic(Topic topic);
	
	public List<Topic> getTopicByShcool(School school);
	public List<Topic> searchTopicByKey(String key, School school);
	public PageBean searchTopicByName(Course course, String name,int pageSize, int page);
	public PageBean searchTopicByAuthorName(Course course,String authorName,int pageSize, int page);
	public PageBean searchtopicByNameAndAuthorName(Course course,String name, String authorName,int pageSize, int page);
	public PageBean searchTopicByTime(Course course,Date date,int pageSize, int page);
	public PageBean searchTopicByNameAndTime(Course course,String name,Date date,int pageSize, int page);
	public PageBean searchTopicByAuthorNameAndTime(Course course,String authorName,Date date,int pageSize, int page);
	public PageBean searchTopicByNameAndAuthorNameAndTime(Course course,String name,String authorName,Date date,int pageSize, int page);
	 /**
     * 分页查询
     * @param currentPage 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    public PageBean queryForPage(Course course,int pageSize,int currentPage);

}
