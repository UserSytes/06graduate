package cn.edu.xmu.course.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
	private Date lastEditTime;
	private Integer count;
	private Set attachments = new HashSet(0);

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
			Date lastEditTime, Integer count, Set attachments) {
		this.title = title;
		this.content = content;
		this.time = time;
		this.author = author;
		this.lastEditTime = lastEditTime;
		this.count = count;
		this.attachments = attachments;
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

	public Date getLastEditTime() {
		return this.lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Set getAttachments() {
		return this.attachments;
	}

	public void setAttachments(Set attachments) {
		this.attachments = attachments;
	}

}