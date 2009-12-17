package cn.edu.xmu.course.pojo;

import java.util.Date;

/**
 * CourseInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class CourseInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Course course;
	private String title;
	private String content;
	private Date time;
	private Integer sort;

	// Constructors

	/** default constructor */
	public CourseInfo() {
	}

	/** minimal constructor */
	public CourseInfo(String title, String content, Date time, Integer sort) {
		this.title = title;
		this.content = content;
		this.time = time;
		this.sort = sort;
	}

	/** full constructor */
	public CourseInfo(Course course, String title, String content, Date time,
			Integer sort) {
		this.course = course;
		this.title = title;
		this.content = content;
		this.time = time;
		this.sort = sort;
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

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}