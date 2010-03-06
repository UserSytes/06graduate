package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.TopicDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.service.ITopicService;

public class TopicService implements ITopicService{
	private TopicDAO topicDAO;
	public boolean addTopic(Course course,Topic topic) {
		topic.setCourse(course);
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

	public List<Topic> getTopicByShcool(School school){
		return topicDAO.getTopicByShcool(school);
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

}
