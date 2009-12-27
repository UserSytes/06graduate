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
	 * ��ת����������
	 * @return
	 */
	public String goAddNews(){
		return SUCCESS;
	}
	
	/**
	 * ��������
	 * @return
	 */
	public String addNews(){
		boolean result = newsService.addNews(news);
		if(result){
			addActionMessage("�������ųɹ���");
			return SUCCESS;
		}
		else
			return ERROR;
	}

	/**
	 * ��ȡ������������
	 * @return
	 */
	public String findAllNews(){
		newsList = newsService.findAllNews();
		if(newsList.size() == 0){
			addActionMessage("Ŀǰ��δ�����κ��������ߣ�");
			return ERROR;
		}else{
			return SUCCESS;
		}
	}
	
	/**
	 * ɾ����������
	 * @return
	 */
	public String deleteNews(){
		news = newsService.findNewsById(newsId);
		boolean result = newsService.deleteNews(news);
		if(result){
			addActionMessage("ɾ�����ųɹ���");
			return SUCCESS;
		}
		else
			return ERROR;
	}
	
	/**
	 * �鿴����
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
	 * �༭����
	 * @return
	 */
	public String editNews(){
		boolean result = newsService.updateNews(news);
		if(result){
			addActionMessage("�������ųɹ���");
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