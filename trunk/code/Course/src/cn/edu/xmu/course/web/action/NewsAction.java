package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Attachment;
import cn.edu.xmu.course.pojo.News;
import cn.edu.xmu.course.service.INewsService;

/**
 * 新闻管理
 * @author 郑冰凌
 * 
 */
public class NewsAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5013181121384776084L;

	private INewsService newsService;	//管理新闻的接口

	private News news;	//新闻
	private List<News> newsList;	//新闻列表
	private int newsId;	//新闻id
	private List<Attachment> attachmentList;	//附件列表
	
	private File[] myFile;// 上传的附件
	private String[] myFileContentType;	//附件类型
	private String[] myFileFileName;	//附件名称
	
	
	/**
	 * 跳转到添加新闻
	 * 
	 * @return
	 */
	public String goAddNews() {
		return SUCCESS;
	}

	/**
	 * 发布新闻
	 * 
	 * @return
	 */
	public String addNews() {
		boolean result;
		news.setCount(0);
		if(myFile == null){
			result = newsService.addNewsWithoutAttachment(news);
		}else{
			result = newsService.addNews(news,myFile,myFileContentType, myFileFileName);
		}
		if (result) {
			addActionMessage("添加新闻成功！");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 获取所有新闻政策
	 * 
	 * @return
	 */
	public String findAllNews() {
		newsList = newsService.findAllNews();
		if (newsList.size() == 0) {
			addActionMessage("目前尚未发布任何新闻政策！");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	/**
	 * 删除新闻政策
	 * 
	 * @return
	 */
	public String deleteNews() {
		news = newsService.findNewsById(newsId);
		boolean result = newsService.deleteNews(news);
		if (result) {
			this.findAllNews();
			addActionMessage("删除新闻成功！");
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 查看新闻
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
	 * 跳转到修改新闻
	 * 
	 * @return
	 */
	public String goEditNews() {
		news = newsService.findNewsById(news.getId());
		attachmentList = newsService.findAttachmentByNews(news);
		return SUCCESS;
	}

	/**
	 * 编辑新闻
	 * 
	 * @return
	 */
	public String editNews() {
		boolean result  = false;
		
		if(myFile == null){
			result = newsService.updateNewsWithoutAttachment(news);
		}else{
		    result = newsService.updateNews(news,myFile,myFileContentType, myFileFileName);
		}
		if (result) {
			addActionMessage("更新新闻成功！");
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
