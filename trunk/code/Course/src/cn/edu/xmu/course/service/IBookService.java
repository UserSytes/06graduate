package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Book;
import cn.edu.xmu.course.pojo.Course;

/**
 * 参考书籍
 * @author 何申密
 * @author 许子彦
 *
 */
public interface IBookService {

	/**
	 * 查找该课程所有参考书籍
	 * @param course
	 * @return
	 */
	public List<Book> getAllBooks(Course course);
	
	/**
	 * 查找参考书籍
	 * @param id
	 * @return
	 */
	public Book getBookById(Integer id);
	
	/**
	 * 添加参考书籍
	 * @param book
	 * @param course
	 * @param upload
	 * @return
	 */
	public boolean addBook(Book book, Course course, File upload);
	
	/**
	 * 更新参考书籍
	 * @param book
	 * @param upload
	 * @return
	 */
	public boolean updateBook(Book book, File upload);
	
	/**
	 * 删除参考书籍
	 * @param book
	 * @return
	 */
	public boolean deleteBook(Book book);
}
