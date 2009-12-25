package cn.edu.xmu.course.web.action;


import java.util.List;

import cn.edu.xmu.course.pojo.News;
import cn.edu.xmu.course.service.INewsService;
import cn.edu.xmu.course.service.impl.NewsService;

public class HomePageAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<News> newsList;
	private INewsService newsService;
	private int newsId;
	private News news;
	/**
	 * 新闻公布
	 * @return
	 */
    @SuppressWarnings("unchecked")
	public String newsDisplay(){
		newsList=newsService.findAllNews();
		if (newsList == null) {
			return ERROR;
		} else
			return "news";
	}

    public String enterNews(){
    	news=newsService.findNewsById(newsId);
		if (news == null) {
			return ERROR;
		} else
			return "newsdetail";
    }
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public INewsService getNewsService() {
		return newsService;
	}
	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public List<News> getNewsList() {
		return newsList;
	}


	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}


	public int getNewsId() {
		return newsId;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public News getNews() {
		return news;
	}
	
	

}
