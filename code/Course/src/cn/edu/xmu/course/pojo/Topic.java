package cn.edu.xmu.course.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Topic entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Topic implements java.io.Serializable {

	// Fields

	private Integer id;
	private TeacherCourse teacherCourse;
	private String name;
	private Date time;
	private String authorName;
	private String lastAnswer;
	private Set messages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** minimal constructor */
	public Topic(String name, Date time, String authorName) {
		this.name = name;
		this.time = time;
		this.authorName = authorName;
	}

	/** full constructor */
	public Topic(TeacherCourse teacherCourse, String name, Date time,
			String authorName, String lastAnswer, Set messages) {
		this.teacherCourse = teacherCourse;
		this.name = name;
		this.time = time;
		this.authorName = authorName;
		this.lastAnswer = lastAnswer;
		this.messages = messages;
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

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getLastAnswer() {
		return this.lastAnswer;
	}

	public void setLastAnswer(String lastAnswer) {
		this.lastAnswer = lastAnswer;
	}

	public Set getMessages() {
		return this.messages;
	}

	public void setMessages(Set messages) {
		this.messages = messages;
	}

}