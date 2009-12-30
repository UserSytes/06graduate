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
	
	public boolean addNews(News news, File[] myFile, String[] myFileContentType, String[] myFileFileName) {
		// TODO Auto-generated method stub
		Date nowDate = new Date();
		news.setTime(nowDate);
		try{
			newsDAO.save(news);
		}catch(Exception e){
			return false;
		}
		
		// �ϴ�����
		InputStream in = null;
		OutputStream ou = null;
		try {
			/*
			 * 
			 * ��ʼ�ϴ��������
			 */
			for (int i = 0; i < myFileFileName.length; i++) {

				ServletContext context = ServletActionContext.getServletContext();
				String realPath = context.getRealPath("/");// �õ���������·��
				Runtime rt = Runtime.getRuntime();
				rt.exec("cmd.exe" + " /c" + " md " + realPath + "newsUpload");// �ڷ������½����ļ���

				int par = myFileFileName[i].lastIndexOf(".");// �����һ����.���������ļ���λ
				String fin = myFileFileName[i].substring(par);// ��ȡ��չ��
				String fileName = new Date().getTime() + i + fin;// ��ʱ������
				File file = new File(ServletActionContext.getServletContext().getRealPath("/newsUpload")
						+ "\\" + fileName);// newsUpload���½��ļ�
				in = new BufferedInputStream(new FileInputStream(myFile[i]),BUFFER_SIZE);
				ou = new BufferedOutputStream(new FileOutputStream(file),BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
	
				while (in.read(buffer) > 0) {
					ou.write(buffer);// ��д�ļ�
				}

				Attachment attachment = new Attachment();
				attachment.setFileLink(fileName);
				attachment.setFilename(myFileFileName[i]);
				attachment.setNews(news);
				boolean result = this.saveAttachment(attachment);
				if(!result){
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		} finally {
			// �ر���
			try {
				if (null != in) {
					in.close();
				}
				if (null != ou) {
					ou.close();
				}
			} catch (Exception e) {
			}
		}
		return true;
	}
	
	public boolean saveAttachment(Attachment attachment){
		try{
			attachmentDAO.save(attachment);
			return true;
		}catch(Exception e){
			return false;
		}
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
