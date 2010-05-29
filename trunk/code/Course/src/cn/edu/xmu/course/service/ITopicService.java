package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.Topic;
/**
 * 负责留言板中主题的接口
 * @author 许子彦
 * @author 何申密
 *
 */
public interface ITopicService {
	
	/**
	 * 根据课程查找所有的留言主题
	 * @param course
	 * @return
	 */
	public List<Topic> getAllTopics(Course course);
	
	/**
	 * 根据教师查找所有的留言主题
	 * @param teacher
	 * @param day
	 * @return
	 */
	public List<Topic> getTopicsByTeacher(Teacher teacher,int day);
	
	/**
	 * 根据ID查找留言
	 * @param id
	 * @return
	 */
	public Topic getTopicById(Integer id);
	
	/**
	 * 添加新的主题 
	 * @param course
	 * @param topic
	 * @return
	 */
	public boolean addTopic(Course course,Topic topic);
	
	/**
	 * 更新一个主题 
	 * @param topic
	 * @return
	 */
	public boolean updateTopic(Topic topic);
	
	/**
	 * 删除主题 
	 * @param topic
	 * @return
	 */
	public boolean deleteTopic(Topic topic);
	
	/**
	 * 根据院获得主题列表
	 * @param school
	 * @return
	 */
	public List<Topic> getTopicByShcool(School school);

}
