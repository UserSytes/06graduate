package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.News;

/**
 * ��վ���ŷ���
 * @author ֣����
 *
 */
public interface INewsService {

	public List findAllNews();
	
	public boolean addNews(News news);
	
	public boolean deleteNews(News news); 
	
	public News findNewsById(int id);
}
