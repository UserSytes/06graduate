package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.pojo.Book;
import cn.edu.xmu.course.service.IBookService;
/**
 * 负责参考书籍的类
 * @author 何申密
 * @author 许子彦
 *
 */
public class BookAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5817586834002918821L;
	private List<Book> bookList; // 参考书籍列表
	private Book book; // 参考书籍
	private Integer bookId; // 参考书籍ID

	private File upload; // 附件
	private String uploadContentType; // 文件类型
	private String uploadFileName; // 文件名称

	private IBookService bookService; // 负责参考书籍的接口

	@SuppressWarnings("unchecked")
	public String getBookListByCourse() {
		System.out.println(super.getCourse());
		bookList = bookService.getAllBooks(super.getCourse());
		return SUCCESS;
	}

	/**
	 * 添加参考书籍
	 * 
	 * @return
	 */
	public String addBook() {
		String fileLink = super.getTeacher().getUserInfo().getName() + "/"
				+ new Date().getTime() + "_" + super.getCourse().getName()
				+ "_" + uploadFileName;
		book.setFilename(uploadFileName);
		book.setFileLink(fileLink);
		if (bookService.addBook(book, super.getCourse(), upload))
			return SUCCESS;
		else {
			addActionError("添加参考书籍失败，请重新添加！");
			return ERROR;
		}
	}

	/**
	 * 跳转到编辑参考书籍
	 * 
	 * @return
	 */
	public String goEditBook() {
		book = bookService.getBookById(bookId);
		return SUCCESS;
	}

	/**
	 * 更新参考书籍
	 * 
	 * @return
	 */
	public String updateBook() {
		String fileLink = super.getPreFileNameByTeacher() + uploadFileName;
		book.setFilename(uploadFileName);
		book.setFileLink(fileLink);
		if (bookService.updateBook(book, upload))
			return SUCCESS;
		else {
			addActionError("更新参考书籍失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 删除参考书籍
	 * 
	 * @return
	 */
	public String deleteBook() {
		Book delBook = bookService.getBookById(bookId);
		if (bookService.deleteBook(delBook))
			return SUCCESS;
		else {
			addActionError("删除参考书籍失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 根据ID查找参考书籍
	 * 
	 * @return
	 */
	public String getBookById() {
		book = bookService.getBookById(bookId);
		if (book == null)
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
