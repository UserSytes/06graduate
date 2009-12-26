package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.News;

/**
 * ��վ���ŷ���
 * @author ֣����
 * @author �Ժ���
 *
 */
public interface INewsService {

	/**
	 * ������������
	 * @return
	 */
	public List findAllNews();
	
	/**
	 * ��������
	 * @param news
	 * @return
	 */
	public boolean addNews(News news);
	
	/**
	 * ɾ������
	 * @param news
	 * @return
	 */
	public boolean deleteNews(News news); 
	
	/**
	 * ��������
	 * @param news
	 * @return
	 */
	public boolean updateNews(News news);
	
	/**
	 * ����id��������
	 * @param id
	 * @return
	 */
	public News findNewsById(int id);
}
