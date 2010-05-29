package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.BookDAO;
import cn.edu.xmu.course.dao.NoticeDAO;
import cn.edu.xmu.course.pojo.Book;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.service.IBookService;

/**
 * �ο��鼮
 * 
 * @author ������
 * @author ������
 * 
 */
public class BookService implements IBookService {

	private BookDAO bookDAO;
	private NoticeDAO noticeDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IBookService#addBook(cn.edu.xmu.course.pojo
	 * .Book, cn.edu.xmu.course.pojo.Course, java.io.File)
	 */
	public boolean addBook(Book book, Course course, File upload) {
		// TODO Auto-generated method stub
		book.setCourse(course);
		String title = "����鼮��" + book.getName() + "��";
		String content = "<p>������²ο��鼮��" + book.getName() + "������ͬѧ��ע����ġ�</p>";
		Notice notice = new Notice(course, title, content, new Date(), 1);
		try {
			if (upload != null) {
				String path = ServletActionContext.getServletContext()
						.getRealPath("/upload");
				String fileName = path + "/" + book.getFileLink();
				File file = new File(fileName);
				if (!FileOperation.copy(upload, file))
					return false;
			} else {
				book.setFileLink("");
				book.setFilename("");
			}
			bookDAO.save(book);
			noticeDAO.save(notice);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IBookService#deleteBook(cn.edu.xmu.course.pojo
	 * .Book)
	 */
	public boolean deleteBook(Book book) {
		// TODO Auto-generated method stub
		try {
			bookDAO.delete(book);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IBookService#getAllBooks(cn.edu.xmu.course.
	 * pojo.Course)
	 */
	public List<Book> getAllBooks(Course course) {
		// TODO Auto-generated method stub
		return bookDAO.findByCourse(course);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IBookService#getBookById(java.lang.Integer)
	 */
	public Book getBookById(Integer id) {
		// TODO Auto-generated method stub
		return bookDAO.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.edu.xmu.course.service.IBookService#updateBook(cn.edu.xmu.course.pojo
	 * .Book, java.io.File)
	 */
	public boolean updateBook(Book book, File upload) {
		// TODO Auto-generated method stub
		String title = "�޸Ĳο��鼮��" + book.getName() + "��";
		String content = "<p>�޸����вο��鼮��" + book.getName() + "������ͬѧ��ע����ġ�</p>";
		Notice notice = new Notice(book.getCourse(), title, content,
				new Date(), 1);
		try {
			if (upload != null) {
				String path = ServletActionContext.getServletContext()
						.getRealPath("/upload");
				String fileName = path + "/" + book.getFileLink();
				File file = new File(fileName);
				if (!FileOperation.copy(upload, file))
					return false;
			} else {
				book.setFileLink("");
				book.setFilename("");
			}
			bookDAO.merge(book);
			noticeDAO.save(notice);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

}
