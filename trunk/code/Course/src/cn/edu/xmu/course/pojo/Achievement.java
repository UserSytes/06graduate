package cn.edu.xmu.course.pojo;

import java.util.Date;

/**
 * Achievement entity. @author MyEclipse Persistence Tools
 */

public class Achievement implements java.io.Serializable {

	// Fields

	private Integer id;
	private Course course;
	private String title;
	private String content;
	private Date time;
	private String fileName;
	private String fileLink;

	// Constructors

	/** default constructor */
	public Achievement() {
	}

	/** minimal constructor */
	public Achievement(String title, String content, Date time) {
		this.title = title;
		this.content = content;
		this.time = time;
	}

	/** full constructor */
	public Achievement(Course course, String title, String content, Date time,
			String fileName, String fileLink) {
		this.course = course;
		this.title = title;
		this.content = content;
		this.time = time;
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