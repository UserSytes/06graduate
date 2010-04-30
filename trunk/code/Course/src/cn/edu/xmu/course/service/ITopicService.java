package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.Topic;
/**
 * �������԰�������Ľӿ�
 * @author ������
 * @author ������
 *
 */
public interface ITopicService {
	public List getAllTopics(Course course);
	public List getAllTopicsOrderByTime(Course course);
	public List getTopicsByTeacher(Teacher teacher,int day);
	public Topic getTopicById(Integer id);
	public boolean addTopic(Course course,Topic topic);
	public boolean updateTopic(Topic topic);
	public boolean deleteTopic(Topic topic);
	public List<Topic> getTopicByShcool(School school);
	public List<Topic> searchTopicByKey(String key, School school);


}
