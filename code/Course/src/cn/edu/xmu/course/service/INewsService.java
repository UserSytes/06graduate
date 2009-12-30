package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

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
	 * ��������
	 * @param news
	 * @return
	 */
	public boolean updateNews(News news);
	
	/**
	 * ����id��������
	 * @param id
	 * @return
	 */
	public News findNewsById(int id);
}
