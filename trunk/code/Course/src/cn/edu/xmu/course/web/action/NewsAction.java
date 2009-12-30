package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.pojo.Attachment;
import cn.edu.xmu.course.pojo.News;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.INewsService;
/**
 * ���Ź���
 * @author Sky
 *
 */
public class NewsAction extends BaseAction{

	private INewsService newsService;

	private News news;
	
	private List<News> newsList;
	
	private int newsId;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	
	/**
	 * ��ת���������
	 * @return
	 */
	public String goAddNews(){
		return SUCCESS;
	}
	
	/**
	 * ���ϴ��ļ�����������
	 * 
	 * @return
	 */
	private String refactorFileLink() {
		Teacher teacher = super.getTeacher();
		String fileLink = teacher.getUserInfo().getName() + "/"
				+ new Date().getTime() + "_" + uploadFileName;
		return fileLink;
	}
	
	/**
	 * ��������
	 * @return
	 */
	public String addNews(){
		Date nowDate = new Date();
		news.setTime(nowDate);
		
		File file = null;
		Attachment a = new Attachment();
		if (upload != null) {
			String path = ServletActionContext.getServletContext().getRealPath(
					"/upload/news");
			String fileName = path + "/" + this.refactorFileLink();
			file = new File(fileName);
			a.setFileLink(this.refactorFileLink());
			a.setFilename(uploadFileName);
			a.setNews(news);
		}	
		
		boolean result = newsService.addNews(news);
		if(result){
			addActionMessage("������ųɹ���");
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
			this.findAllNews();
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
	
	/**
	 * ��ת���޸�����
	 * @return
	 */
	public String goEditNews(){
		System.out.print("����1��"+news.getId());
		news = newsService.findNewsById(news.getId());
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
