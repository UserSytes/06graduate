package cn.edu.xmu.course.service.impl;

import java.text.SimpleDateFormat;
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

	public List<Topic> getTopicByShcool(School school) {
		return topicDAO.getTopicByShcool(school);
	}

	/**
	 * ����������������
	 * 
	 * @param course
	 * @param name
	 * @return
	 */
	public PageBean searchTopicByName(Course course, String name,int pageSize, int page) {
		final String hql = "from Topic as model where model.name like '%"
				+ name + "%' and model.course.id=" + course.getId()
				+ " order by model.lastUpdate DESC"; // ��ѯ���
		int allRow = topicDAO.getAllRowCount(hql); // �ܼ�¼��
		int totalPage = PageBean.countTotalPage(pageSize, allRow); // ��ҳ��
		final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		final int length = pageSize; // ÿҳ��¼��
		final int currentPage = PageBean.countCurrentPage(page);
		List<Topic> list = topicDAO.queryForPage(hql, offset, length); //"һҳ"�ļ�¼
		// �ѷ�ҳ��Ϣ���浽Bean��
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	/**
	 * ���շ�������������
	 * 
	 * @param course
	 * @param authorName
	 * @return
	 */
	public PageBean searchTopicByAuthorName(Course course, String authorName,int pageSize, int page) {
		final String hql ="from Topic as model where model.authorName like '%"
			+ authorName + "%' and model.course.id=" + course.getId()+ " order by model.lastUpdate DESC"; // ��ѯ���
	int allRow = topicDAO.getAllRowCount(hql); // �ܼ�¼��
	int totalPage = PageBean.countTotalPage(pageSize, allRow); // ��ҳ��
	final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
	final int length = pageSize; // ÿҳ��¼��
	final int currentPage = PageBean.countCurrentPage(page);
	List<Topic> list = topicDAO.queryForPage(hql, offset, length); //"һҳ"�ļ�¼
	// �ѷ�ҳ��Ϣ���浽Bean��
	PageBean pageBean = new PageBean();
	pageBean.setPageSize(pageSize);
	pageBean.setCurrentPage(currentPage);
	pageBean.setAllRow(allRow);
	pageBean.setTotalPage(totalPage);
	pageBean.setList(list);
	pageBean.init();
	return pageBean;
	}

	/**
	 * �����������ƺͷ����������ۺ�����
	 * 
	 * @param course
	 * @param name
	 * @param authorName
	 * @return
	 */
	public PageBean searchtopicByNameAndAuthorName(Course course,
			String name, String authorName,int pageSize, int page) {
		final String hql ="from Topic as model where model.name like '%"
			+ name + "%' and model.authorName like '%" + authorName
			+ "%' and model.course.id=" + course.getId()+ " order by model.lastUpdate DESC"; // ��ѯ���
	int allRow = topicDAO.getAllRowCount(hql); // �ܼ�¼��
	int totalPage = PageBean.countTotalPage(pageSize, allRow); // ��ҳ��
	final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
	final int length = pageSize; // ÿҳ��¼��
	final int currentPage = PageBean.countCurrentPage(page);
	List<Topic> list = topicDAO.queryForPage(hql, offset, length); //"һҳ"�ļ�¼
	// �ѷ�ҳ��Ϣ���浽Bean��
	PageBean pageBean = new PageBean();
	pageBean.setPageSize(pageSize);
	pageBean.setCurrentPage(currentPage);
	pageBean.setAllRow(allRow);
	pageBean.setTotalPage(totalPage);
	pageBean.setList(list);
	pageBean.init();
	return pageBean;
	}

	/**
	 * �������ⷢ��ʱ������
	 * 
	 * @param course
	 * @param date
	 * @return
	 */
	public PageBean searchTopicByTime(Course course, Date date,int pageSize, int page) {
		String dftime=df.format(date);
		Date date2=new Date();
		date2.setDate(date.getDate());
		date2.setHours(23);
		date2.setMinutes(59);
		date2.setSeconds(59);
		String dftime2=df.format(date2);
		final String hql ="from Topic as model where model.time >= '"
			+ dftime + "' and model.time <= '"+dftime2+"' and model.course.id=" + course.getId()+ " order by model.lastUpdate DESC"; // ��ѯ���
	int allRow = topicDAO.getAllRowCount(hql); // �ܼ�¼��
	System.out.println("�ܼ�¼����"+allRow);
	int totalPage = PageBean.countTotalPage(pageSize, allRow); // ��ҳ��
	final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
	final int length = pageSize; // ÿҳ��¼��
	final int currentPage = PageBean.countCurrentPage(page);
	List<Topic> list = topicDAO.queryForPage(hql, offset, length); //"һҳ"�ļ�¼
	// �ѷ�ҳ��Ϣ���浽Bean��
	PageBean pageBean = new PageBean();
	pageBean.setPageSize(pageSize);
	pageBean.setCurrentPage(currentPage);
	pageBean.setAllRow(allRow);
	pageBean.setTotalPage(totalPage);
	pageBean.setList(list);
	pageBean.init();
	return pageBean;
	}

	/**
	 * �������ⷢ���˺�ʱ������
	 * 
	 * @param course
	 * @param authorName
	 * @param date
	 * @return
	 */
	public PageBean searchTopicByAuthorNameAndTime(Course course,
			String authorName, Date date,int pageSize, int page) {
		String dftime=df.format(date);
		Date date2=new Date();
		date2.setDate(date.getDate());
		date2.setHours(23);
		date2.setMinutes(59);
		date2.setSeconds(59);
		String dftime2=df.format(date2);
		final String hql ="from Topic as model where model.time >= '"
			+ dftime + "' and model.time <= '"+dftime2+"' and model.authorName like '%" + authorName
			+ "%' and model.course.id=" + course.getId()+ " order by model.lastUpdate DESC"; // ��ѯ���
	int allRow = topicDAO.getAllRowCount(hql); // �ܼ�¼��
	System.out.println("�ܼ�¼����"+allRow);
	int totalPage = PageBean.countTotalPage(pageSize, allRow); // ��ҳ��
	final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
	final int length = pageSize; // ÿҳ��¼��
	final int currentPage = PageBean.countCurrentPage(page);
	List<Topic> list = topicDAO.queryForPage(hql, offset, length); //"һҳ"�ļ�¼
	// �ѷ�ҳ��Ϣ���浽Bean��
	PageBean pageBean = new PageBean();
	pageBean.setPageSize(pageSize);
	pageBean.setCurrentPage(currentPage);
	pageBean.setAllRow(allRow);
	pageBean.setTotalPage(totalPage);
	pageBean.setList(list);
	pageBean.init();
	return pageBean;
	}

	/**
	 * �����������ơ������˺�ʱ������
	 * 
	 * @param course
	 * @param authorName
	 * @param date
	 * @return
	 */
	public PageBean searchTopicByNameAndAuthorNameAndTime(Course course,
			String name, String authorName, Date date,int pageSize, int page) {
		String dftime=df.format(date);
		Date date2=new Date();
		date2.setDate(date.getDate());
		date2.setHours(23);
		date2.setMinutes(59);
		date2.setSeconds(59);
		String dftime2=df.format(date2);
		final String hql ="from Topic as model where model.time >= '"
			+ dftime + "' and model.time <= '"+dftime2+"' and model.authorName like '%" + authorName
			+ "%' and model.name like '%" + name
			+ "%' and model.course.id=" + course.getId()+ " order by model.lastUpdate DESC"; // ��ѯ���
	int allRow = topicDAO.getAllRowCount(hql); // �ܼ�¼��
	System.out.println("�ܼ�¼����"+allRow);
	int totalPage = PageBean.countTotalPage(pageSize, allRow); // ��ҳ��
	final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
	final int length = pageSize; // ÿҳ��¼��
	final int currentPage = PageBean.countCurrentPage(page);
	List<Topic> list = topicDAO.queryForPage(hql, offset, length); //"һҳ"�ļ�¼
	// �ѷ�ҳ��Ϣ���浽Bean��
	PageBean pageBean = new PageBean();
	pageBean.setPageSize(pageSize);
	pageBean.setCurrentPage(currentPage);
	pageBean.setAllRow(allRow);
	pageBean.setTotalPage(totalPage);
	pageBean.setList(list);
	pageBean.init();
	return pageBean;
	}

	/**
	 * �����������ƺͷ���ʱ������
	 * 
	 * @param course
	 * @param name
	 * @param date
	 * @return
	 */
	public PageBean searchTopicByNameAndTime(Course course, String name,
			Date date,int pageSize, int page) {
		String dftime=df.format(date);
		Date date2=new Date();
		date2.setDate(date.getDate());
		date2.setHours(23);
		date2.setMinutes(59);
		date2.setSeconds(59);
		String dftime2=df.format(date2);
		final String hql ="from Topic as model where model.time >= '"
			+ dftime + "' and model.time <= '"+dftime2+"' and model.name like '%" + name
			+ "%' and model.course.id=" + course.getId()+ " order by model.lastUpdate DESC"; // ��ѯ���
	int allRow = topicDAO.getAllRowCount(hql); // �ܼ�¼��
	System.out.println("�ܼ�¼����"+allRow);
	int totalPage = PageBean.countTotalPage(pageSize, allRow); // ��ҳ��
	final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
	final int length = pageSize; // ÿҳ��¼��
	final int currentPage = PageBean.countCurrentPage(page);
	List<Topic> list = topicDAO.queryForPage(hql, offset, length); //"һҳ"�ļ�¼
	// �ѷ�ҳ��Ϣ���浽Bean��
	PageBean pageBean = new PageBean();
	pageBean.setPageSize(pageSize);
	pageBean.setCurrentPage(currentPage);
	pageBean.setAllRow(allRow);
	pageBean.setTotalPage(totalPage);
	pageBean.setList(list);
	pageBean.init();
	return pageBean;
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

	public PageBean queryForPage(Course course, int pageSize, int page) {
		final String hql = "from Topic topic where topic.course.id='"
				+ course.getId() + "' order by topic.lastUpdate DESC"; // ��ѯ���
		int allRow = topicDAO.getAllRowCount(hql); // �ܼ�¼��
		int totalPage = PageBean.countTotalPage(pageSize, allRow); // ��ҳ��
		final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		final int length = pageSize; // ÿҳ��¼��
		final int currentPage = PageBean.countCurrentPage(page);
		List<Topic> list = topicDAO.queryForPage(hql, offset, length); //"һҳ"�ļ�¼
		// �ѷ�ҳ��Ϣ���浽Bean��
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
