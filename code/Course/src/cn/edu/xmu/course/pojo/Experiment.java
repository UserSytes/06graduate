package cn.edu.xmu.course.pojo;

import java.util.Date;

/**
 * Experiment entity. @author MyEclipse Persistence Tools
 */

public class Experiment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Chapter chapter;
	private String title;
	private String filename;
	private Date time;
	private String author;
	private String fileLink;

	// Constructors

	/** default constructor */
	public Experiment() {
	}

	/** minimal constructor */
	public Experiment(String title, String filename, Date time) {
		this.title = title;
		this.filename = filename;
		this.time = time;
	}

	/** full constructor */
	public Experiment(Chapter chapter, String title, String filename,
			Date time, String author, String fileLink) {
		this.chapter = chapter;
		this.title = title;
		this.filename = filename;
		this.time = time;
		this.author = author;
		this.fileLink = fileLink;
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

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFileLink() {
		return this.fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}

}