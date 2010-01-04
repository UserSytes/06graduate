package cn.edu.xmu.course.web.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import cn.edu.xmu.course.pojo.Attachment;
import cn.edu.xmu.course.pojo.News;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.INewsService;

/**
 * ���Ź���
 * 
 * @author Sky
 * 
 */
public class NewsAction extends BaseAction {

	private INewsService newsService;

	private News news;
	private List<News> newsList;
	private int newsId;
	private List<Attachment> attachmentList;

	private File[] myFile;// �õ��ļ�
	private String[] myFileContentType;
	private String[] myFileFileName;
	
	/**
	 * ��ת���������
	 * 
	 * @return
	 */
	public String goAddNews() {
		return SUCCESS;
	}

	/**
	 * ��������
	 * 
	 * @return
	 */
	public String addNews() {
		boolean result;
		if(myFile == null){
			result = newsService.addNewsWithoutAttachment(news);
		}else{
			result = newsService.addNews(news,myFile,myFileContentType, myFileFileName);
		}
		if (result) {
			addActionMessage("������ųɹ���");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��ȡ������������
	 * 
	 * @return
	 */
	public String findAllNews() {
		newsList = newsService.findAllNews();
		if (newsList.size() == 0) {
			addActionMessage("Ŀǰ��δ�����κ��������ߣ�");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * ɾ����������
	 * 
	 * @return
	 */
	public String deleteNews() {
		news = newsService.findNewsById(newsId);
		boolean result = newsService.deleteNews(news);
		if (result) {
			this.findAllNews();
			addActionMessage("ɾ�����ųɹ���");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * �鿴����
	 * 
	 * @return
	 */
	public String viewNews() {
		news = newsService.findNewsById(newsId);
		attachmentList = newsService.findAttachmentByNews(news);
		if (news != null) {
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * ��ת���޸�����
	 * 
	 * @return
	 */
	public String goEditNews() {
		System.out.print("����1��" + news.getId());
		news = newsService.findNewsById(news.getId());
		attachmentList = newsService.findAttachmentByNews(news);
		return SUCCESS;
	}

	/**
	 * �༭����
	 * 
	 * @return
	 */
	public String editNews() {
		boolean result = newsService.updateNews(news,myFile,myFileContentType, myFileFileName);
		if (result) {
			addActionMessage("�������ųɹ���");
			return SUCCESS;
		} else {
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

	public File[] getMyFile() {
		return myFile;
	}

	public void setMyFile(File[] myFile) {
		this.myFile = myFile;
	}

	public String[] getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String[] myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String[] getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String[] myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

}
