package cn.edu.xmu.course.service;

import java.util.List;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Topic;

public interface ITopicService {
	public List getAllTopics(Course course);
	public Topic getTopicById(Integer id);
	public boolean addTopic(Course course,Topic topic);
	public boolean updateTopic(Topic topic);
	public boolean deleteTopic(Topic topic);
	
	public List<Topic> getTopicByShcool(School school);
	public List<Topic> searchTopicByKey(String key, School school);
}
