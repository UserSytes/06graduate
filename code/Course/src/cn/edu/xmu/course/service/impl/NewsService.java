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
 * ���ฺ�������������
 * @author ֣����
 *
 */
public class NewsService implements INewsService {

	private NewsDAO newsDAO;
	private AttachmentDAO attachmentDAO;
	
	private static final int BUFFER_SIZE = 16 * 1024;
	
	/*
	 * ����޸�������(non-Javadoc)
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
	 * �½�����
	 * @param news
	 * @param myFile
	 * @param myFileContentType
	 * @param myFileFileName
	 * @return
	 */
	public boolean createAttachments(News news, File[] myFile, String[] myFileContentType, String[] myFileFileName){
		// �ϴ�����
		try {
			/*
			 * ��ʼ�ϴ��������
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
	 * �������µ�ʮ������(non-Javadoc)
	 * @see cn.edu.xmu.course.service.INewsService#findLastestTenNews()
	 */
	public List findLastestTenNews() {
		return newsDAO.findLastestTenNews();
	}
	
	/*
	 * ��Ӹ�������(non-Javadoc)
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
	 * ���渽��
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
	 * ��������(non-Javadoc)
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
	 * �����޸�������(non-Javadoc)
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
	 * ɾ��ĳ���ŵ����и���
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
	 * �������Ų��Ҹ���(non-Javadoc)
	 * @see cn.edu.xmu.course.service.INewsService#findAttachmentByNews(cn.edu.xmu.course.pojo.News)
	 */
	public List<Attachment> findAttachmentByNews(News news){
		return attachmentDAO.findByProperty("news", news);
	}
	
	/*
	 * ɾ������(non-Javadoc)
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
	 * ��������
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
	 * ������������(non-Javadoc)
	 * @see cn.edu.xmu.course.service.INewsService#findAllNews()
	 */
	public List findAllNews() {
		// TODO Auto-generated method stub
		return newsDAO.findAll();
	}

	/*
	 * ����Id��������(non-Javadoc)
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
