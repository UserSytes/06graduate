package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.NewsDAO;
import cn.edu.xmu.course.pojo.News;
import cn.edu.xmu.course.service.INewsService;

public class NewsService implements INewsService {

	private NewsDAO newsDAO;
	
	public boolean addNews(News news) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteNews(News news) {
		// TODO Auto-generated method stub
		try {
			newsDAO.delete(news);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List findAllNews() {
		// TODO Auto-generated method stub
		return null;
	}

	public News findNewsById(int id) {
		// TODO Auto-generated method stub
		return newsDAO.findById(id);
	}

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}

	public void setNewsDAO(NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

}
