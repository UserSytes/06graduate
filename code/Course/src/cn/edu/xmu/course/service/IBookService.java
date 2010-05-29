package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Book;
import cn.edu.xmu.course.pojo.Course;

/**
 * �ο��鼮
 * @author ������
 * @author ������
 *
 */
public interface IBookService {

	/**
	 * ���Ҹÿγ����вο��鼮
	 * @param course
	 * @return
	 */
	public List<Book> getAllBooks(Course course);
	
	/**
	 * ���Ҳο��鼮
	 * @param id
	 * @return
	 */
	public Book getBookById(Integer id);
	
	/**
	 * ��Ӳο��鼮
	 * @param book
	 * @param course
	 * @param upload
	 * @return
	 */
	public boolean addBook(Book book, Course course, File upload);
	
	/**
	 * ���²ο��鼮
	 * @param book
	 * @param upload
	 * @return
	 */
	public boolean updateBook(Book book, File upload);
	
	/**
	 * ɾ���ο��鼮
	 * @param book
	 * @return
	 */
	public boolean deleteBook(Book book);
}
