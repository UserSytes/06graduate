package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.pojo.Book;
import cn.edu.xmu.course.service.IBookService;
/**
 * ����ο��鼮����
 * @author ������
 * @author ������
 *
 */
public class BookAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5817586834002918821L;
	private List<Book> bookList; // �ο��鼮�б�
	private Book book; // �ο��鼮
	private Integer bookId; // �ο��鼮ID

	private File upload; // ����
	private String uploadContentType; // �ļ�����
	private String uploadFileName; // �ļ�����

	private IBookService bookService; // ����ο��鼮�Ľӿ�

	@SuppressWarnings("unchecked")
	public String getBookListByCourse() {
		System.out.println(super.getCourse());
		bookList = bookService.getAllBooks(super.getCourse());
		return SUCCESS;
	}

	/**
	 * ��Ӳο��鼮
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
			addActionError("��Ӳο��鼮ʧ�ܣ���������ӣ�");
			return ERROR;
		}
	}

	/**
	 * ��ת���༭�ο��鼮
	 * 
	 * @return
	 */
	public String goEditBook() {
		book = bookService.getBookById(bookId);
		return SUCCESS;
	}

	/**
	 * ���²ο��鼮
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
			addActionError("���²ο��鼮ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ɾ���ο��鼮
	 * 
	 * @return
	 */
	public String deleteBook() {
		Book delBook = bookService.getBookById(bookId);
		if (bookService.deleteBook(delBook))
			return SUCCESS;
		else {
			addActionError("ɾ���ο��鼮ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ����ID���Ҳο��鼮
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
