package cn.edu.xmu.course.pojo;

import java.util.Date;

/**
 * Exercise entity. @author MyEclipse Persistence Tools
 */

public class Exercise implements java.io.Serializable {

	// Fields

	private Integer id;
	private Chapter chapter;
	private String title;
	private String filename;
	private Date time;
	private String fileLink;
	private String author;

	// Constructors

	/** default constructor */
	public Exercise() {
	}

	/** minimal constructor */
	public Exercise(String title, String filename, Date time) {
		this.title = title;
		this.filename = filename;
		this.time = time;
	}

	/** full constructor */
	public Exercise(Chapter chapter, String title, String filename, Date time,
			String fileLink,String author) {
		this.chapter = chapter;
		this.title = title;
		this.filename = filename;
		this.time = time;
		this.fileLink = fileLink;
		this.author = author;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Chapter getChapter() {
		return this.chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	public String getFileLink() {
		return this.fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

}