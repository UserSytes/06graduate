package cn.edu.xmu.course.pojo;

import java.util.Date;

/**
 * Book entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private Integer id;
	private TeacherCourse teacherCourse;
	private String name;
	private String filename;
	private Date time;
	private String author;
	private String publication;
	private String fileLink;

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(String name, String filename, Date time) {
		this.name = name;
		this.filename = filename;
		this.time = time;
	}

	/** full constructor */
	public Book(TeacherCourse teacherCourse, String name, String filename,
			Date time, String author, String publication, String fileLink) {
		this.teacherCourse = teacherCourse;
		this.name = name;
		this.filename = filename;
		this.time = time;
		this.author = author;
		this.publication = publication;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPublication() {
		return this.publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getFileLink() {
		return this.fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}

}