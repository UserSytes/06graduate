package cn.edu.xmu.course.pojo;

import java.util.Date;

/**
 * Examination entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Examination implements java.io.Serializable {

	// Fields

	private Integer id;
	private TeacherCourse teacherCourse;
	private String title;
	private String filename;
	private Date time;
	private String author;
	private String fileLink;

	// Constructors

	/** default constructor */
	public Examination() {
	}

	/** minimal constructor */
	public Examination(String title, String filename, Date time) {
		this.title = title;
		this.filename = filename;
		this.time = time;
	}

	/** full constructor */
	public Examination(TeacherCourse teacherCourse, String title,
			String filename, Date time, String author, String fileLink) {
		this.teacherCourse = teacherCourse;
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

	public TeacherCourse getTeacherCourse() {
		return this.teacherCourse;
	}

	public void setTeacherCourse(TeacherCourse teacherCourse) {
		this.teacherCourse = teacherCourse;
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