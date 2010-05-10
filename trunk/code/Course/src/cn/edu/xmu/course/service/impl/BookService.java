package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.BookDAO;
import cn.edu.xmu.course.pojo.Book;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.service.IBookService;

public class BookService implements IBookService {

	private BookDAO bookDAO;

	public boolean addBook(Book book, Course course, File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + book.getFileLink();
		File file = new File(fileName);
		book.setCourse(course);
		try {			
			if (FileOperation.copy(upload, file)){
				bookDAO.save(book);
				return true;
			}				
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteBook(Book book) {
		// TODO Auto-generated method stub
		try {
			bookDAO.delete(book);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List getAllBooks(Course course) {
		// TODO Auto-generated method stub
		return bookDAO.findByCourse(course);
	}

	public Book getBookById(Integer id) {
		// TODO Auto-generated method stub
		return bookDAO.findById(id);
	}

	public boolean updateBook(Book book, File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + book.getFileLink();
		File file = new File(fileName);
		try {			
			if (FileOperation.copy(upload, file)){
				bookDAO.merge(book);
				return true;
			}				
			else
				return false;
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

}
