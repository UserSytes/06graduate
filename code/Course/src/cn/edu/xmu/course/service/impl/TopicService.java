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

/**
 * 负责留言板中主题的接口
 * 
 * @author 许子彦
 * @author 何申密
 * 
 */
public class TopicService implements ITopicService {
	private TopicDAO topicDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITopicService#addTopic(cn.edu.xmu.course.pojo
	 * .Course, cn.edu.xmu.course.pojo.Topic)
	 */
	public boolean addTopic(Course course, Topic topic) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITopicService#deleteTopic(cn.edu.xmu.course
	 * .pojo.Topic)
	 */
	public boolean deleteTopic(Topic topic) {
		try {
			topicDAO.delete(topic);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITopicService#getAllTopics(cn.edu.xmu.course
	 * .pojo.Course)
	 */
	public List<Topic> getAllTopics(Course course) {
		// TODO Auto-generated method stub
		return topicDAO.findByCourse(course);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITopicService#getTopicById(java.lang.Integer)
	 */
	public Topic getTopicById(Integer id) {
		// TODO Auto-generated method stub
		return topicDAO.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITopicService#updateTopic(cn.edu.xmu.course
	 * .pojo.Topic)
	 */
	public boolean updateTopic(Topic topic) {
		// TODO Auto-generated method stub
		try {
			topicDAO.merge(topic);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITopicService#getTopicsByTeacher(cn.edu.xmu
	 * .course.pojo.Teacher, int)
	 */
	public List<Topic> getTopicsByTeacher(Teacher teacher, int day) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.ITopicService#getTopicByShcool(cn.edu.xmu.course
	 * .pojo.School)
	 */
	public List<Topic> getTopicByShcool(School school) {
		return topicDAO.getTopicByShcool(school);
	}

	public List<Topic> searchTopicByKey(String key, School school) {
		return topicDAO.searchTopicByKey(key, school);
	}

	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}

	public TopicDAO getTopicDAO() {
		return topicDAO;
	}

}
