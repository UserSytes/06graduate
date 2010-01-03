package cn.edu.xmu.course.pojo;

import java.util.Date;

/**
 * CourseMovie entity. @author MyEclipse Persistence Tools
 */

public class CourseMovie implements java.io.Serializable {

	// Fields

	private Integer id;
	private Course course;
	private String title;
	private String filename;
	private Date time;
	private String author;
	private String fileLink;
	private String position;
	private String content;

	// Constructors

	/** default constructor */
	public CourseMovie() {
	}

	/** minimal constructor */
	public CourseMovie(String title, String filename, Date time) {
		this.title = title;
		this.filename = filename;
		this.time = time;
	}

	/** full constructor */
	public CourseMovie(Course course, String title, String filename, Date time,
			String author, String fileLink, String position, String content) {
		this.course = course;
		this.title = title;
		this.filename = filename;
		this.time = time;
		this.author = author;
		this.fileLink = fileLink;
		this.position = position;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}