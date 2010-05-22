package cn.edu.xmu.course.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.commons.CalculateDate;
import cn.edu.xmu.course.dao.TopicDAO;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.service.ITopicService;

public class TopicService implements ITopicService {
	private TopicDAO topicDAO;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public boolean addTopic(Course course, Topic topic) {
		topic.setCourse(course);
		topic.setTime(new Date());
		topic.setCountPerson(0);
		topic.setCountReply(0);
		topic.setLastAnswer("��");
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

	public List getTopicsByTeacher(Teacher teacher, int day) {
		// TODO Auto-generated method stub
		if (day == 0)
			return topicDAO.getTopicByTeacher(teacher);
		else {
			Calendar date = CalculateDate.addDate(Calendar.getInstance(),
					(0 - day));
			return topicDAO.getTopicByDate(teacher, CalculateDate.toDate(date
					.getTime()));
		}
	}

	public List getTopicByShcool(School school) {
		return topicDAO.getTopicByShcool(school);
	}

	public List searchTopicByKey(String key, School school) {
		return topicDAO.searchTopicByKey(key, school);
	}

	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}

	public TopicDAO getTopicDAO() {
		return topicDAO;
	}




}
