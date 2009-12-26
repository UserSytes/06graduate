package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.News;
import cn.edu.xmu.course.service.INewsService;

public class NewsAction extends BaseAction{

	private INewsService newsService;

	private News news;
	
	private List<News> newsList;
	
	private int newsId;

	/**
	 * 跳转到添加新闻
	 * @return
	 */
	public String goAddNews(){
		return SUCCESS;
	}
	
	/**
	 * 发布新闻
	 * @return
	 */
	public String addNews(){
		boolean result = newsService.addNews(news);
		if(result){
			addActionMessage("添加新闻成功！");
			return SUCCESS;
		}
		else
			return ERROR;
	}

	/**
	 * 获取所有新闻政策
	 * @return
	 */
	public String findAllNews(){
		newsList = newsService.findAllNews();
		if(newsList.size() == 0){
			addActionMessage("目前尚未发布任何新闻政策！");
			return ERROR;
		}else{
			return SUCCESS;
		}
	}
	
	/**
	 * 删除新闻政策
	 * @return
	 */
	public String deleteNews(){
		news = newsService.findNewsById(newsId);
		boolean result = newsService.deleteNews(news);
		if(result){
			addActionMessage("删除新闻成功！");
			return SUCCESS;
		}
		else
			return ERROR;
	}
	
	/**
	 * 查看新闻
	 * @return
	 */
	public String viewNews(){
		news = newsService.findNewsById(newsId);
		if(news != null){
			return SUCCESS;
		}
		else
			return ERROR;
	}
	
	public String goEditNews(){
		return SUCCESS;
	}
	
	/**
	 * 编辑新闻
	 * @return
	 */
	public String editNews(){
		boolean result = newsService.updateNews(news);
		if(result){
			addActionMessage("更新新闻成功！");
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public INewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	
}
