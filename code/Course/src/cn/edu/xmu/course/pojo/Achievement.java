package cn.edu.xmu.course.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Achievement entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Achievement implements java.io.Serializable {

	// Fields

	private Integer id;
	private TeacherCourse teacherCourse;
	private String title;
	private String content;
	private Date time;
	private Set attachments = new HashSet(0);

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
	public Achievement(TeacherCourse teacherCourse, String title,
			String content, Date time, Set attachments) {
		this.teacherCourse = teacherCourse;
		this.title = title;
		this.content = content;
		this.time = time;
		this.attachments = attachments;
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

	public Set getAttachments() {
		return this.attachments;
	}

	public void setAttachments(Set attachments) {
		this.attachments = attachments;
	}

}