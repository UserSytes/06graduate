package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Attachment;
import cn.edu.xmu.course.pojo.News;

/**
 * 网站新闻发布
 * @author 郑冰凌
 * @author 赵海虹
 *
 */
public interface INewsService {

	/**
	 * 查找所有新闻
	 * @return
	 */
	public List findAllNews();
	
	/**
	 * 发布新闻（无附件）
	 * @param news
	 * @return
	 */
	public boolean addNewsWithoutAttachment(News news);
	
	/**
	 * 发布新闻(带附件)
	 * @param news
	 * @param uploads
	 * @param uploadsContentType
	 * @param uploadsFileName
	 * @return
	 */
	public boolean addNews(News news,File[] uploads, String[] myFileContentType, String[] myFileFileName);
	
	/**
	 * 删除新闻
	 * @param news
	 * @return
	 */
	public boolean deleteNews(News news); 
	
	/**
	 * 根据id查找新闻
	 * @param id
	 * @return
	 */
	public News findNewsById(int id);
	
	/**
	 * 查找某新闻的附件
	 * @param news
	 * @return
	 */
	public List<Attachment> findAttachmentByNews(News news);
	
	/**
	 * 修改新闻、修改附件
	 * @param news
	 * @param uploads
	 * @param myFileContentType
	 * @param myFileFileName
	 * @return
	 */
	public boolean updateNews(News news, File[] uploads, String[] myFileContentType, String[] myFileFileName);
	
	/**
	 * 修改新闻，不修改附件
	 * @param news
	 * @return
	 */
	public boolean updateNewsWithoutAttachment(News news);
}
