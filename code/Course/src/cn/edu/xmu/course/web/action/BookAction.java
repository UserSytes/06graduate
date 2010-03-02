package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.pojo.Book;
import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseMovie;
import cn.edu.xmu.course.pojo.Courseware;
import cn.edu.xmu.course.pojo.Examination;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.IBookService;
import cn.edu.xmu.course.service.IChapterService;
import cn.edu.xmu.course.service.ICourseMovieService;
import cn.edu.xmu.course.service.ICoursewareService;
import cn.edu.xmu.course.service.IExaminationService;

public class BookAction extends BaseAction {

	private List<Book> bookList;
	private Book book;
	private Integer bookId;
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;

	private IBookService bookService;

	public String getBookListByCourse() {
		System.out.println(super.getCourse());
		bookList = bookService.getAllBooks(super.getCourse());
		return SUCCESS;
	}

	public String addBook() {
		String fileLink = super.getTeacher().getUserInfo().getName() + "/"
		+ new Date().getTime()+"_"+super.getCourse().getName() + "_" + uploadFileName;
		book.setFilename(uploadFileName);
		book.setFileLink(fileLink);
		if (bookService.addBook(book, super.getCourse(), upload))
			return SUCCESS;
		else {
			addActionError("添加参考书籍失败，请重新添加！");
			return ERROR;
		}
	}

	public String goEditBook() {
		book = bookService.getBookById(bookId);		
		return SUCCESS;
	}

	public String updateBook() {
		String fileLink = super.getPreFileNameByTeacher() + uploadFileName;
		book.setFilename(uploadFileName);
		book.setFileLink(fileLink);
		if (bookService.updateBook(book,upload))
			return SUCCESS;
		else {
			addActionError("更新参考书籍失败，请重新操作！");
			return ERROR;
		}
	}

	public String deleteBook() {
		Book delBook = bookService.getBookById(bookId);
		if (bookService.deleteBook(delBook))
			return SUCCESS;
		else {
			addActionError("删除参考书籍失败，请重新操作！");
			return ERROR;
		}
	}

	public String getBookById(){
		book = bookService.getBookById(bookId);
		if (book==null)
			return ERROR;
		else {
			return SUCCESS;
		}
	}
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	
	

}
