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
	
	/**
	 * ���ݿγ̲������е���������
	 * @param course
	 * @return
	 */
	public List<Topic> getAllTopics(Course course);
	
	/**
	 * ���ݽ�ʦ�������е���������
	 * @param teacher
	 * @param day
	 * @return
	 */
	public List<Topic> getTopicsByTeacher(Teacher teacher,int day);
	
	/**
	 * ����ID��������
	 * @param id
	 * @return
	 */
	public Topic getTopicById(Integer id);
	
	/**
	 * ����µ����� 
	 * @param course
	 * @param topic
	 * @return
	 */
	public boolean addTopic(Course course,Topic topic);
	
	/**
	 * ����һ������ 
	 * @param topic
	 * @return
	 */
	public boolean updateTopic(Topic topic);
	
	/**
	 * ɾ������ 
	 * @param topic
	 * @return
	 */
	public boolean deleteTopic(Topic topic);
	
	/**
	 * ����Ժ��������б�
	 * @param school
	 * @return
	 */
	public List<Topic> getTopicByShcool(School school);

}
