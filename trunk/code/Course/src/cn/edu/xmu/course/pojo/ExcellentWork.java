package cn.edu.xmu.course.pojo;

import java.util.Date;

/**
 * ExcellentWork entity. @author MyEclipse Persistence Tools
 */

public class ExcellentWork implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String filename;
	private Date time;
	private String author;
	private String fileLink;
	private String reason;
	private Course course;

	// Constructors

	/** default constructor */
	public ExcellentWork() {
	}

	/** minimal constructor */
	public ExcellentWork(String title, String filename, Date time) {
		this.title = title;
		this.filename = filename;
		this.time = time;
	}

	/** full constructor */
	public ExcellentWork(String title, String filename, Date time,
			String author, String fileLink, String reason, Course course) {
		this.title = title;
		this.filename = filename;
		this.time = time;
		this.author = author;
		this.fileLink = fileLink;
		this.reason = reason;
		this.course = course;
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

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}


	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}