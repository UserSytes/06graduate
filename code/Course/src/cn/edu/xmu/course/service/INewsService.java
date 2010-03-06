package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Attachment;
import cn.edu.xmu.course.pojo.News;

/**
 * ��վ���ŷ���
 * @author ֣����
 * @author �Ժ���
 *
 */
public interface INewsService {

	/**
	 * ������������
	 * @return
	 */
	public List findAllNews();
	
	/**
	 * �������ţ��޸�����
	 * @param news
	 * @return
	 */
	public boolean addNewsWithoutAttachment(News news);
	
	/**
	 * ��������(������)
	 * @param news
	 * @param uploads
	 * @param uploadsContentType
	 * @param uploadsFileName
	 * @return
	 */
	public boolean addNews(News news,File[] uploads, String[] myFileContentType, String[] myFileFileName);
	
	/**
	 * ɾ������
	 * @param news
	 * @return
	 */
	public boolean deleteNews(News news); 
	
	/**
	 * ����id��������
	 * @param id
	 * @return
	 */
	public News findNewsById(int id);
	
	/**
	 * ����ĳ���ŵĸ���
	 * @param news
	 * @return
	 */
	public List<Attachment> findAttachmentByNews(News news);
	
	/**
	 * �޸����š��޸ĸ���
	 * @param news
	 * @param uploads
	 * @param myFileContentType
	 * @param myFileFileName
	 * @return
	 */
	public boolean updateNews(News news, File[] uploads, String[] myFileContentType, String[] myFileFileName);
	
	/**
	 * �޸����ţ����޸ĸ���
	 * @param news
	 * @return
	 */
	public boolean updateNewsWithoutAttachment(News news);
}
