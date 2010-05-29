package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.AttachmentDAO;
import cn.edu.xmu.course.dao.NewsDAO;
import cn.edu.xmu.course.pojo.Attachment;
import cn.edu.xmu.course.pojo.News;
import cn.edu.xmu.course.service.INewsService;

/**
 * 此类负责管理新闻政策
 * @author 郑冰凌
 *
 */
public class NewsService implements INewsService {

	private NewsDAO newsDAO;
	private AttachmentDAO attachmentDAO;
	
	private static final int BUFFER_SIZE = 16 * 1024;
	
	/*
	 * 添加无附件新闻(non-Javadoc)
	 * @see cn.edu.xmu.course.service.INewsService#addNewsWithoutAttachment(cn.edu.xmu.course.pojo.News)
	 */
	public boolean addNewsWithoutAttachment(News news){
		Date nowDate = new Date();
		news.setTime(nowDate);
		try{
			newsDAO.save(news);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * 新建附件
	 * @param news
	 * @param myFile
	 * @param myFileContentType
	 * @param myFileFileName
	 * @return
	 */
	public boolean createAttachments(News news, File[] myFile, String[] myFileContentType, String[] myFileFileName){
		// 上传附件
		try {
			/*
			 * 开始上传多个附件
			 */
			for (int i = 0; i < myFileFileName.length; i++) {
				String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
				String fileName = path + "/newsUpload/" +new Date().getTime()+"_"+ myFileFileName[i];
				File file = new File(fileName);

				if (!FileOperation.copy(myFile[i], file))
					return false;				
				Attachment attachment = new Attachment();
				attachment.setFileLink("/newsUpload/" +new Date().getTime()+"_"+ myFileFileName[i]);
				attachment.setFilename(myFileFileName[i]);
				attachment.setNews(news);
				boolean result = this.saveAttachment(attachment);
				if(!result){
					return false;
				}
	
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/*
	 * 查找最新的十条新闻(non-Javadoc)
	 * @see cn.edu.xmu.course.service.INewsService#findLastestTenNews()
	 */
	public List findLastestTenNews() {
		return newsDAO.findLastestTenNews();
	}
	
	/*
	 * 添加附件新闻(non-Javadoc)
	 * @see cn.edu.xmu.course.service.INewsService#addNews(cn.edu.xmu.course.pojo.News, java.io.File[], java.lang.String[], java.lang.String[])
	 */
	public boolean addNews(News news, File[] myFile, String[] myFileContentType, String[] myFileFileName) {
		// TODO Auto-generated method stub
		Date nowDate = new Date();
		news.setTime(nowDate);
		try{
			newsDAO.save(news);
		}catch(Exception e){
			return false;
		}
		return this.createAttachments(news, myFile, myFileContentType, myFileFileName);
	}
	
	/**
	 * 保存附件
	 * @param attachment
	 * @return
	 */
	public boolean saveAttachment(Attachment attachment){
		try{
			attachmentDAO.save(attachment);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/*
	 * 更新新闻(non-Javadoc)
	 * @see cn.edu.xmu.course.service.INewsService#updateNews(cn.edu.xmu.course.pojo.News, java.io.File[], java.lang.String[], java.lang.String[])
	 */
	public boolean updateNews(News news, File[] myFile, String[] myFileContentType, String[] myFileFileName){
		Date nowDate = new Date();
		news.setLastEditTime(nowDate);
		try{
			this.deleteAttachment(news);
			newsDAO.merge(news);
		}catch(Exception e){
			return false;
		}
		return this.createAttachments(news, myFile, myFileContentType, myFileFileName);	
	}
	
	/*
	 * 更新无附件新闻(non-Javadoc)
	 * @see cn.edu.xmu.course.service.INewsService#updateNewsWithoutAttachment(cn.edu.xmu.course.pojo.News)
	 */
	public boolean updateNewsWithoutAttachment(News news){
		Date nowDate = new Date();
		news.setLastEditTime(nowDate);
		try{
			newsDAO.merge(news);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * 删除某新闻的所有附加
	 * @param news
	 * @return
	 */
	public boolean deleteAttachment(News news){
		List<Attachment> attachments = this.findAttachmentByNews(news);
		for(Attachment a: attachments){
			try{
				attachmentDAO.delete(a);
			}catch(Exception e){
				return false;
			}
		}
		return true;
	}
	
	/*
	 * 根据新闻查找附件(non-Javadoc)
	 * @see cn.edu.xmu.course.service.INewsService#findAttachmentByNews(cn.edu.xmu.course.pojo.News)
	 */
	public List<Attachment> findAttachmentByNews(News news){
		return attachmentDAO.findByProperty("news", news);
	}
	
	/*
	 * 删除新闻(non-Javadoc)
	 * @see cn.edu.xmu.course.service.INewsService#deleteNews(cn.edu.xmu.course.pojo.News)
	 */
	public boolean deleteNews(News news) {
		// TODO Auto-generated method stub
		try {
			this.deleteAttachment(news);
			newsDAO.delete(news);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * 更新新闻
	 */
	public boolean updateNews(News news){
		try {
			newsDAO.merge(news);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/*
	 * 查找所有新闻(non-Javadoc)
	 * @see cn.edu.xmu.course.service.INewsService#findAllNews()
	 */
	public List findAllNews() {
		// TODO Auto-generated method stub
		return newsDAO.findAll();
	}

	/*
	 * 根据Id查找新闻(non-Javadoc)
	 * @see cn.edu.xmu.course.service.INewsService#findNewsById(int)
	 */
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

	public AttachmentDAO getAttachmentDAO() {
		return attachmentDAO;
	}

	public void setAttachmentDAO(AttachmentDAO attachmentDAO) {
		this.attachmentDAO = attachmentDAO;
	}

}
