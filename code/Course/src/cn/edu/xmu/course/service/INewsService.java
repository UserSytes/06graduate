package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.News;

/**
 * 网站新闻发布
 * @author 郑冰凌
 * @author 赵海虹
 *
 */
public interface INewsService {

	/**
	 * 查找所有新闻
	 * @return
	 */
	public List findAllNews();
	
	/**
	 * 发布新闻
	 * @param news
	 * @return
	 */
	public boolean addNews(News news);
	
	/**
	 * 删除新闻
	 * @param news
	 * @return
	 */
	public boolean deleteNews(News news); 
	
	/**
	 * 更新新闻
	 * @param news
	 * @return
	 */
	public boolean updateNews(News news);
	
	/**
	 * 根据id查找新闻
	 * @param id
	 * @return
	 */
	public News findNewsById(int id);
}
