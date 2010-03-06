package cn.edu.xmu.course.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.AttachmentDAO;
import cn.edu.xmu.course.dao.NewsDAO;
import cn.edu.xmu.course.pojo.Attachment;
import cn.edu.xmu.course.pojo.News;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.INewsService;

public class NewsService implements INewsService {

	private NewsDAO newsDAO;
	private AttachmentDAO attachmentDAO;
	
	private static final int BUFFER_SIZE = 16 * 1024;

	
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
//		InputStream in = null;
//		OutputStream ou = null;
		try {
			/*
			 * 
			 * 开始上传多个附件
			 */
			for (int i = 0; i < myFileFileName.length; i++) {
//
//				ServletContext context = ServletActionContext.getServletContext();
//				String realPath = context.getRealPath("/");// 得到服务器的路径
//				Runtime rt = Runtime.getRuntime();
//				rt.exec("cmd.exe" + " /c" + " md " + realPath + "newsUpload");// 在服务器下建立文件夹
//
//				int par = myFileFileName[i].lastIndexOf(".");// 对最后一个“.”结束的文件定位
//				String fin = myFileFileName[i].substring(par);// 截取扩展名
//				String fileName = new Date().getTime() + i + fin;// 以时间命名
//				File file = new File(ServletActionContext.getServletContext().getRealPath("/newsUpload")
//						+ "\\" + fileName);// newsUpload下新建文件
//				in = new BufferedInputStream(new FileInputStream(myFile[i]),BUFFER_SIZE);
//				ou = new BufferedOutputStream(new FileOutputStream(file),BUFFER_SIZE);
//				byte[] buffer = new byte[BUFFER_SIZE];
//	
//				while (in.read(buffer) > 0) {
//					ou.write(buffer);// 读写文件
//				}
				String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
				String fileName = path + "/newsUpload/" + myFileFileName[i];
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
			return false;}
//		} finally {
//			// 关闭流
//			try {
//				if (null != in) {
//					in.close();
//				}
//				if (null != ou) {
//					ou.close();
//				}
//			} catch (Exception e) {
//			}
//		}
		return true;
	}
	
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
	
	public boolean saveAttachment(Attachment attachment){
		try{
			attachmentDAO.save(attachment);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
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
	
	public List<Attachment> findAttachmentByNews(News news){
		return attachmentDAO.findByProperty("news", news);
	}
	
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

	public boolean updateNews(News news){
		try {
			newsDAO.merge(news);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public List findAllNews() {
		// TODO Auto-generated method stub
		return newsDAO.findAll();
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

	public AttachmentDAO getAttachmentDAO() {
		return attachmentDAO;
	}

	public void setAttachmentDAO(AttachmentDAO attachmentDAO) {
		this.attachmentDAO = attachmentDAO;
	}

}
