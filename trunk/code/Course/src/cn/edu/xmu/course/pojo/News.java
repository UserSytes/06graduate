package cn.edu.xmu.course.pojo;

import java.util.Date;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String content;
	private Date time;
	private String author;
	private String fileName;
	private String fileLink;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(String title, String content, Date time, String author) {
		this.title = title;
		this.content = content;
		this.time = time;
		this.author = author;
	}

	/** full constructor */
	public News(String title, String content, Date time, String author,
			String fileName, String fileLink) {
		this.title = title;
		this.content = content;
		this.time = time;
		this.author = author;
		this.fileName = fileName;
		this.fileLink = fileLink;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileLink() {
		return this.fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}

}